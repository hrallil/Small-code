import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        GenericGet<String> getterString = new GenericGet<>();
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("hej","med","dig","karl","og","frank"));
        System.out.println("stringlist index 2: " + getterString.getIndex(stringList, 2));

        GenericGet<Integer> getterInt = new GenericGet<>();
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        System.out.println("intlist index 2: " + getterInt.getIndex(intList, 2));
        LinkedList<Integer> intlinklist = new LinkedList<>(Arrays.asList(1,2,10,4,5,6,7));
        System.out.println("int linkedList index 2: " + getterInt.getIndex(intlinklist, 2));
    }
}
