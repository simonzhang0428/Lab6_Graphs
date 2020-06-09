/**
 * FriendNetwork.java
 *
 * @author Daniil Durnev
 * @author Simon Zhang
 * CIS 22C, Lab 6
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Scanner;

public class FriendNetwork {
    public static void main(String[] args) throws FileNotFoundException {
        int vertices, id, intAdjacent, choice;
        String name, adjacent;
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        List<Integer> currentFriends = new List<>();
        List<Integer> recommendFriends = new List<>();

        System.out.println("Welcome to the Friend Recommender!\n");
        System.out.print("Enter the name of a file: ");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        File file = new File(fileName);
        // how to invalid file name?
        input = new Scanner(file);
        vertices = Integer.parseInt(input.nextLine());
        Graph g = new Graph(vertices);
        while (input.hasNextLine()) {
            id = Integer.parseInt(input.nextLine());
            ids.add(id);
            name = input.nextLine();
            names.add(name);
            adjacent = input.nextLine();
            for (String stringAdjacent : adjacent.split(",")) {
                stringAdjacent = stringAdjacent.trim();
                intAdjacent = Integer.parseInt(stringAdjacent);
                g.addUndirectedEdge(id, intAdjacent);
            }
        } // End of reading file and created graph

        System.out.println("Enter Your User Number Below:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }

        System.out.print("\nEnter your choice: ");
        input = new Scanner(System.in);
        id = Integer.parseInt(input.nextLine());

        System.out.println("\nHere are your current friends:");
        currentFriends = g.getAdjacencyList(id);
        for (int i = 0; i < currentFriends.getLength(); i++) {
            currentFriends.placeIterator();
            currentFriends.advanceNTimes(i);
            String result = currentFriends.getIterator() + ". ";
            System.out.println(result + names.get(i));
        }

        System.out.println("\nHere are your recommended friends:");
        g.BFS(id);
        for (int i = 1; i <= g.getNumVertices(); i++) {
            if ((g.getDistance(i) > 0) && g.getParent(i) != id) {
                recommendFriends.addLast(i);
                System.out.println((i) + ". " + names.get(i-1));
            }
        }

        /// above is tested.

        // just update the current friends and recommend friends, no call BFS?
        System.out.println("\nEnter the number of a friend to add or -1 to quit:");
        System.out.print("Enter your choice: ");
        id = Integer.parseInt(input.nextLine());
        currentFriends.addLast(id);
        // how to insert the new id into the correct position such that the array sorted.

        recommendFriends.placeIterator();
        recommendFriends.advanceNTimes(recommendFriends.linearSearch(id));
        recommendFriends.removeIterator();

        // should generate into function to reduce DRY
        System.out.println("\nHere are your current friends:");
        for (int i = 0; i < currentFriends.getLength(); i++) {
            currentFriends.placeIterator();
            currentFriends.advanceNTimes(i);
            String result = currentFriends.getIterator() + ". ";
            System.out.println(result + names.get(i));
        }

        System.out.println("\nHere are your recommended friends:");
        for (int i = 1; i <= g.getNumVertices(); i++) {
            if ((g.getDistance(i) > 0) && g.getParent(i) != id) {
                recommendFriends.addLast(i);
                System.out.println((i) + ". " + names.get(i-1));
            }
        }
    }
}
