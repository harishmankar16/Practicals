#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <string.h>


void print_file_type(const char *filename) {
    struct stat file_stat;

    if (stat(filename, &file_stat) == -1) {
        perror("stat");
        return;
    }

    if (S_ISREG(file_stat.st_mode)) {
        printf("%s: Regular file\n", filename);
    } else if (S_ISDIR(file_stat.st_mode)) {
        printf("%s: Directory\n", filename);
    } else if (S_ISCHR(file_stat.st_mode)) {
        printf("%s: Character device\n", filename);
    } else if (S_ISBLK(file_stat.st_mode)) {
        printf("%s: Block device\n", filename);
    } else if (S_ISFIFO(file_stat.st_mode)) {
        printf("%s: FIFO or pipe\n", filename);
    } else if (S_ISLNK(file_stat.st_mode)) {
        printf("%s: Symbolic link\n", filename);
    } else if (S_ISSOCK(file_stat.st_mode)) {
        printf("%s: Socket\n", filename);
    } else {
        printf("%s: Unknown file type\n", filename);
    }
}

int main(int argc, char *argv[]) {
    if (argc < 2) {
        fprintf(stderr, "Usage: %s <filename1> <filename2> ... <filenameN>\n", argv[0]);
        return EXIT_FAILURE;
    }

    for (int i = 1; i < argc; i++) {
        print_file_type(argv[i]);
    }

    return EXIT_SUCCESS;
}
