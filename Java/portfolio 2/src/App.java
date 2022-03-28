public class App {
    public static void main(String[] args) throws Exception {
        AdjacencyGraph electricalGrid = makeElectricGridGraph();
        //electricalGrid.printGraph();
        electricalGrid.primMST();

    }


    public static AdjacencyGraph makeElectricGridGraph() {
        AdjacencyGraph electricGrid = new AdjacencyGraph();
        Vertex eskildstrup = new Vertex("Eskildstrup");
        Vertex haslev = new Vertex("Haslev");
        Vertex holdbæk = new Vertex("Holdbæk");
        Vertex jærgerspris = new Vertex("Jægerspris");
        Vertex kalundborg = new Vertex("Kaldundborg");
        Vertex korsør = new Vertex("Korsør");
        Vertex køge = new Vertex("Køge");
        Vertex maribo = new Vertex("Maribo");
        Vertex nakskov = new Vertex("Nakskov");
        Vertex nykøbing = new Vertex("Nykøbing F.");
        Vertex næstved = new Vertex("Næstved");
        Vertex ringsted = new Vertex("Ringsted");
        Vertex roskilde = new Vertex("Roskilde");
        Vertex slagelse = new Vertex("Slagelse");
        Vertex sorø = new Vertex("Sorø");
        Vertex vordingborg = new Vertex("Vordingborg");

        electricGrid.addVertex(eskildstrup);
        electricGrid.addVertex(haslev);
        electricGrid.addVertex(holdbæk);
        electricGrid.addVertex(jærgerspris);
        electricGrid.addVertex(kalundborg);
        electricGrid.addVertex(korsør);
        electricGrid.addVertex(køge);
        electricGrid.addVertex(maribo);
        electricGrid.addVertex(nakskov);
        electricGrid.addVertex(nykøbing);
        electricGrid.addVertex(næstved);
        electricGrid.addVertex(ringsted);
        electricGrid.addVertex(roskilde);
        electricGrid.addVertex(slagelse);
        electricGrid.addVertex(sorø);
        electricGrid.addVertex(vordingborg);   
        
        electricGrid.addEdge(eskildstrup, maribo, 28);
        electricGrid.addEdge(eskildstrup, nykøbing, 13);
        electricGrid.addEdge(eskildstrup, vordingborg, 24);
        electricGrid.addEdge(haslev, korsør, 60);
        electricGrid.addEdge(haslev, køge, 24);
        electricGrid.addEdge(haslev, næstved, 25);
        electricGrid.addEdge(haslev, ringsted, 19);
        electricGrid.addEdge(haslev, roskilde, 47);
        electricGrid.addEdge(haslev, slagelse, 48);
        electricGrid.addEdge(haslev, sorø, 34);
        electricGrid.addEdge(haslev, vordingborg, 40);
        electricGrid.addEdge(holdbæk, jærgerspris, 34);
        electricGrid.addEdge(holdbæk, kalundborg, 44);
        electricGrid.addEdge(holdbæk, korsør, 66);
        electricGrid.addEdge(holdbæk, ringsted, 36);
        electricGrid.addEdge(holdbæk, roskilde, 32);
        electricGrid.addEdge(holdbæk, slagelse, 46);
        electricGrid.addEdge(holdbæk, sorø, 34);
        electricGrid.addEdge(jærgerspris, korsør, 95);
        electricGrid.addEdge(jærgerspris, køge, 58);
        electricGrid.addEdge(jærgerspris, ringsted, 56);
        electricGrid.addEdge(jærgerspris, roskilde, 33);
        electricGrid.addEdge(jærgerspris, slagelse, 74);
        electricGrid.addEdge(jærgerspris, sorø, 63);
        electricGrid.addEdge(kalundborg, ringsted, 62);
        electricGrid.addEdge(kalundborg, roskilde, 70);
        electricGrid.addEdge(kalundborg, slagelse, 39);
        electricGrid.addEdge(kalundborg, sorø, 51);
        electricGrid.addEdge(korsør, næstved, 45);
        electricGrid.addEdge(korsør, slagelse, 20);
        electricGrid.addEdge(køge, næstved, 45);
        electricGrid.addEdge(køge, ringsted, 28);
        electricGrid.addEdge(køge, roskilde, 25);
        electricGrid.addEdge(køge, vordingborg, 60);
        electricGrid.addEdge(maribo, nakskov, 27);
        electricGrid.addEdge(maribo, nykøbing, 26);
        electricGrid.addEdge(næstved, roskilde, 57);
        electricGrid.addEdge(næstved, ringsted, 26);
        electricGrid.addEdge(næstved, slagelse, 37);
        electricGrid.addEdge(næstved, sorø, 32);
        electricGrid.addEdge(næstved, vordingborg, 28);
        electricGrid.addEdge(ringsted, roskilde, 31);
        electricGrid.addEdge(ringsted, sorø, 15);
        electricGrid.addEdge(ringsted, vordingborg, 58);
        electricGrid.addEdge(slagelse, sorø, 14);

        return electricGrid;
    }
}
