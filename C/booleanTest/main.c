#include <stdio.h>
#include <stdlib.h>
bool arr[2] = {true,false};
typedef enum{true,false} test;
int main()
{
    if(test){
        return 1;
    }
    else{
        return 0;
    }
}
