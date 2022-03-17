#include <stdio.h>
#include <stdlib.h>

int main(){
    char chr;
    char word[1000];
    char result[1000];
    int run = 1;

    scanf("%c", &chr);
    if(chr == "a"){

    }

    while(run == 1){
        scanf("%c",&chr);
        if(chr == NULL){
            run = 0;
        }

        strncat(word,&chr,1);

    }
    return 0;
}
