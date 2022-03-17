//interface for every entity on the map. NOT NEEDED but i wanted to try it out.
public interface Entity {
    public void act();
    public int get_x();
    public int get_y();
    public boolean is_alive();
    public String draw();
}
