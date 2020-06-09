/**
 * Graph.java
 *
 * @author Daniil Durnev
 * @author Simon Zhang
 * CIS 22C, Lab 6
 */

import java.util.ArrayList;

public class Graph {
    private int vertices;
    private int edges;
    private ArrayList<List<Integer>> adj;
    private ArrayList<Character> color;
    private ArrayList<Integer> distance;
    private ArrayList<Integer> parent;

    /**Constructor*/

    /**
     * initializes an empty graph, with n vertices
     * and 0 edges, and initializes all arraylists
     * to contain default values from indices 1 to n
     *
     * @param n the number of vertices in the graph
     */
    public Graph(int n) {
        vertices = n;
        edges = 0;
        adj = new ArrayList<>(n + 1);
        color = new ArrayList<>(n + 1);
        distance = new ArrayList<>(n + 1);
        parent = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            color.add(i, 'W');
            distance.add(i, -1);
            parent.add(i, 0);
            adj.add(i, new List<>());
        }
    }


    /*** Accessors ***/

    /**
     * Returns the number of edges in the graph
     *
     * @return the number of edges
     */
    public int getNumEdges() {
        return edges;
    }

    /**
     * Returns the number of vertices in the graph
     *
     * @return the number of vertices
     */
    public int getNumVertices() {
        return vertices;
    }

    /**
     * returns whether the graph is empty (no vertices)
     *
     * @return whether the graph is empty
     */
    public boolean isEmpty() {
        return vertices == 0;
    }

    /**
     * Returns the value of the distance[v]
     *
     * @param v a vertex in the graph
     * @return the distance of vertex v
     * @throws IndexOutOfBoundsException when
     *                                   the precondition is violated
     * @precondition 0 < v <= vertices
     */
    public Integer getDistance(Integer v) throws IndexOutOfBoundsException {
        if (v <= 0 || v > vertices) {
            throw new IndexOutOfBoundsException("getDistance, out of bound.");
        } else {
            return distance.get(v);
        }
    }

    /**
     * Returns the value of the parent[v]
     *
     * @param v a vertex in the graph
     * @return the parent of vertex v
     * @throws IndexOutOfBoundsException when
     *                                   the precondition is violated
     * @precondition 0 < v <= vertices
     */
    public Integer getParent(Integer v) throws IndexOutOfBoundsException {
        if (v <= 0 || v > vertices) {
            throw new IndexOutOfBoundsException("getParent, out of bound.");
        } else {
            return parent.get(v);
        }
    }

    /**
     * Returns the value of the color[v]
     *
     * @param v a vertex in the graph
     * @return the color of vertex v
     * @throws IndexOutOfBoundsException when
     *                                   the precondition is violated
     * @precondition 0 < v <= vertices
     */
    public Character getColor(Integer v) throws IndexOutOfBoundsException {
        if (v <= 0 || v > vertices) {
            throw new IndexOutOfBoundsException("getColor, out of bound.");
        } else {
            return color.get(v);
        }
    }

    /**
     * Returns the List stored at index v
     *
     * @param v a vertex in the graph
     * @return the adjacency List a v
     * @throws IndexOutOfBoundsException when
     * the precondition is violated
     * @precondition 0 < v <= vertices
     */
    public List<Integer> getAdjacencyList(Integer v) throws IndexOutOfBoundsException {
        if (v <= 0 || v > vertices) {
            throw new IndexOutOfBoundsException("getAdjacencyList, out of bound.");
        } else {
            return adj.get(v);
        }
    }

    /*** Manipulation Procedures ***/

    /**
     * Inserts vertex v into the adjacency list of vertex u
     * (i.e. inserts v into the list at index u)
     *
     * @throws IndexOutOfBoundsException when the precondition
     *                                   is violated
     * @precondition 0 < u <= vertices, 0 < v <= vertices
     */
    public void addDirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
        if ((u <= 0 || u > vertices) || (v <= 0 || v > vertices)) {
            throw new IndexOutOfBoundsException("addDirectedEdge, out of bound.");
        } else {
            adj.get(u).addLast(v);
            this.edges++;
        }
    }

    /**
     * Inserts vertex v into the adjacency list of vertex u
     * (i.e. inserts v into the list at index u)
     * and inserts u into the adjacent vertex list of v
     *
     * @throws IndexOutOfBoundsException when the precondition
     *                                   is violated
     * @precondition 0 < u <= vertices, 0 < v <= vertices
     */
    public void addUndirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
        if ((u <= 0 || u > vertices) || (v <= 0 || v > vertices)) {
            throw new IndexOutOfBoundsException("addUndirectedEdge, out of bound.");
        } else {
            if (adj.get(u).linearSearch(v) == -1) {
                adj.get(u).addLast(v);
            }
            if (adj.get(v).linearSearch(u) == -1) {
                adj.get(v).addLast(u);
            }
            this.edges++;
        }
    }

    /*** Additional Operations ***/

    /**
     * Creates a String representation of the Graph
     * Prints the adjacency list of each vertex in the graph,
     * vertex: <space separated list of adjacent vertices>
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 1; i <= vertices; i++) {
            result += i + ": " + adj.get(i);
        }
        return result;
    }


    /**
     * Prints the current values in the parallel ArrayLists
     * after executing BFS. First prints the heading:
     * v <tab> c <tab> p <tab> d
     * Then, prints out this information for each vertex in the graph
     * Note that this method is intended purely to help you debug your code
     */
    public void printBFS() {
        System.out.println("v\tc\tp\td\t");
        for (int i = 1; i <= vertices; i++) {
            System.out.println(i + "\t" +
                    color.get(i) + "\t" +
                    parent.get(i) + "\t" +
                    distance.get(i) + "\t");
        }
    }

    /**
     * Performs breath first search on this Graph give a source vertex
     *
     * @param source the source vertex
     * @throws IllegalStateException     if the graph is empty
     * @throws IndexOutOfBoundsException when vertex is
     *                                   outside the bounds of the graph
     * @precondition graph must not be empty
     * @precondition source is a vertex in the graph
     */

    public void BFS(Integer source) throws IllegalStateException, IndexOutOfBoundsException {
        if (this.isEmpty()) {
            throw new IllegalStateException("BFS, graph is empty.");
        } else if (source <= 0 || source > vertices) {
            throw new IndexOutOfBoundsException("BFS, index out of bound.");
        } else {
            color.set(source, 'G');
            distance.set(source, 0);
            List<Integer> queue_list = new List<>();
            queue_list.addLast(source);
            while (!queue_list.isEmpty()) {
                int x = queue_list.getFirst();
                queue_list.removeFirst();

                List<Integer> adj_in_x = adj.get(x);
                for (int i = 0; i < adj_in_x.getLength(); i++) {
                    adj_in_x.placeIterator();
                    adj_in_x.advanceNTimes(i);
                    int y = adj_in_x.getIterator();
                    if (color.get(y) == 'W') {
                        color.set(y, 'G');
                        distance.set(y, distance.get(x) + 1);
                        parent.set(y, x);
                        queue_list.addLast(y);
                    }
                }
                color.set(x, 'B');
            }
        }
    }
}
