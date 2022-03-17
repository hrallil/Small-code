public class App {
    private boolean running;
    //constructor for App
    public App(){
        running = true;
        Map map = new Map();

        //main while loop for the program.
        while(running){
            map.show_map();
            map.game_tick();
            //condition that slows down the game.
            try {
                Thread.sleep(2500);    
            } catch (Exception e) {
                System.out.println("fejl");
            }
            // stops the game if all animals are dead
            running = map.any_animals_alive();
        }
        //final show of map and "game over" indicator, when the game is over
        map.show_map();
        System.out.println("game over");
    }
}
