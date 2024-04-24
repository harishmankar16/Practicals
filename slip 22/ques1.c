#include<stdlib.h>
#include<stdio.h>

int main(int argc,char * argv[]){
    if (argc !=2)
    {
        return 1;
    }

    char * fileName = argv[1];

    FILE * file = fopen(fileName,"r");
    if (file == NULL)
    {
        return 1;
    }

    int character;
    int teenthchar;
    int charCount = 0;

    while ((character=fgetc(file)) != EOF)
    {
        charCount++;
        if (charCount % 10 == 0)
        {
            teenthchar++;
            putchar(character);
        }
        

    }
    fclose(file);
    printf(teenthchar);
    return 0 ;
    
    
}