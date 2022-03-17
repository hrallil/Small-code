import java.util.ArrayList;
import java.util.Random;

//Map class, is used to keep track of most of the game
public class Map {
    Entity[][] map;
    ArrayList<Entity> all_entities;                         //- every instance of any class is kept in this list to keep track of all objects
    private int map_size = 15;
    private int total_animals = 5;

    //constructor for Map
    public Map(){
        map = new Entity[map_size][map_size];
        all_entities = new ArrayList<Entity>();
        fill_border();
        place_animals();
        place_obstacles();
    }

    // method that outputs the map size
    public int get_map_size(){
        return map_size;
    }

    // method that outputs a boolean of if any animals are alive 
    public boolean any_animals_alive(){
        int entities_alive = 0;
        for (Entity entity : all_entities) {
            if (entity.is_alive()) {
                entities_alive ++;
            }
        }
        return entities_alive > 0;
    }

    // updates the map visually
    public void game_tick(){
        for (Entity entity : all_entities) {
            if (entity.is_alive()){
                entity.act();
            }
        }
    }

    // sets a map (x,y) to null
    public void pos_turn_null(int x, int y){
        map[x][y] = null;
    }

    // sees if a map (x,y) is null
    public boolean check_if_empty(int x, int y){
        return map[x][y] == null;
    }

    // places the designated amount of animals on the map 
    public void place_animals(){
        for (int i = 0; i < total_animals; i++) {
            place_an_animal();
        }
    }

    // method to place one animal
    public void place_an_animal(){
        Random r = new Random();
        int x = r.nextInt(map.length - 2) + 1;
        int y = r.nextInt(map.length - 2) + 1;
        if (map[x][y] == null){
            Entity animal = new Animal(x, y, this);
            map[x][y] = animal;
            all_entities.add(animal);
        }
        else{
            place_an_animal();
        }
    }

    // places the amount of obstacles needed on the map 
    public void place_obstacles(){
        int total_obstacles = 5;
        for (int i = 0; i < total_obstacles; i++) {
            place_an_obstacle();
        }
    }

    // places an obstacle on the map
    public void place_an_obstacle(){
        Random r = new Random();
        int x = r.nextInt(map.length - 2) + 1;
        int y = r.nextInt(map.length - 2) + 1;
        if (map[x][y] == null){
            Entity Obstacle = new Obstacle();
            map[x][y] = Obstacle;
        }
        else{
            place_an_obstacle();
        }
    }
    
    // moves an object from one (x,y) ot another (x,y)
    public void update_pos_on_map(int start_x, int start_y, int dest_x, int dest_y){
        map[dest_x][dest_y] = map[start_x][start_y];
        pos_turn_null(start_x, start_y);
    }
    
    // draws the map with every object shown as their draw() function dictates.
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

    // places obstacles all around the boarder of the map.
    private void fill_border(){
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map.length; y++) {
                if (x == 0 || x == map.length-1 || y == 0 || y == map.length-1) {
                    map[x][y] = new Obstacle();
                }
            }
        }            
    }
}

