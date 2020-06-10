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
    public static void main(String[] args) {
        int vertices, id, intAdjacent, choice;
        String name, adjacent;
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        List<Integer> currentFriends = new List<>();
        List<Integer> recommendFriends = new List<>();

        System.out.println("Welcome to the Friend Recommender!\n");
        Scanner input = new Scanner(System.in);

        boolean incorrectFile = true;
        while (incorrectFile) {
            try {
                System.out.print("Enter the name of a file: ");
                String fileName = input.nextLine();
                File file = new File(fileName);
                input = new Scanner(file);
                incorrectFile = false;
            } catch (FileNotFoundException e) {
                System.out.println("\nInvalid file name!");
            }

        }

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

        System.out.println("\nEnter Your User Number Below:");
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
            System.out.println(result + names.get(currentFriends.getIterator() - 1));
        }

        System.out.println("\nHere are your recommended friends:");
        g.BFS(id);
        for (int i = 1; i <= g.getNumVertices(); i++) {
            if ((g.getDistance(i) > 0) && g.getParent(i) != id) {
                recommendFriends.addLast(i);
                System.out.println((i) + ". " + names.get(i - 1));
            }
        }

        // just update the current friends and recommend friends, no call BFS.
        while (true) {
            System.out.println("\nEnter the number of a friend to add or -1 to quit:");
            System.out.print("Enter your choice: ");
            id = Integer.parseInt(input.nextLine());

            if (id == -1) {
                break;
            }


            // Adding in a sorted order
            currentFriends.placeIterator();
            if (id < currentFriends.getIterator()) {
                currentFriends.addFirst(id);
            } else {
                currentFriends.advanceIterator();
                while (!currentFriends.offEnd()) {
                    if (id < currentFriends.getIterator()) {
                        currentFriends.reverseIterator();
                        currentFriends.addIterator(id);
                        break;
                    } else {
                        currentFriends.advanceIterator();
                    }
                }
                if (currentFriends.offEnd()) {
                    currentFriends.addLast(id);
                }
            }

            recommendFriends.placeIterator();
            recommendFriends.advanceNTimes(recommendFriends.linearSearch(id) - 1);
            recommendFriends.removeIterator();

            System.out.println("\nHere are your current friends:");
            for (int i = 0; i < currentFriends.getLength(); i++) {
                currentFriends.placeIterator();
                currentFriends.advanceNTimes(i);
                String result = currentFriends.getIterator() + ". ";
                System.out.println(result + names.get(currentFriends.getIterator() - 1));
            }

            System.out.println("\nHere are your recommended friends:");
            if (recommendFriends.getLength() == 0) {
                System.out.println("Sorry! We don't have any recommendations for you at this time.");
            } else {
                for (int i = 0; i < recommendFriends.getLength(); i++) {
                    recommendFriends.placeIterator();
                    recommendFriends.advanceNTimes(i);
                    String result = recommendFriends.getIterator() + ". ";
                    System.out.println(result + names.get(recommendFriends.getIterator() - 1));
                }
            }

        }

        System.out.println("\nGoodbye!");
    }
}
