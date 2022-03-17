//class obstacle
public class Obstacle implements Entity {

    //controlls the act for all obstacles
    @Override
    public void act() {
    }

    //get x and y return 0 cause the pos of obstacles are never called
    @Override
    public int get_pos_X() {
        return 0;
    }
    @Override
    public int get_pos_Y() {
        return 0;
    }

    //draws "O" on any obstacles place
    @Override
    public String draw() {
        return "O";
    }

    //returns alive value for obstacle
    @Override
    public boolean is_alive() {
        return false;
    }

    // method DED() has to be in the class since it impliments Entity
    @Override
    public void DED() {
    }
}
