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
        g.addDirectedEdge(1, 5);
        g.addDirectedEdge(2, 1);
        g.addDirectedEdge(2, 3);
        g.addDirectedEdge(2, 4);
        g.addDirectedEdge(3, 2);
        g.addDirectedEdge(3, 4);
        g.addDirectedEdge(4, 2);
        g.addDirectedEdge(4, 3);
        g.addDirectedEdge(4, 5);
        g.addDirectedEdge(5, 1);
        g.addDirectedEdge(5, 4);
        g.addDirectedEdge(5, 5);

        System.out.println(g);
        g.BFS(1);
        g.printBFS();
    }

}
