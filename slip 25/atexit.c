#include<stdio.h>
#include<stdlib.h>

void cleanUpFunction1(){
    printf("Doing clean up work, Closing files..");
}

void cleanUpFunction2(){
    printf("Doing cleanup work, freeing memory..");
}

int main(){
    printf("Main function started..");
    atexit(cleanUpFunction1);
    atexit(cleanUpFunction2);
    printf("Main function exiting..");

    return 0;
}