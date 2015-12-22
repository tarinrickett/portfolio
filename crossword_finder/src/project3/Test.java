/*
 * Tarin Rickett
 * Project 3
 * CSC 172
 * Mamiko
 * Last edited: 11/21/15
 */

package project3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Test {
	
	private static MyHashTable dictionary = new MyHashTable (479829); //Size of dictionary (next prime too hard to find)
	static int puzzlesize;
	private static char [][] puzzle;
	private static ArrayList<String> found = new ArrayList<String>();

	
	//Read File ÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐ
	public static void readByLine (String filename) {
		File file = new File (filename);
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader (reader);
			String line;
			while ((line = br.readLine()) != null) {
				if (line.length() <= puzzlesize) { //If runtime is too slow, I should make individual HashTables for each word length
					dictionary.insert(line);
				}
			}
			br.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//Read Puzzle ÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐ
	public static void readPuzzle (String filename) {
		File file = new File (filename);
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader (reader);
			String line;
			//Use first line to find length of words
			line = br.readLine();
			puzzlesize = line.length();
			puzzle = new char [puzzlesize] [puzzlesize];
			int row = 0;
			for (int column = 0; column < line.length(); column++) {
				puzzle[row][column] = line.charAt(column);
			}
			row++;
			//Add rest of lines to puzzle
			while ((line = br.readLine()) != null) {
				for (int column = 0; column < line.length(); column++) {
					puzzle[row][column] = line.charAt(column);
				}
				row++;
			}
			
			br.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//Find Words ÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐ
	public static void find () {
		
		//Across Forwards
		String temp = "";
		String temp2 = "";
		for (int row = 0; row < puzzlesize; row++) {
			for (int column = 0; column < puzzlesize; column++) {
				temp = temp + puzzle[row][column];
				if (dictionary.lookUp(temp) && temp.length() > 3 && !(found.contains(temp))) {
					found.add(temp);
				}
			}
			//Check within temp for words
			for (int i = 1; i < temp.length(); i++) {
				for (int j = i; j < temp.length(); j++) {
					temp2 = temp2 + temp.charAt(j);
					if (dictionary.lookUp(temp2) && temp2.length() > 3 && !found.contains(temp2)) {
						found.add(temp2);
					}
				}
				temp2 = "";
			}
			temp = "";
		}
		
		//Across Backwards
		temp = "";
		for (int row = 0; row < puzzlesize; row++) {
			for (int column = puzzlesize; column > 0; column--) {
				temp = temp + puzzle[row][column-1];
				if (dictionary.lookUp(temp) && temp.length() > 3 && !(found.contains(temp))) {
					found.add(temp);
				}
			}
			//Check within temp for words
			for (int i = 1; i < temp.length(); i++) {
				for (int j = i; j < temp.length(); j++) {
					temp2 = temp2 + temp.charAt(j);
					if (dictionary.lookUp(temp2) && temp2.length() > 3 && !(found.contains(temp2))) {
						found.add(temp2);
					}
				}
				temp2 = "";
			}
			temp = "";
		}
		
		//Down Forwards
		temp = "";
		for (int column = 0; column < puzzlesize; column++) {
			for (int row = 0; row < puzzlesize; row++) {
				temp = temp + puzzle[row][column];
				if (dictionary.lookUp(temp) && temp.length() > 3 && !(found.contains(temp))) {
					found.add(temp);
				}
			}
			//Check within temp for words
			for (int i = 1; i < temp.length(); i++) {
				for (int j = i; j < temp.length(); j++) {
					temp2 = temp2 + temp.charAt(j);
					if (dictionary.lookUp(temp2) && temp2.length() > 3 && !(found.contains(temp2))) {
						found.add(temp2);
					}
				}
				temp2 = "";
			}
			temp = "";
		}
		
		//Down Backwards
		temp = "";
		for (int column = 0; column < puzzlesize; column++) {
			for (int row = puzzlesize; row > 0; row--) {
				temp = temp + puzzle[row-1][column];
				if (dictionary.lookUp(temp) && temp.length() > 3 && !(found.contains(temp))) {
					found.add(temp);
				}
			}
			//Check within temp for words
			for (int i = 1; i < temp.length(); i++) {
				for (int j = i; j < temp.length(); j++) {
					temp2 = temp2 + temp.charAt(j);
					if (dictionary.lookUp(temp2) && temp2.length() > 3 && !(found.contains(temp2))) {
						found.add(temp2);
					}
				}
				temp2 = "";
			}
			temp = "";
		}
		
		//Diagonal R Forwards
		for (int i = 0; i < puzzlesize - 1; i++) {
			int column = 0;
			for (int row = i; row < puzzlesize; row++) {
				temp = temp + puzzle[row][column];
				if (dictionary.lookUp(temp) && temp.length() > 3 && !(found.contains(temp))) {
					found.add(temp);
				}
				column++;
			}
			//Check within temp for words
			for (int k = 1; k < temp.length(); k++) {
				for (int j = k; j < temp.length(); j++) {
					temp2 = temp2 + temp.charAt(j);
					if (dictionary.lookUp(temp2) && temp2.length() > 3 && !(found.contains(temp2))) {
						found.add(temp2);
					}
				}
				temp2 = "";
			}
			temp = "";
		}
		for (int i = 1; i < puzzlesize - 1; i++) {
			int row = 0;
			for (int column = i; column < puzzlesize; column++) {
				temp = temp + puzzle[row][column];
				if (dictionary.lookUp(temp) && temp.length() > 3 && !(found.contains(temp))) {
					found.add(temp);
				}
				row++;
			}
			//Check within temp for words
			for (int k = 1; k < temp.length(); k++) {
				for (int j = k; j < temp.length(); j++) {
					temp2 = temp2 + temp.charAt(j);
					if (dictionary.lookUp(temp2) && temp2.length() > 3 && !(found.contains(temp2))) {
						found.add(temp2);
					}
				}
				temp2 = "";
			}
			temp = "";
		}

		//Diagonal R Backwards
		for (int i = puzzlesize - 1; i > 0; i--) {
			int row = puzzlesize-1;
			for (int column = i; column >= 0; column--) {
				temp = temp + puzzle[row][column];
				if (dictionary.lookUp(temp) && temp.length() > 3 && !(found.contains(temp))) {
					found.add(temp);
				}
				row--;
			}
			//Check within temp for words
			for (int k = 1; k < temp.length(); k++) {
				for (int j = k; j < temp.length(); j++) {
					temp2 = temp2 + temp.charAt(j);
					if (dictionary.lookUp(temp2) && temp2.length() > 3 && !(found.contains(temp2))) {
						found.add(temp2);
					}
				}
				temp2 = "";
			}
			temp = "";
		}
		for (int i = puzzlesize - 2; i > 0; i--) {
			int column = puzzlesize-1;
			for (int row = i; row >= 0; row--) {
				temp = temp + puzzle[row][column];
				if (dictionary.lookUp(temp) && temp.length() > 3 && !(found.contains(temp))) {
					found.add(temp);
				}
				column--;
			}
			//Check within temp for words
			for (int k = 1; k < temp.length(); k++) {
				for (int j = k; j < temp.length(); j++) {
					temp2 = temp2 + temp.charAt(j);
					if (dictionary.lookUp(temp2) && temp2.length() > 3 && !(found.contains(temp2))) {
						found.add(temp2);
					}
				}
				temp2 = "";
			}
			temp = "";
		}
		
		//Diagonal L Forwards
		for (int i = puzzlesize - 1; i > 0; i--) {
			int column = 0;
			for (int row = i; row >= 0; row--) {
				temp = temp + puzzle[row][column];
				if (dictionary.lookUp(temp) && temp.length() > 3 && !(found.contains(temp))) {
					found.add(temp);
				}
				column++;
			}
			//Check within temp for words
			for (int k = 1; k < temp.length(); k++) {
				for (int j = k; j < temp.length(); j++) {
					temp2 = temp2 + temp.charAt(j);
					if (dictionary.lookUp(temp2) && temp2.length() > 3 && !(found.contains(temp2))) {
						found.add(temp2);
					}
				}
				temp2 = "";
			}
			temp = "";
		}
		for (int i = 1; i < puzzlesize - 1; i++) {
			int row = puzzlesize-1;
			for (int column = i; column < puzzlesize; column++) {
				temp = temp + puzzle[row][column];
				if (dictionary.lookUp(temp) && temp.length() > 3 && !(found.contains(temp))) {
					found.add(temp);
				}
				row--;
			}
			//Check within temp for words
			for (int k = 1; k < temp.length(); k++) {
				for (int j = k; j < temp.length(); j++) {
					temp2 = temp2 + temp.charAt(j);
					if (dictionary.lookUp(temp2) && temp2.length() > 3 && !(found.contains(temp2))) {
						found.add(temp2);
					}
				}
				temp2 = "";
			}
			temp = "";
		}
		
		//Diagonal L Backwards
		for (int i = puzzlesize - 1; i > 0; i--) {
			int row = 0;
			for (int column = i; column >= 0; column--) {
				temp = temp + puzzle[row][column];
				if (dictionary.lookUp(temp) && temp.length() > 3 && !(found.contains(temp))) {
					found.add(temp);
				}
				row++;
			}
			//Check within temp for words
			for (int k = 1; k < temp.length(); k++) {
				for (int j = k; j < temp.length(); j++) {
					temp2 = temp2 + temp.charAt(j);
					if (dictionary.lookUp(temp2) && temp2.length() > 3 && !(found.contains(temp2))) {
						found.add(temp2);
					}
				}
				temp2 = "";
			}
			temp = "";
		}
		for (int i = 1; i < puzzlesize - 1; i++) {
			int column = puzzlesize-1;
			for (int row = i; row <= puzzlesize - 1; row++) {
				temp = temp + puzzle[row][column];
				if (dictionary.lookUp(temp) && temp.length() > 3 && !(found.contains(temp))) {
					found.add(temp);
				}
				column--;
			}
			//Check within temp for words
			for (int k = 1; k < temp.length(); k++) {
				for (int j = k; j < temp.length(); j++) {
					temp2 = temp2 + temp.charAt(j);
					if (dictionary.lookUp(temp2) && temp2.length() > 3 && !(found.contains(temp2))) {
						found.add(temp2);
					}
				}
				temp2 = "";
			}
			temp = "";
		}
	}
	
	
	//Write Words Out ÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐ
	public static void writeByLine (String filename) {
		try {
			File file = new File (filename);
			FileWriter writer = new FileWriter (file);
			for (int i = 0; i < found.size(); i++) {
				String out = found.get(i);
				writer.write(out + "\n");
				writer.flush();
			}
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//Main Method ÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐ
	public static void main (String [] args) {
		
		//Get Command Line Arguments (File Names)
		String inputFile = args[0];
		String puzzleFile = args[1];
		String outputFile = args[2];
		
		//Run program
		readPuzzle(puzzleFile); //Convert file to array
		readByLine(inputFile); //Add words to dictionary
		find(); //Find words in puzzle
		
//		Print found words to console
// 		System.out.println("The found words are: ");
// 		Collections.sort(found);
// 		for (int i = 0; i < found.size(); i++) {
// 			System.out.println("\t" + found.get(i));
// 		}
		
		writeByLine(outputFile); //Write out words found to txt file
		
	}
	
}
