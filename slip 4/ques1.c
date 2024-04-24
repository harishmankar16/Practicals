#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<string.h>

int main(){
    int pipefd[2];
    pid_t pid;

    if (pipe(pipefd) == -1)
    {
        perror("pipe");
        return;
    }

    pid = fork();

    if (pid == -1)
    {
        perror("Fork");
        return 1;
    }

    if (pid==0)
    {
        close(pipefd[0]);
        char * message [3]= { "hello world" , "Hello sppu" , "linux"};

        for (int i = 0; i < 3; i++)
        {
            write(pipefd[1],message[i],strlen(message)+1);
        }

        close(pipefd[1]);

        return 1;
        
    } else {
        close(pipefd[1]);
        char buffer[1024];
        printf("Messaes received :\n");
        while (read(pipefd[0],buffer,1024) > 0)
        {
            printf("%s\n", buffer);
        }

        close(pipefd[0]);
        return 1;
        
    }
    
    
    
    return 0;
}