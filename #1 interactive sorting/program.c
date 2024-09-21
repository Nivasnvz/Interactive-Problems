#include <stdio.h>
#include <string.h>

// Implicit declaration
int isequal(char e[20], char e1[20], char a[100][20], int n);
int removes(char co[100][20], int n);
void swap(int s, int s1, char a[100][20]);

int main() {

    char a[100][20], b[100][20], sm[100][20];
    char co[200][20];

    int i = 0, j = 0, k = 0;
    
    printf( "!! please press enter key with empty space if given values are enough...");
    printf("\n");
    printf("\n");


    // Get the values until the user stops
    for (; i < 100; i++)
    {
        fgets(a[i], 20, stdin);
        if (a[i][0] == '\n') break;
        a[i][strcspn(a[i], "\n")] = '\0';  // Remove the empty space
    }

    // Making the possible comparisons

    for (; j < i - 1; j++)
    {
        printf("%s ? %s : ", a[j], a[j + 1]);
        char s;
        scanf(" %c", &s);

        if (s == '<')
        {
            strcpy(b[j], a[j + 1]);
            strcpy(sm[j], a[j]);
        } else if (s == '>')
        {
            strcpy(b[j], a[j]);
            strcpy(sm[j], a[j + 1]);
        }
    }

    // Combine both greater and smaller arrays

    for (int m = 0; m < j; m++)
    {
        strcpy(co[k++], b[m]);
    }

    for (int m = 0; m < j; m++)
    {
        strcpy(co[k++], sm[m]);
    }


    int con = removes(co, k);

    // checking the possible comparison in co array if it has already happened or not

    for (int l = 0; l < con - 1; l++)
    {
        if (!isequal(co[l], co[l + 1], a, i))
        {
            printf("%s ? %s : ", co[l], co[l + 1]);
            char s;
            scanf(" %c", &s);
            if (s == '<') {
                swap(l, l + 1, co);
            }
        }
    }

    // Print the final array values

    printf("\n");
    printf("\n Sorting order : ");
    for (int m = 0; m < con; m++)
    {
        printf("%s ", co[m]);
    }

    return 0;
}

int isequal(char e[20], char e1[20], char a[100][20], int n)
{
    for (int j = 0; j < n - 1; j++)
    {
        if ((strcmp(e, a[j]) == 0 && strcmp(e1, a[j + 1]) == 0) ||
                (strcmp(e1, a[j]) == 0 && strcmp(e, a[j + 1]) == 0)) {
            return 1;
        }
    }

    if (strcmp(e, e1) == 0)
    {
        return 1;
    }

    return 0;
}

// Function to remove duplicates from array 'co'

int removes(char co[100][20], int n)
{
    int j, k, l;

    for (j = 0; j < n; j++)
    {
        for (k = j + 1; k < n;)
        {
            if (strcmp(co[j], co[k]) == 0)
            {

                for (l = k; l < n - 1; l++)
                {
                    strcpy(co[l], co[l + 1]);
                }
                
                n--;
            } 
            
            else
            {
                k++;
            }
        }
    }

    return n;  // Return the new size of the array
}

void swap(int s, int s1, char a[100][20])
{
    char temp[20];
    strcpy(temp, a[s]);
    strcpy(a[s], a[s1]);
    strcpy(a[s1], temp);
}
