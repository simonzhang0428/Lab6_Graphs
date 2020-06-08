/**
 * GraphTest.java
 * @author Daniil Durnev
 * @author Simon Zhang
 * CIS 22C, Lab 6
 */

public class GraphTest {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addDirectedEdge(1, 2);
        g.addDirectedEdge(1, 3);
        g.addDirectedEdge(1, 5);
        g.addDirectedEdge(2, 4);

        System.out.println(g);
        g.BFS(1);
        g.printBFS();

        System.out.println("Edge number(4): " + g.getNumEdges());
        System.out.println("Vertices number(5): " + g.getNumVertices());
        System.out.println("Is Empty(false): " + g.isEmpty());
        System.out.println("Adjacent list of vertex 1 (2 3 5): " + g.getAdjacencyList(1));
    }
}