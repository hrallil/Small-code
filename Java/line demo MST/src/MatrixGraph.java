import java.util.ArrayList;
import java.util.Arrays;

public class MatrixGraph {
    boolean[][] EdgeMatrix;
    int[][]  WeightMatrix;
    public MatrixGraph(int Vertices){
        EdgeMatrix=new boolean[Vertices][Vertices];
        for(int i=0;i<Vertices;i++)
            Arrays.fill(EdgeMatrix[i],false);
        WeightMatrix=new int[Vertices][Vertices];
        for(int i=0;i<Vertices;i++)
            Arrays.fill(WeightMatrix[i],-1);
    }
    public void addEdge(int from,int to, int weight){
        EdgeMatrix[from][to]=true;
        WeightMatrix[from][to]=weight;
    }

    public void addUnDirectedEdge(int from,int to, int weight){
        EdgeMatrix[from][to]=true;
        WeightMatrix[from][to]=weight;
        EdgeMatrix[to][from]=true;
        WeightMatrix[to][from]=weight;
    }
    public void PrintGraph(){
        for(int i =0; i<EdgeMatrix.length;i++) {
            System.out.println(" Vertex " + i + " is connect to : ");
            for (int j=0;j<EdgeMatrix.length;j++){
                if(EdgeMatrix[i][j])
                    System.out.println(j+" with weight: "+ WeightMatrix[i][j]);
            }
        }
    }
    public void PrimsMST(){
        Integer[] Dist =new Integer[EdgeMatrix.length];
        Integer[] Prev = new Integer[EdgeMatrix.length];
        boolean[] visited=new boolean[EdgeMatrix.length];
        MinHeap<Pair> Q=new MinHeap<Pair>();
        ArrayList<Pair> VertexPairs=new ArrayList<>();
        Arrays.fill(Dist,Integer.MAX_VALUE);
        Arrays.fill(Prev,-1);
        Arrays.fill(visited,false);
        if (EdgeMatrix.length>0){
            Dist[0]=0;
            Prev[0]=0;
        }
        for(int i = 0; i<EdgeMatrix.length;i++) {
            Pair newPair= new Pair(Dist[i], i);
            VertexPairs.add(newPair);
            Q.Insert(newPair);
        }
        int MST=0;
        while(!Q.isEmpty()){
            Pair u=Q.extractMin();
            for(int v=0; v< EdgeMatrix[u.index].length;v++)
            {
                if(EdgeMatrix[u.index][v] && WeightMatrix[u.index][v]<Dist[v]  && !visited[v]){
                    Dist[v]= WeightMatrix[u.index][v];
                    VertexPairs.get(v).dist=WeightMatrix[u.index][v];
                    Prev[v]=u.index;
                    int pos=Q.getPosition(VertexPairs.get(v));
                    Q.decreasekey(pos);
                }
            }
            visited[u.index]=true;
            MST+=Dist[u.index];
        }
        System.out.println(" Minimum spanning tree distance: "+ MST);
        for(int i=0;i< EdgeMatrix.length;i++){
            System.out.println(" parent "+ Prev[i]+ " to "+ i + " Edge Weight "+Dist[i]);
        }
    }
}

class Pair implements Comparable<Pair>{
    Integer dist;
    Integer index;
    public  Pair(Integer dist, Integer i){
        this.dist=dist;
        this.index=i;
    }

    @Override
    public int compareTo(Pair o) {
        return this.dist.compareTo((o.dist));
    }
}
