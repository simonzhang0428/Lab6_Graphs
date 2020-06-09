
/**
 * FriendNetwork.java
 *
 * @author Daniil Durnev
 * @author Simon Zhang
 * CIS 22C, Lab 6
 */

import java.io.File;
import java.io.FileNotFoundException;
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
		Scanner keyboardInput = new Scanner(System.in);
		Scanner fileInput;

		System.out.println("Welcome to the Friend Recommender!\n");

		while (true) {
			try {
				System.out.print("Enter the name of a file: ");
				String fileName = keyboardInput.nextLine();
				File file = new File("./" + fileName);

				fileInput = new Scanner(file);
				break;
			} catch (FileNotFoundException e) {
				System.out.println("\nInvalid file name!");
			}
		}

		vertices = Integer.parseInt(fileInput.nextLine());
		Graph g = new Graph(vertices);

		while (fileInput.hasNextLine()) {
			id = Integer.parseInt(fileInput.nextLine());
			ids.add(id);
			name = fileInput.nextLine();
			names.add(name);
			adjacent = fileInput.nextLine();
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
		id = Integer.parseInt(keyboardInput.nextLine());

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

		/// above is tested.

		// just update the current friends and recommend friends, no call BFS? ==> No BFS, just modify two lists
		while (true) {
			System.out.println("\nEnter the number of a friend to add or -1 to quit:");
			System.out.print("Enter your choice: ");
			id = Integer.parseInt(keyboardInput.nextLine());

			if (id == -1) {
				break;
			}

			// Adding in a sorted order
			currentFriends.placeIterator();
			boolean added = false;
			
			if(currentFriends.getIterator() > id) {
				currentFriends.addFirst(id);
				added = true;
			}
			
			for(int i = 0; i < currentFriends.getLength() && !added; i++) {
				// Adding at the last position in the list
				if(i == currentFriends.getLength() -1) {
					currentFriends.addLast(id);
					added = true;
				} else {
					if(currentFriends.getIterator() > id) {
						currentFriends.reverseIterator();
						currentFriends.addIterator(id);
						added = true;
					}
				}
				currentFriends.advanceIterator();
			}

			recommendFriends.placeIterator();
			recommendFriends.advanceNTimes(recommendFriends.linearSearch(id) - 1);
			recommendFriends.removeIterator();

			// should generate into function to reduce DRY
			System.out.println("\nHere are your current friends:");
			for (int i = 0; i < currentFriends.getLength(); i++) {
				currentFriends.placeIterator();
				currentFriends.advanceNTimes(i);
				String result = currentFriends.getIterator() + ". ";
				System.out.println(result + names.get(currentFriends.getIterator() - 1));
			}

			System.out.println("\nHere are your recommended friends:");
			for (int i = 0; i < recommendFriends.getLength(); i++) {
				recommendFriends.placeIterator();
				recommendFriends.advanceNTimes(i);
				String result = recommendFriends.getIterator() + ". ";
				System.out.println(result + names.get(recommendFriends.getIterator() - 1));
			}
		}

		System.out.println("\nGoodbye!");
	}
}