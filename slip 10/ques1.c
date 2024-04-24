#include<stdio.h>
#include<stdlib.h>
#include<fcntl.h>
#include<unistd.h>

int main(){
    int fd;
    fd = open("output.txt",O_WRONLY | O_CREAT | O_TRUNC,0664);
    if (fd == -1)
    {
        perror("error");
        return 1;
    }

    if (dup2(fd,STDOUT_FILENO) == -1)
    {
        perror("ERROR");
        return 1;
    }
    close(fd);

    printf("This will be redirect>>");

    return 0;
}