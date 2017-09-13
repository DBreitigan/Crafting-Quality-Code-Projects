#include <stdlib.h>

struct myStruct
{
    int x;
    int y;
    int z;
} MYSTRUCT, *MYSTRUCTPTR;

int main()
{
    struct myStruct *current[10];
    for (int i=0;i<10;i++)
    {   current[i] = (struct myStruct *)malloc(sizeof MYSTRUCT);
        current[i]->x = i;
        current[i]->y = i;
        current[i]->z = i;
    }
    free (current[3]);
    free (current[6]);
    free (current[7]);
}
