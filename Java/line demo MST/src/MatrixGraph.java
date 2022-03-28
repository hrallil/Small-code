import java.util.ArrayList;
import java.util.Arrays;

public class MatrixGraph {
    boolean[][] edgeMatrix;
    int[][]  weightMatrix;
    public MatrixGraph(int Vertices){
        edgeMatrix=new boolean[Vertices][Vertices];
        for(int i=0;i<Vertices;i++)
            Arrays.fill(edgeMatrix[i],false);
        weightMatrix=new int[Vertices][Vertices];
        for(int i=0;i<Vertices;i++)
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

    public void primMST(){
        Integer[] dist = new Integer[edgeMatrix.length];
        Integer[] prev = new Integer[edgeMatrix.length];
        boolean[] visited = new boolean[edgeMatrix.length];
        MinHeap<Pair> q = new MinHeap<Pair>();
        ArrayList<Pair> vertexPairs = new ArrayList<Pair>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        Arrays.fill(visited, false);
        if(edgeMatrix.length > 0){
            dist[0] = 0;
            prev[0] = 0;
        }
        for (int i = 0; i < edgeMatrix.length; i++) {
            vertexPairs.add(new Pair(dist[i],i));
            q.Insert(vertexPairs.get(i));
        }
        int lengthOfMST = 0;

        while (!q.isEmpty()) {
            Pair u = q.extractMin();
            for (int v = 0; v < edgeMatrix[u.index].length; v++) {
                if (edgeMatrix[u.index][v] && weightMatrix[u.index][v] < dist[v] && !visited[v]) {
                    vertexPairs.get(v).distance = weightMatrix[u.index][v];
                    dist[v] = weightMatrix[u.index][v];

                    prev[v] = u.index;
                    int pos = q.getPosition(vertexPairs.get(v));
                    q.decreasekey(pos);
                }
            }
            visited[u.index] = true;
            lengthOfMST += dist[u.index];
        }
        System.out.println("Minimum spanning tree is " + lengthOfMST + " long");
    }
}