import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {
    @Test
    public void putTest() {
        ShortQueue q = new ShortQueue();
        assertEquals(q.isFull(), false);
        q.put("hello");
        assertEquals(q.isFull(), true);
    }
    @Test
    public void takeTest() {
        ShortQueue q = new ShortQueue();
        String input = "hello";
        q.put(input);
        assertEquals(q.take(), input);
        assertEquals(q.isFull(), false);
        
    }
    @Test
    public void isFullTest(){
        ShortQueue q = new ShortQueue();
        assertEquals(q.isFull(), false);
        q.put("hello");
        assertEquals(q.isFull(), true);
    }
}
