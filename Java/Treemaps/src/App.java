import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.SwingWorker.StateValue;

public class App {
    public static void main(String[] args) throws Exception {

        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(); 
        int[] key = {1,2,3,4,5,6,7,8,9,10};
        String[] value = {"1","2","3","4","5","6","7","8","9","10"};

        for (int i = 0; i < key.length; i++) {
            treeMap.put(key[i], value[i]);    
        }
        System.out.println(treeMap);

        TreeSet<String> treeSet = new TreeSet<>();
        String[] setValue = {"D","A","B","E","C","G","F"};
        for (int i = 0; i < setValue.length; i++) {
            treeSet.add(setValue[i]);    
        }
        System.out.println(treeSet);

        

    }
}
