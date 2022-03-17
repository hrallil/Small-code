//class App that contains the game loop
public class App {
    //alocate memory for variables
    private boolean running;

    // constructor for App class
    public App(){
        Map map = new Map();
        running = true;

        while (running) {
            System.out.println("----------------------------------------------------------------------------------------");
            map.show_map();
            map.game_tick();
            running = map.player_alive() && map.enemies_alive();
        }
        
        System.out.println("----------------------------------------------------------------------------------------");
        map.show_map();
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Game Over");
        

    }
}
