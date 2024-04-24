#include <stdio.h>
#include <sys/stat.h>
#include <stdlib.h>
#include <pwd.h>
#include <grp.h>
#include <time.h>

void displayFileAttributes(char *filename)
{

    struct stat fileStat;

    if (stat(filename, &fileStat) < 0)
    {

        perror("Error in stat");
    }

    printf("File type: ");

    if (S_ISREG(fileStat.st_mode))

        printf("Regular file\n");

    else if (S_ISDIR(fileStat.st_mode))

        printf("Directory\n");

    else if (S_ISCHR(fileStat.st_mode))

        printf("Character special file\n");

    else if (S_ISBLK(fileStat.st_mode))

        printf("Block special file\n");

    else if (S_ISFIFO(fileStat.st_mode))

        printf("FIFO (named pipe)\n");

    else if (S_ISLNK(fileStat.st_mode))

        printf("Symbolic link\n");

    else if (S_ISSOCK(fileStat.st_mode))

        printf("Socket\n");

    else

        printf("Unknown file type\n");

    printf("Permissions: ");

    printf((fileStat.st_mode & S_IRUSR) ? "r" : "-");

    printf((fileStat.st_mode & S_IWUSR) ? "w" : "-");

    printf((fileStat.st_mode & S_IXUSR) ? "x" : "-");

    printf((fileStat.st_mode & S_IRGRP) ? "r" : "-");

    printf((fileStat.st_mode & S_IWGRP) ? "w" : "-");

    printf((fileStat.st_mode & S_IXGRP) ? "x" : "-");

    printf((fileStat.st_mode & S_IROTH) ? "r" : "-");

    printf((fileStat.st_mode & S_IWOTH) ? "w" : "-");

    printf((fileStat.st_mode & S_IXOTH) ? "x" : "-");

    printf("\n");

    struct passwd *pw = getpwuid(fileStat.st_uid);

    printf("Owner name: %s\n", pw->pw_name);

    // Number of links
    printf("Number of links: %ld\n", (long)fileStat.st_nlink);

    // File size
    printf("File size: %lld bytes\n", (long long)fileStat.st_size);

    // File modification time
    printf("File modification time: %s", ctime(&fileStat.st_mtime));

    // Inode number
    printf("Inode number: %ld\n", (long)fileStat.st_ino);
    
    // File name
    printf("File name: %s\n", filename);
}

int main(int argc, char *argv[])
{
    if (argc != 2)

    {
        fprintf(stderr, "Usage : %s <filename>\n", argv[0]);

        return 0;
    }

    displayFileAttributes(argv[1]);

    return 0;
}
