import java.util.Random;

//Animal class, that impliments the interface "Entity" 
public class Animal implements Entity{
    private int x;
    private int y;
    private Map map;
    private boolean alive;

    //constructor for animal
    public Animal(int x_pos, int y_pos, Map world_map){
        x = x_pos;
        y = y_pos;
        alive = true;
        map = world_map;
    }

    // checks if both x==0 and y==0
    public boolean is_both_zero(int x, int y){
        return x==0 && y==0;

    }

    // checks if the random move chosen is (0,0) if it is, pick a new move 
    public int[] is_legal_move(){
        Random r = new Random();
        int[] rand_koor = new int[2];
        rand_koor[0] = r.nextInt(3) - 1;
        rand_koor[1] = r.nextInt(3) - 1;
        // System.out.println(rand_koor[0] +","+rand_koor[1] );         - for de-bugging
        if (is_both_zero(rand_koor[0], rand_koor[1])) {
            rand_koor = is_legal_move();
            //System.out.println("in if");                              - for de-bugging 
        }
        return rand_koor;
        
    }

    // contains the move for every instance of the animals class
    @Override
    public void act() {
        int[] out = is_legal_move();
        int dx = out[0];
        int dy = out[1];
        move(dx, dy);
    }

    // move function that moves the animal, both visually and in the map class
    private void move(int dir_x, int dir_y ) {
        // System.out.println("dx,dy: (" + dir_x + ", " + dir_y + ")");
        if (map.check_if_empty(x + dir_x, y + dir_y)) {
            map.update_pos_on_map(x, y, x + dir_x, y + dir_y);
            x += dir_x;
            y += dir_y;
        }
        else{
            die();
        }
    }

    // returns animal x
    @Override
    public int get_x() {
        return x;
    }

    //returns animal y
    @Override
    public int get_y() {
        return y;
    }
    
    // returns if animal is alive
    @Override
    public boolean is_alive() {
        return alive;
    }
    
    //represents the animal on the map with an "A"
    @Override
    public String draw() {
        return "A";
        
    }

    //kills the animal
    public void die(){
        alive = false;
        map.pos_turn_null(x, y);
    }

}
