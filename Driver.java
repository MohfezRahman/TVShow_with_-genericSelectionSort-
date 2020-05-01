/* Class:Homework4
 * *@author Mohfez Rahman * 
 * @version 1.0 
 * * Course: ITEC 2150 Spring 2020 
 * * Written: APR 27, 2020 * 
 * * This class – now describe what the class
 * does: This program is going to display the to user input to xxx.txt file
 * the it will read from txt file then print show name and streaming service by alphabetic order .
 * 
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Driver {
	// main method
	public static void main(String[] args) {

		// Variables
		String showName, streamingService;

		// Scanner
		Scanner sc = null;

		// ArrayList for TVShow
		ArrayList<TVShow> tvshow = new ArrayList<TVShow>();

		// try and catch block
		try {

			// file reader
			File reader = new File("C:\\Users\\sitolsporso\\Desktop\\shows.txt");
			sc = new Scanner(reader);

			// condition to read next line
			while (sc.hasNextLine()) {
				showName = sc.nextLine();
				streamingService = sc.nextLine();

				// add into ArrayList
				tvshow.add(new TVShow(showName, streamingService));
			}

			// catch block
		} catch (IOException e) {
			System.out.println("Error!!!.. File not found... ");

			// stop here if no file
			System.exit(0);

		}
		// Created array for show list
		TVShow[] showList = tvshow.toArray(new TVShow[tvshow.size()]);

		// using generic selection sort
		genericSelectionSort(showList);
		tvshow.clear();

		// Enhanced loop
		for (TVShow tv : showList) {
			tvshow.add(tv);
		}

		// List Iterator
		ListIterator<TVShow> iteration = tvshow.listIterator();
		while (iteration.hasNext()) {
			System.out.println(iteration.next());
		}

	}

	public static <T extends Comparable> void genericSelectionSort(T[] tvshow) {

		for (int i = 0; i < tvshow.length - 1; i++) {

			T currentMin = tvshow[i];
			int currentMinIndex = i;
			for (int j = 0; j < tvshow.length - 1; j++) {
				// Find min: the index of the string reference that should go into cell j.
				// Look through the unsorted strings (those at j or higher) for the one that is
				// first in lexicographic order
				int min = j;
				for (int k = j + 1; k < tvshow.length; k++)
					if (tvshow[k].compareTo(tvshow[min]) < 0)
						min = k;

				// Swap the reference at j with the reference at min
				T temp = tvshow[j];
				tvshow[j] = tvshow[min];
				tvshow[min] = temp;
			}

		}

	}

}
