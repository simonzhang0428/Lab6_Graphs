/**
 * GraphTest.java
 *
 * @author Daniil Durnev
 * @author Simon Zhang
 * CIS 22C, Lab 6
 */

public class GraphTest {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        System.out.println(g);
        g.printBFS();

        System.out.println("Edge number(0): " + g.getNumEdges());
        System.out.println("Vertices number(0): " + g.getNumVertices());
        System.out.println("Is Empty(false): " + g.isEmpty());
        System.out.println("----------------------------");

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

        try {
            System.out.println("color of 1 (B): " + g.getColor(1));
            System.out.println("color of 6 (Error): " + g.getColor(6));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("parent of 3 (1): " + g.getParent(3));
            System.out.println("parent of 6 (Error): " + g.getParent(6));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("distance of 4 (2): " + g.getDistance(4));
            System.out.println("distance of 6 (Error): " + g.getDistance(6));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("adjacent list of 1 (2 3 5): " + g.getAdjacencyList(1));
            System.out.println("adjacent list of 6 (Error): " + g.getAdjacencyList(6));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

    }

}
