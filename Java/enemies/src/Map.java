import java.util.ArrayList;
import java.util.Random;

//class Map
public class Map {
    // initiate momory for relevant variables
    Entity[][] map;
    ArrayList<Entity> entities;
    private int map_width = 21;
    private int map_hight = map_width;

    //constructor for Map class that calls the main functions in the Map class
    public Map(){
        map = new Entity[map_hight][map_width];
        entities = new ArrayList<Entity>();
        fill_border();
        place_player();
        place_enemies();
        place_obstacles();
    }

    // makes every entity in the entites list do their "act" typical:
    // obstacles = dont move.
    // Player = moves according to the input from a player.
    // Enemy = moves toward player.
    public void game_tick(){
        for (Entity entity : entities) {
            if (entity.is_alive()){
                entity.act();
            }
        }
    }

    // sets the playervalue to dead and prints "you died"
    public void kill_player(){
        entities.get(0).DED();
        System.out.println("you died");
    }

    // gets the x value of the player
    public int get_player_x(){
        return entities.get(0).get_pos_X();
    }

    // returns one of the dimentions of the map
    public int get_map_size(){
        return map_hight;
    }

    // gets y value of the player
    public int get_player_y(){
        return entities.get(0).get_pos_Y();
    }

    // turns (x,y) position on a map to null
    public void Pos_turn_null(int x, int y){
        map[x][y] = null;
    }

    // asks for alive state of the first value in the entities list
    public boolean player_alive(){
        return entities.get(0).is_alive();
    }

    //checks if spot on map is null
    public boolean check_if_empty(int x, int y){
        return map[x][y] == null;
    }

    //counts entities in entity list
    public boolean enemies_alive(){
        int entities_alive = 0;
        for (Entity entity : entities) {
            if (entity.is_alive()) {
                entities_alive ++;
            }
        }
        return entities_alive > 1;
    }

    // takes any obstacle on (x,y) and changes them to be on a new (x,y)
    public void update_pos_on_map(int start_x, int start_y, int dest_x, int dest_y){
        map[dest_x][dest_y] = map[start_x][start_y];
        map[start_x][start_y] = null;
    }

    // fills the edge of the map with obstacles so we close the enviorment
    private void fill_border(){
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map.length; y++) {
                if (x == 0 || x == map.length-1 || y == 0 || y == map.length-1) {
                    map[x][y] = new Obstacle();
                }
            }
        }            
    }

    //places class Player in the middle of the map and adds them to the entity list
    private void place_player(){
        int start_x = map.length/2;
        int start_y = map.length/2;
        Entity p =  new Player(start_x, start_y, this);
        map[start_x][start_y] = p;
        entities.add(p);
    }

    // place 2 enemies
    private void place_enemies(){
        int total_enemies = 2;
        for (int i = 0; i < total_enemies; i++) {
            place_an_enemy();
        }
    }

    // picks a random spot on the map, if spot is empty, place enemy and adds them to entity list else pick new spot
    private void place_an_enemy(){
        Random r = new Random();
        int x = r.nextInt(map.length - 2) + 1;
        int y = r.nextInt(map.length - 2) + 1;
        if (map[x][y] == null){
            Entity e = new Enemy(x, y, this);
            map[x][y] = e;
            entities.add(e);
        }
        else{
            place_an_enemy();
        }
    }

    // foor loop that places all obstacles on the map
    private void place_obstacles(){
        for (int i = 0; i < map.length / 2; i++) {
            place_an_obstacle();
        }
    }

    // chooses a random spot on map and paces one instance of an obstacle unless the spot is filled, then pick new spot
    private void place_an_obstacle(){
        Random r = new Random();
        int x = r.nextInt(map.length - 2) + 1;
        int y = r.nextInt(map.length - 2) + 1;
        if (map[x][y] == null){
            map[x][y] = new Obstacle();
        }
        else{
            place_an_obstacle();
        }
    }

    // method that shows the map in form of text. .draw() is called in all classes.
    public void show_map(){
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                if (map[x][map.length - y - 1] == null) {
                    System.out.print(" ");
                }else{
                    System.out.print(map[x][map.length - y -1].draw());
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
