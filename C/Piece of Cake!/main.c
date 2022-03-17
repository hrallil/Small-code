#include <stdio.h>
#include <stdlib.h>

int main()
{
    int maxSize;
    int height;
    int width;
    int bigWidth;
    int bigHeight;
    int cakeArea;

    scanf("%d %d %d", &maxSize, &height, &width);
    if(height > maxSize/2){
        bigHeight = height;
    }
    else{
        bigHeight = maxSize - height;
    }
    if(width > maxSize/2){
        bigWidth = width;
    }
    else{
        bigWidth = maxSize - width;
    }
    cakeArea = bigHeight * bigWidth * 4;
    printf("%d",cakeArea);
    return 0;
}
