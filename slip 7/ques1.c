#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <sys/stat.h>
#include <unistd.h>

int main() {
    DIR *dir;
    struct dirent *entry;
    struct stat file_stat;

 
    dir = opendir(".");
    if (dir == NULL) {
        perror("Unable to open directory");
        return EXIT_FAILURE;
    }

   
    while ((entry = readdir(dir)) != NULL) {
        // Get file status
        if (stat(entry->d_name, &file_stat) == -1) {
            perror("Unable to get file status");
            closedir(dir);
            return EXIT_FAILURE;
        }
        if (S_ISREG(file_stat.st_mode) && access(entry->d_name, W_OK) == 0) {
            // Print the filename
            printf("%s\n", entry->d_name);
        }
    }


    closedir(dir);

    return EXIT_SUCCESS;
}
