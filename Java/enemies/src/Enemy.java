// class enemy that impliments Entity
public class Enemy implements Entity {
    //initiates variables for class enemy
    private boolean alive;
    private int x;
    private int y;
    private Map map;

    //constructor for enemy 
    public Enemy(int x_pos, int y_pos, Map world_map){
        x = x_pos;
        y = y_pos;
        alive = true;
        map = world_map;
        
    }

    // gets a direction that the enemy wants to move in
    private void move(int dir_x, int dir_y ) {
        // if destination (x,y) is empty, move both "E" and the (x,y) for the instance of the class
        if (map.check_if_empty(x + dir_x, y + dir_y)){
            map.update_pos_on_map(x, y, x + dir_x, y + dir_y);
            y += dir_y;
            x += dir_x; 
        } // else if there is a player on the destination (x,y), kill the player and move the "E" to the destination (x,y) 
        else if(map.get_player_x() == x + dir_x && map.get_player_y() == y + dir_y){
            map.kill_player();
            map.update_pos_on_map(x, y, x + dir_x, y + dir_y);
            y += dir_y;
            x += dir_x;
            // if it hits any thing else, Obstacle, another Enemy. kill the Enemy
        }else{
            DED();
        }
    }

    // gets Player x and y and moves the Enemy closer to the player
    @Override
    public void act() {
        int player_x = map.get_player_x();
        int player_y = map.get_player_y();
        int dx = 0;
        int dy = 0;
        if (player_x > x) {
            dx = 1;
        }else if(player_x < x){
            dx = -1;
        }
        if (player_y > y) {
            dy = 1;
        }else if(player_y < y){
            dy = -1;
        }
        move(dx,dy); 
    }

    // returns enemy x and y, although it is never called so it just returns 0. has to be in the class since it impliments Entity
    @Override
    public int get_pos_X() {
        return 0;
    }
    @Override
    public int get_pos_Y() {
        return 0;
    }

    // draws "E" on Enemy location
    @Override
    public String draw() {
        return "E";
    }

    // Returns the alive state of a given Enemy
    @Override
    public boolean is_alive() {
        return alive;
    }

    //kills the given Enemy
    @Override
    public void DED() {
        alive = false;
        map.Pos_turn_null(x, y);
    }
    
}
