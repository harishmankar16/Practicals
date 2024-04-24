#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <sys/time.h>

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <num_processes>\n", argv[0]);
        return EXIT_FAILURE;
    }

    int num_processes = atoi(argv[1]);
    pid_t pid;
    struct timeval start_time, end_time;
    long total_user_time = 0, total_kernel_time = 0;

    gettimeofday(&start_time, NULL);

    for (int i = 0; i < num_processes; i++) {
        pid = fork();

        if (pid < 0) {
            perror("fork");
            return EXIT_FAILURE;
        } else if (pid == 0) {
            // Child process
            exit(EXIT_SUCCESS);
        }
    }

    // Parent process
    for (int i = 0; i < num_processes; i++) {
        int status;
        struct rusage usage;

        if (wait(&status) == -1) {
            perror("wait");
            return EXIT_FAILURE;
        }

        if (getrusage(RUSAGE_CHILDREN, &usage) == -1) {
            perror("getrusage");
            return EXIT_FAILURE;
        }

        total_user_time += usage.ru_utime.tv_sec * 1000000 + usage.ru_utime.tv_usec;
        total_kernel_time += usage.ru_stime.tv_sec * 1000000 + usage.ru_stime.tv_usec;
    }

    gettimeofday(&end_time, NULL);

    long total_time = (end_time.tv_sec - start_time.tv_sec) * 1000000 + (end_time.tv_usec - start_time.tv_usec);

    printf("Total cumulative time spent by all children in user mode: %ld microseconds\n", total_user_time);
    printf("Total cumulative time spent by all children in kernel mode: %ld microseconds\n", total_kernel_time);
    printf("Total cumulative time spent by all children: %ld microseconds\n", total_time);

    return EXIT_SUCCESS;
}
