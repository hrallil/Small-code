public class App {
    public static void main(String[] args) throws Exception {
    }
}

class ShortQueue{
    String memory; 
    void put(String s){ 
        if (memory == null) {
            memory = s;
        }
    } 

    String take(){
        String temp = memory;
        memory = null;
        return temp;
    } 

    boolean isFull(){
        return memory != null;
    } 

    public void cirkleLigning() {
        
    }

  } 

