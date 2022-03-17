#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i;
    int amount;
    int sum = 0;
    int newNum;

    scanf("%d",&amount);
    for(i=1; i < amount + 1; ++i){
        scanf("%d", &newNum);
        sum = sum + newNum;
    }
    printf("%d",sum);

    return 0;
}
