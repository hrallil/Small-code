#include <stdio.h>
#include <stdlib.h>

int main(){
    int arr[5] = {3,2,1,4,7};
    int size = sizeof arr/sizeof arr[0];

    for(int i = 0; i < size; ++i){
        printf("%d\n", arr[i]);
    }

    //bubbleSort(arr,size);
    mergeSort(arr,0,size);


    for(int i = 0; i < size; ++i){
        printf("%d\n",arr[i]);
    }

    return 0;
}

void bubbleSort(int* arr, int size){
    printf("sorting ...\n");
    for(int i = 0; i< size - 1; ++i){
        for(int j = 0; j < size - 1 - i; ++j){
            if(arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;

            }
        }
    }
    printf("sorting done!");
}

void mergeSort(int* arr, int startOfArray, int endOfArray){

    if (startOfArray < endOfArray){
        int midOfArray = (int)(startOfArray+endOfArray)/2;
        mergeSort(arr, startOfArray, midOfArray);
        mergeSort(arr, startOfArray + 1, endOfArray);
        merge(arr, startOfArray, midOfArray, endOfArray);
    }
}

void merge(int* arr, int startOfArray, int midOfArray, int endOfArray){
    printf("merging\n");
    int n1 = midOfArray - startOfArray + 1;
    int n2 = endOfArray - midOfArray;
    int left[n1 + 1];
    int right[n2 +1];

    for(int i = 1; i < n1; ++i){
        left[i] = arr[startOfArray + i - 1];
    }
    for(int j = 1; j < n2; ++j){
        right[j] = arr[midOfArray + j];
    }
    // left[n1 + 1] = inf;
    // right[n2 + 1] = inf;

    int i = 1;
    int j = 1;
    for(int k = startOfArray; k < endOfArray; ++k){
        if(left[i]<= right[j]){
            arr[k] = left[i];
            ++i;
        }
        else{
            arr[k] = right[j];
            ++j;
        }
    }
}
