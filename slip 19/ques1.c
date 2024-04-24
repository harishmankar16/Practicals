#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main() {
   
    int fd = open("example.txt", O_RDWR | O_CREAT, S_IRUSR | S_IWUSR);
    if (fd == -1) {
        perror("open");
        return EXIT_FAILURE;
    }

    // Write some content to the file
    const char *content = "Hello, World!";
    if (write(fd, content, strlen(content)) == -1) {
        perror("write");
        close(fd);
        return EXIT_FAILURE;
    }

    // Duplicate the file descriptor
    int new_fd = dup(fd);
    if (new_fd == -1) {
        perror("dup");
        close(fd);
        return EXIT_FAILURE;
    }

    // Move the read/write offset of the original file descriptor
    // This should also move the offset of the duplicated file descriptor
    if (lseek(fd, 6, SEEK_SET) == -1) {
        perror("lseek");
        close(fd);
        close(new_fd);
        return EXIT_FAILURE;
    }

    // Read from the original file descriptor
    char buffer[6];
    ssize_t bytes_read = read(fd, buffer, sizeof(buffer));
    if (bytes_read == -1) {
        perror("read");
        close(fd);
        close(new_fd);
        return EXIT_FAILURE;
    }
    buffer[bytes_read] = '\0'; // Null-terminate the string
    printf("Read from original file descriptor: %s\n", buffer);

    // Read from the duplicated file descriptor
    char dup_buffer[6];
    ssize_t dup_bytes_read = read(new_fd, dup_buffer, sizeof(dup_buffer));
    if (dup_bytes_read == -1) {
        perror("read");
        close(fd);
        close(new_fd);
        return EXIT_FAILURE;
    }
    dup_buffer[dup_bytes_read] = '\0'; // Null-terminate the string
    printf("Read from duplicated file descriptor: %s\n", dup_buffer);

    // Close file descriptors
    close(fd);
    close(new_fd);

    return EXIT_SUCCESS;
}
