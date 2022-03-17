import java.util.List;

public class SearchMethods {
    public static <T extends Comparable<T>> Integer SequencialSearch(T[] list,T item){
        for(int i=0;i<list.length;i++)
        {
            if(item.compareTo(list[i])==0)
                return i;
        }
        return null;
    }
    public static <T extends Comparable<T>> Integer SequencialSearch(List<T> list, T item){
        return null;
    }
    
    public static <T extends Comparable<T>> Integer JumpSearch(T[] list,T item) {
        int sqrtlist= (int) Math.sqrt(list.length);
        int j=sqrtlist;
        int prev=0;
        while(list[Math.min(j-1,list.length-1)].compareTo(item)<0)
        {
            prev=j;
            j+=sqrtlist;
            if(prev>=list.length)
                return -1;
        }
        while(list[prev].compareTo(item)<0)
        {
            prev++;
            if(prev==j||prev==list.length)
                return -1;
        }
        if(list[prev].compareTo(item)==0)
            return prev;
        return null;
    }
    
    public static <T extends Comparable<T>> Integer JumpSearch(List<T> list,T item){
        int j = (int) Math.sqrt(list.size());
        int prev = 0; 
        while (list.get((int) Math.min(j-1, list.size()-1)).compareTo(item) == 1) {
            prev = j;
            j = j + (int) Math.sqrt(list.size());
            if (prev >= list.size()) {
                return null;
            }
        }
        while(list.get(prev).compareTo(item) == 1){
            prev ++;
            if(prev == j || prev == list.size()){
                return null;
            }
        }
        if (list.get(prev) == item) {
            return prev;
        }
        return null;
    }

    public static <T extends Comparable<T>> Integer binarySearch(List<T> list, T item, int low, int high){
        if(low > high){ // in case list is unsorted.
            return null;
        }
        Integer mid = low + high/2;

        if (list.get(mid).compareTo(item) == 0 ) { // if element were looking for is found at the middle of current list.
            return mid;
        }
        if(list.get(mid).compareTo(item) == 1){ // in case element is bigger than midpoint of current list.
            return binarySearch(list, item, mid + 1, high);
        }
        if (list.get(mid).compareTo(item) == -1) { // in case element is smaller than midpoint of current list.
            return binarySearch(list, item, low, mid - 1);
        }
        return null;
    }
}
