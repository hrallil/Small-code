public class App {
    public static void main(String[] args) throws Exception {
        Creator creator = new Creator();

        creator.createRooms();
        Room s = creator.getCurrentRoom();

        System.out.println(s);

    }
}
