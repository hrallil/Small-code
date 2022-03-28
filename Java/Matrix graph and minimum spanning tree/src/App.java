public class App {
    public static void main(String[] args) throws Exception {
        
        Graph graph = createGraphFromAssignment();
        graph.printGraph();
        AdjacencyGraph graph2 = idkNamingIsReallyOff();
        graph2.printGraph();

    }

    public static Graph createGraphFromAssignment() {
        Graph newGraph = new Graph(7);
        newGraph.addEdge(0, 1, 1);
        newGraph.addEdge(0, 2, 5);
        newGraph.addEdge(0, 4, 3);
        newGraph.addEdge(1, 4, 1);
        newGraph.addEdge(1, 5, 7);
        newGraph.addEdge(2, 3, 1);
        newGraph.addEdge(3, 4, 1);
        newGraph.addEdge(3, 6, 1);
        newGraph.addEdge(4, 5, 3);
        newGraph.addEdge(4, 2, 1);
        newGraph.addEdge(4, 3, 3);
        newGraph.addEdge(4, 6, 4);
        newGraph.addEdge(5, 6, 1);

        return newGraph;
    }

    public static AdjacencyGraph idkNamingIsReallyOff() {
        AdjacencyGraph newGraph = new AdjacencyGraph();
        Vertex V0 = new Vertex("0");
        Vertex V1 = new Vertex("1");
        Vertex V2 = new Vertex("2");
        Vertex V3 = new Vertex("3");
        Vertex V4 = new Vertex("4");
        Vertex V5 = new Vertex("5");
        Vertex V6 = new Vertex("6");
        newGraph.addVertex(V0);
        newGraph.addVertex(V1);
        newGraph.addVertex(V2);
        newGraph.addVertex(V3);
        newGraph.addVertex(V4);
        newGraph.addVertex(V5);
        newGraph.addVertex(V6);

        newGraph.addEdge(V0, V1, 1);
        newGraph.addEdge(V0, V2, 5);
        newGraph.addEdge(V0, V4, 3);
        newGraph.addEdge(V1, V4, 1);
        newGraph.addEdge(V1, V5, 7);
        newGraph.addEdge(V2, V3, 1);
        newGraph.addEdge(V3, V4, 1);
        newGraph.addEdge(V3, V6, 1);
        newGraph.addEdge(V4, V5, 3);
        newGraph.addEdge(V4, V2, 1);
        newGraph.addEdge(V4, V3, 3);
        newGraph.addEdge(V4, V6, 4);
        newGraph.addEdge(V5, V6, 1);

        return newGraph;

    }
}
