#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>

int main(){
    int fd = open("test.txt",O_WRONLY | O_CREAT );
    if (fd == -1)
    {
        perror("open:");
        return 1;
    }

    const char * msg = "this is the data before hole";
    if (write(fd,msg,strlen(msg)) == -1)
    {
        perror("write");
        close(fd);
        return 1;
    }

    if (lseek(fd,1024,SEEK_CUR)==-1)
    {
        perror("seek");
        return 1;
    }

    const char * msg2 = "asd asd asd";
    if (write(fd,msg2,strlen(msg2)) == -1)
    {
        perror("write");
        close(fd);
        return 1;
    }

    close(fd);

    fd = open("test.txt",O_RDONLY);
    if (fd == -1) {
        perror("open");
        return EXIT_FAILURE;
    }

    char buffer[1024];
    ssize_t bytes_read = read(fd, buffer, sizeof(buffer));
    if (bytes_read == -1) {
        perror("read");
        close(fd);
        return EXIT_FAILURE;
    }

    // Print the data read
    printf("Data read from the file:\n%.*s\n", (int)bytes_read, buffer);
    
    
    
return 0;
}