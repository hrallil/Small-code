public class Main {

    public static void main(String[] args) {
        MatrixGraph directedG = createDirected();
        directedG.PrintGraph();
        directedG.PrimsMST();
        //AdjacencyGraph adjDirectedG=createDirectedAdj();
        //adjDirectedG.PrintGraph();
	// write your code here
    }
    public static MatrixGraph createDirected(){
        MatrixGraph newG = new MatrixGraph(7);
        newG.addEdge(0,1,1);
        newG.addEdge(0,2,5);
        newG.addEdge(0,4,3);
        newG.addEdge(1,4,1);
        newG.addEdge(1,5,7);
        newG.addEdge(2,3,1);
        newG.addEdge(3,4,1);
        newG.addEdge(3,6,1);
        newG.addEdge(4,2,1);
        newG.addEdge(4,3,3);
        newG.addEdge(4,5,3);
        newG.addEdge(4,6,4);
        newG.addEdge(5,6,1);

        return newG;
    }
    public static AdjacencyGraph createDirectedAdj(){
        AdjacencyGraph newG=new AdjacencyGraph();
        Vertex V0=new Vertex("0");
        Vertex V1=new Vertex("1");
        Vertex V2=new Vertex("2");
        Vertex V3=new Vertex("3");
        Vertex V4=new Vertex("4");
        Vertex V5=new Vertex("5");
        Vertex V6=new Vertex("6");
        newG.addVertex(V0);
        newG.addVertex(V1);
        newG.addVertex(V2);
        newG.addVertex(V3);
        newG.addVertex(V4);
        newG.addVertex(V5);
        newG.addVertex(V6);

        newG.addEdge(V0,V1,1);
        newG.addEdge(V0,V2,5);
        newG.addEdge(V0,V4,3);
        newG.addEdge(V1,V4,1);
        newG.addEdge(V1,V5,7);
        newG.addEdge(V2,V3,1);
        newG.addEdge(V3,V4,1);
        newG.addEdge(V3,V6,1);
        newG.addEdge(V4,V2,1);
        newG.addEdge(V4,V3,3);
        newG.addEdge(V4,V5,3);
        newG.addEdge(V4,V6,4);
        newG.addEdge(V5,V6,1);

        return newG;
    }
}
