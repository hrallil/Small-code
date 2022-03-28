import java.util.ArrayList;

public class AdjacencyGraph {
    ArrayList<Vertex> Vertecies;
    public AdjacencyGraph(){
        Vertecies = new ArrayList<>();
    }
    public void addVertex(Vertex name) {
        Vertecies.add(name);
    }
    public void addEdge(Vertex from, Vertex to, Integer weight) {
        if(!Vertecies.contains(from) && Vertecies.contains(to)){
            System.out.println("missing vertecies from graph");
            return;
        }
        else{
            Edge newE = new Edge(from, to, weight);
            from.addEdgeToList(newE);
        }
    }
    public void printGraph(){
        for (int i = 0; i < Vertecies.size(); i++) {
            System.out.println(" vetex " + Vertecies.get(i).name + " is connected to: ");
            for (Edge edge : Vertecies.get(i).outEdges) {
                System.out.println(edge.to.name + " with weight: " + edge.weight);
            }
        }
    }

}
