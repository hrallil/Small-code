import java.util.Random;
import java.util.Scanner;
// class that is a child of Entity
public class Player implements Entity {
    // initiates variables for Player class
    private int x;
    private int y;
    private Map map;
    private boolean alive;

    // constructor of entity Player
    public Player(int x_pos, int y_pos, Map world_map){
        x = x_pos;
        y = y_pos;
        map = world_map;
        alive = true;
    }
    
    // if an existing method for act() exits, override it with this one. reads input from player and moves "P" in acordance to input
    @Override
    public void act() {
        System.out.println("Input a move: ");
        Scanner sc = new Scanner(System.in);
        String player_move = sc.nextLine().toLowerCase().trim();
        switch (player_move) {
            case "up":
                move(0, 1);
                break;
            case "down":
                move(0, -1);
                break;
            case "right":
                move(1, 0);
                break;
            case "left":
                move(-1, 0);
                break;
            case "jump":
                jump();
                break;
            default:
                break;
        }
    }

    // moves player in a direction.
    private void move(int dir_x, int dir_y ) {
        if (map.check_if_empty(x + dir_x, y + dir_y)){
            map.update_pos_on_map(x, y, x + dir_x, y + dir_y);
            y += dir_y;
            x += dir_x;
        }
        else{
            alive = false;
        }
    }

    // find random spot on map, if spot is empty: places a player on random spot of the map, else: find new spot
    private void jump(){
        Random r = new Random();
        int rand_x = r.nextInt(map.get_map_size() - 2);
        int rand_y = r.nextInt(map.get_map_size() - 2);
        if (map.check_if_empty(rand_x, rand_y)) {
            map.update_pos_on_map(x, y, rand_x, rand_y);
            x = rand_x;
            y = rand_y;
        } else{
            jump();
        }
    }

    // outputs player x
    @Override
    public int get_pos_X() {
        return x;
    }

    // outputs player y
    @Override
    public int get_pos_Y() {
        return y;
    }
    
    // draws "P" if player is alive, else: draws "X" on player (x,y)
    @Override
    public String draw() {
        if (alive) {
            return "p";
        }
        else {
            return "x";
        }
    }

    // returns alive state for player
    @Override
    public boolean is_alive() {
        return alive;
    }

    // kils Player
    public void DED(){
        alive = false;
    }
}
