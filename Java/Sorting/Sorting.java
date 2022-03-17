import java.util.List;

public class Sorting {
    public Sorting() {
        
    }


    public static <T extends Comparable<T>> void bubbleSort(T[] list) {
        System.out.println("sorting Array...");
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if(list[j].compareTo(list[j+1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        System.out.println("sorting list...");
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if(list.get(j).compareTo(list.get(j+1)) > 0){
                    T temp = list.get(j);
                    list.add(j, list.get(j+1));
                    list.add(j+1, temp);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] list) {
        System.out.println("Sorting array ...");
        for (int i = 0; i < list.length - 1; i++) {
            int j = i;
            while(j > 0 && list[j].compareTo(list[j-1]) < 0){
                T temp = list[j];
                list[j] = list[j-1];
                list[j-1] = temp;
                j--;
            }
        }
    }

    public static <T extends Comparable<T>> void insertionSort(List<T> list) {
        System.out.println("Sorting list ...");
        for (int i = 0; i < list.size() - 1; i++) {
            int j = i;
            while(j > 0 && list.get(j).compareTo(list.get(j-1)) < 0){
                T temp = list.get(j);
                list.add(j, list.get(j-1));
                list.add(j-1, temp);
                j--;
            }
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr, int startOfArray, int endOfArray) {
        if(startOfArray < endOfArray){
            int midOfArray = (int)(startOfArray + endOfArray)/2;
            mergeSort(arr, startOfArray, midOfArray);
            mergeSort(arr, midOfArray + 1, endOfArray);
            merge(arr, startOfArray, midOfArray, endOfArray); 
        }
    }

    public static <T extends Comparable<T>> void merge(T[] arr, int startOfArray, int midOfArray, int endOfArray) { 
        int n1 = midOfArray - startOfArray + 1;
        int n2 = endOfArray - midOfArray;
        T[] left = new T[n2 +1];
        T[] right = new T[n2 +1];
        
    
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
        for(int k = startOfArray; k < endOfArray; k++){
            if(left[i].compareTo(right[j]) <= 0){
                arr[k] = left[i];
                ++i;
            }
            else{
                arr[k] = right[j];
                ++j;
            }
        }   
    }

    public static <T extends Comparable<T>> void mergeSort(List<T> list, int startOfArray, int endOfArray) {
        if(startOfArray < endOfArray){
            int midOfArray = (int)(startOfArray + endOfArray)/2;
            mergeSort(list, startOfArray, midOfArray);
            mergeSort(list, midOfArray + 1, endOfArray);
            merge(list, startOfArray, midOfArray, endOfArray); 
        }
    }

    public static <T extends Comparable<T>> void merge(List<T> list, int startOfArray, int midOfArray, int endOfArray) { 
        int n1 = midOfArray - startOfArray + 1;
        int n2 = endOfArray - midOfArray;
        T[] left = new T[n2 +1];
        T[] right = new T[n2 +1];
    
        for(int i = 1; i < n1; ++i){
            left[i] = list.get(startOfArray + i - 1);
        }
        for(int j = 1; j < n2; ++j){
            right[j] =  list.get(midOfArray + j);
        }
        // left[n1 + 1] = inf;
        // right[n2 + 1] = inf;
    
        int i = 1;
        int j = 1;
        for(int k = startOfArray; k < endOfArray; k++){
            if(left[i].compareTo(right[j]) <=0){
                list.add(k, left[i]);
                ++i;
            }
            else{
                list.add(k, right[j]);
                ++j;
            }
        }   
    }
}