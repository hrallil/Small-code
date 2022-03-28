import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Inflater;

public class MatrixGraph {
    boolean[][] edgeMatrix;
    int[][]  weightMatrix;
    public MatrixGraph(int vertices){
        edgeMatrix=new boolean[vertices][vertices];
        for(int i=0;i<vertices;i++)
            Arrays.fill(edgeMatrix[i],false);
        weightMatrix=new int[vertices][vertices];
        for(int i=0;i<vertices;i++)
            Arrays.fill(weightMatrix[i],-1);
    }
    public void addEdge(int from,int to, int weight){
        edgeMatrix[from][to]=true;
        weightMatrix[from][to]=weight;
    }

    public void addUnDirectedEdge(int from,int to, int weight){
        edgeMatrix[from][to]=true;
        weightMatrix[from][to]=weight;
        edgeMatrix[to][from]=true;
        weightMatrix[to][from]=weight;
    }
    public void PrintGraph(){
        for(int i =0; i<edgeMatrix.length;i++) {
            System.out.println(" Vertex " + i + " is connect to : ");
            for (int j=0;j<edgeMatrix.length;j++){
                if(edgeMatrix[i][j])
                    System.out.println(j+" with weight: "+ weightMatrix[i][j]);
            }
        }
    }

    public void primMST() {        // - What is G???
        Integer[] dist = new Integer[edgeMatrix.length];
        Integer[] prev = new Integer[edgeMatrix.length];
        MinHeap<Pair> q = new MinHeap<Pair>();
        ArrayList<Pair> vertexPairs = new ArrayList<>();

        // fill in code here!
        for (Integer i = 0; i < edgeMatrix.length; i++) {
            dist[i] = Integer.MAX_VALUE; 
            prev[i] = null;
            q.Insert(new Pair(dist[i], i));
        }
        dist[s] = 0;
        q.update(s);
        while(!q.isEmpty()){
            Pair u = q.extractMin();
            for (edge e : u.vertex) {
                if(weight(u,v) < dist[u.index]){
                    dist[u.index] = weight(u,v);
                    prev[u.index] = u.vertex;
                    q.update(u.vertex);
                }
                
            }
            // mark u as visited??
        }
    }
}
