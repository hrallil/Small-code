// Class that impliments the interface "Entity". Mostly empty class since its for objects Who's main purpose is just to be static on the map. 
public class Obstacle implements Entity {


    @Override
    public void act() {
    }

    @Override
    public int get_x() {
        return 0;
    }

    @Override
    public int get_y() {
        return 0;
    }

    @Override
    public boolean is_alive() {
        return false;
    }

    // draws every obstacle on the map with an "O" to indicate obstacle.
    @Override
    public String draw() {
        return "O";
    }
}
