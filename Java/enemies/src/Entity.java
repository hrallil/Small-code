//interface that parents for the classes that are in the "Entity" liniage
public interface Entity {
    public void act();
    public int get_pos_X();
    public int get_pos_Y();
    public String draw();
    public boolean is_alive();
    public void DED();
    
}
