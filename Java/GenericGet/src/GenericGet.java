import java.util.ArrayList;
import java.util.LinkedList;

public class GenericGet<T> {
    public GenericGet(){

    }

    public T getIndex(ArrayList<T> list, int index) {
        if (index >= 0 && index< list.size()) {
            return list.get(index);
        }
        return null;
    }
    public T getIndex(LinkedList<T> list, int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        }
        return null;
    }
}