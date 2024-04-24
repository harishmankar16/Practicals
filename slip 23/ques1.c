#include <stdlib.h>
#include <stdio.h>

int main(int argc, char *argv[])
{
    if (argc != 3)
    {
        perror("error");
        return 1;
    }

    char *inputFileName = argv[1];
    char *outputFileName = argv[2];

    FILE *input_file = fopen(inputFileName, "r");
    if (input_file == NULL)
    {
        perror("Error input file");
        return 1;
    }

    FILE *output_file = fopen(outputFileName, "w");
    if (output_file == NULL)
    {
        perror("Error output file");
        return 1;
    }

    char buffer[256];
    size_t bytes_read;
    int alternative = 0;

    while ((bytes_read = fread(buffer, 1, 256, input_file)) > 0)
    {
        for (size_t i = 0; i < bytes_read; i++)
        {
            if (alternative)
            {
                fputc(buffer[i], output_file);
            }
            alternative = !alternative;
        }
    }

    fclose(input_file);
    fclose(output_file);

    printf("Alternate characters read from '%s' and written to '%s'.\n", inputFileName,outputFileName);
    return 0;
}