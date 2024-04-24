#include<stdio.h>
#include<stdlib.h>
#include<sys/stat.h>

long getFileSize(const char *fileName)
{
	struct stat st;
	
	if(stat(fileName,&st) == 0)
	{
		return st.st_size;
	}
	else
	{
		return -1;
	}
	
}

int main(int argc,char *argv[])
{

if(argc<3)
{
	printf("Provide at least two files name as a command line argument\n");
	
	return 1;
}

int numFile =argc-1;

char **fileName = argv+1  ;

long fileSize[numFile];


for(int i=0;i<numFile;i++)
{
	fileSize[i] = getFileSize(fileName[i]);
	
	if(fileSize[i] == -1)
	{
		printf("%s is not a valid file name\n",fileName[i]);
		
		return 1;
	}
}

for(int i=0;i<numFile-1;i++)
{
	for(int j=i+1;j<numFile;j++)
	{
		if(fileSize[i] > fileSize[j])
		{
		
			long tempSize = fileSize[i];
			fileSize[i] = fileSize[j];
			fileSize[j] = tempSize;
			
			char *tempName = fileName[i];
			fileName[i] = fileName[j];
			fileName[j] = tempName;
		}
	}
}
printf("\n Files sorted by size\n");

for(int i=0;i<numFile;i++)
{
	printf("%s: %ld bytes\n",fileName[i],fileSize[i]);
}
return 0;
}

