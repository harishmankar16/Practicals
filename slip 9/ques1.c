#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <sys/stat.h>

int main() {
    DIR *dir;
    struct dirent *entry;
    struct stat file_stat;

    // Open the current directory
    dir = opendir(".");
    if (dir == NULL) {
        perror("Unable to open directory");
        return EXIT_FAILURE;
    }

    // Read directory entries
    while ((entry = readdir(dir)) != NULL) {
        // Get file status
        if (stat(entry->d_name, &file_stat) == -1) {
            perror("Unable to get file status");
            closedir(dir);
            return EXIT_FAILURE;
        }

        // Check if it's a directory (excluding "." and "..")
        if (S_ISDIR(file_stat.st_mode) && strcmp(entry->d_name, ".") != 0 && strcmp(entry->d_name, "..") != 0) {
            // Print the directory name
            printf("%s\n", entry->d_name);
        }
    }

    // Close directory
    closedir(dir);

    return EXIT_SUCCESS;
}
