#include <stdio.h>
#include <stdlib.h>

int main()
{
    char currentStop[20];
    char DB[100][20];
    int trips;
    int stops;
    int sum;
    scanf("%d",&trips);

    int i;
    for(i=1; i<trips+1; ++i){
        int j;
        scanf("%d",&stops);
        for(j=1;j<stops+1; ++i){
            gets(currentStop);
            if(currentStop not in DB){   /*pseudo code*/
                ++sum;
                add currentStop to DB
            }

        }
        printf("%d",sum)
    }



    return 0;
}

bool in_array(char str[], char arr[][]){
    equal
}
