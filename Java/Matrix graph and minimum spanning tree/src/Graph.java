public class Graph {
    boolean[][] edgeMatrix;
    int[][] weightMatrix;
    public Graph(int amountOfVertecies) {
        edgeMatrix = new boolean[amountOfVertecies][amountOfVertecies];
        weightMatrix = new int[amountOfVertecies][amountOfVertecies];
    }
    

    public void addEdge(int from, int to, int weight) {
        edgeMatrix[from][to] = true;
        weightMatrix[from][to] = weight;    
    }

    public void printGraph() {
        for (int i = 0; i < weightMatrix.length; i++) {
            for (int j = 0; j < weightMatrix.length; j++) {
                System.out.print(weightMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void linePrintGraph() {
        for (int i = 0; i < edgeMatrix.length; i++) {
            System.out.println("Vertex " + i + " is connected to: ");
            for (int j = 0; j < edgeMatrix.length; j++) {
                if (edgeMatrix[i][j]) {
                    System.out.println(j + " with weight " + weightMatrix[i][j]);
                }
            }
        }
    }
}
