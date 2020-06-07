/**
 * Graph.java
 * @author
 * @author
 * CIS 22C, Lab 6
 */

import java.util.ArrayList;

public class Graph {
    private int vertices;
    private int edges;
    private ArrayList<List<Integer> > adj;
    private ArrayList<Character> color;
    private ArrayList<Integer> distance;
    private ArrayList<Integer> parent;

    /**Constructor*/

    /**
     * initializes an empty graph, with n vertices
     * and 0 edges, and intitializes all arraylists
     * to contain default values from indices 1 to n
     * @param n the number of vertices in the graph
     */
    public Graph(int n) {

    }


    /*** Accessors ***/

    /**
     * Returns the number of edges in the graph
     * @return the number of edges
     */
    public int getNumEdges() {
        return -1;
    }

    /**
     * Returns the number of vertices in the graph
     * @return the number of vertices
     */
    public int getNumVertices() {
        return -1;
    }

    /**
     * returns whether the graph is empty (no vertices)
     * @return whether the graph is empty
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns the value of the distance[v]
     * @param v a vertex in the graph
     * @precondition 0 < v <= vertices
     * @return the distance of vertex v
     * @throws IndexOutOfBoundsException when
     * the precondition is violated
     */
    public Integer getDistance(Integer v) throws IndexOutOfBoundsException{
        return -1;
    }

    /**
     * Returns the value of the parent[v]
     * @param v a vertex in the graph
     * @precondition 0 < v <= vertices
     * @return the parent of vertex v
     * @throws IndexOutOfBoundsException when
     * the precondition is violated
     */
    public Integer getParent(Integer v) throws IndexOutOfBoundsException {
        return -1;
    }

    /**
     * Returns the value of the color[v]
     * @param v a vertex in the graph
     * @precondition 0 < v <= vertices
     * @return the color of vertex v
     * @throws IndexOutOfBoundsException when
     * the precondition is violated
     */
    public Character getColor(Integer v) throws IndexOutOfBoundsException {
        return null;
    }

    /**
     * Returns the List stored at index v
     * @param v a vertex in the graph
     * @return the adjacency List a v
     * @precondition 0 < v <= vertices
     * @throws IndexOutOfBoundsException  when
     * the precondition is violated
     */
    public List<Integer> getAdjacencyList(Integer v) throws IndexOutOfBoundsException {
        return null;
    }

    /*** Manipulation Procedures ***/

    /**
     * Inserts vertex v into the adjacency list of vertex u
     * (i.e. inserts v into the list at index u)
     * @precondition 0 < u <= vertices, 0 < v <= vertices
     * @throws IndexOutOfBounds exception when the precondition
     * is violated
     */
    public void addDirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {

    }

    /**
     * Inserts vertex v into the adjacency list of vertex u
     * (i.e. inserts v into the list at index u)
     * and inserts u into the adjacent vertex list of v
     * @precondition 0 < u <= vertices, 0 < v <= vertices
     * @throws IndexOutOfBounds exception when the precondition
     * is violated
     */
    public void addUndirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {

    }

    /*** Additional Operations ***/

    /**
     * Creates a String representation of the Graph
     * Prints the adjacency list of each vertex in the graph,
     * vertex: <space separated list of adjacent vertices>
     */
    @Override public String toString() {
        String result = "";
        return "";
    }



    /**
     * Prints the current values in the parallel ArrayLists
     * after executing BFS. First prints the heading:
     * v <tab> c <tab> p <tab> d
     * Then, prints out this information for each vertex in the graph
     * Note that this method is intended purely to help you debug your code
     */
    public void printBFS() {

    }

    /**
     * Performs breath first search on this Graph give a source vertex
     * @param source the source vertex
     * @precondition graph must not be empty
     * @precondition source is a vertex in the graph
     * @throws IllegalStateException if the graph is empty
     * @throws IndexOutOfBoundsException when vertex is
     * outside the bounds of the graph
     */

    public void BFS(Integer source) throws IllegalStateException, IndexOutOfBoundsException {

    }

}

