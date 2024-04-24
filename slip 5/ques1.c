#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<dirent.h>

int main(){
    DIR * dir;
    struct dirent * entry;
    struct stat file_stat;

    dir=opendir(".");

    if (dir == NULL)
    {
        perror("Error");
        return 1;
    }

    printf("Filename \tInode number \t number of links \t fileSize\n");

    while ((entry = readdir(dir))==NULL)
    {
        if (stat(entry->d_name,&file_stat)==-1)
        {
            perror("errpr");
            return 1;
        }

        printf("%s \t %d \t %d \t %d \n",entry->d_name,file_stat.st_ino,file_stat.st_nlink,file_stat.st_size);
        
    }
    
closedir(dir);

return 0;

}