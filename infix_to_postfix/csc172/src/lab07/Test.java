package lab07;

/*
 * Test.java
 * 
 * Version 1.0
 * 
 * Copyright Tarin Rickett
 * 
 * Course: CSC 172 Fall 2015
 * 
 * Assignment: Lab 07
 * 
 * Author: Tarin Rickett
 * 
 * Lab Session: MW 3:25-4:40
 * 
 * Lab TA: Mamiko Nagasaka
 * 
 * Last Revised: October 4th, 2015
*/

import java.util.Scanner;

public class Test {
	
	public static void main (String [] args) {
		
		//Initialize Variables
		MyQueue<String> queue = new MyQueue<String> ();

		//isEmpty
		System.out.println("\nIs it empty? "+ queue.isEmpty());
		
		//Push
		System.out.println("\nLet's push some objects onto the stack");
		queue.enqueue("Node 1");
		queue.enqueue("Node 2");
		
		//isEmpty
		System.out.println("\nIs it empty? "+ queue.isEmpty());
		
		//Peek
		System.out.println( "\nLet's take a peek... " + queue.peek());
		
		//Pop
		System.out.println("\nPop goes... " + queue.dequeue() + ", " + queue.dequeue());

		//isEmpty
		System.out.println("\nIs it empty now? " + queue.isEmpty());	
		
		//User Generated Stack
		Scanner scanner = new Scanner (System.in);
		System.out.println("\nWould you like to make your own queue?");
		String ans = scanner.nextLine();
		if ( ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y") ) {
			
			System.out.println("Great! Would you like to store words or numbers?");
			ans = scanner.nextLine();
			
			if ( ans.equalsIgnoreCase( "words" ) ) {
				
				//Assign head
				System.out.println("What's the first word or phrase you'd like to store?");
				String data = scanner.nextLine();
				MyQueue<String> stringQueue = new MyQueue<String> ();
				stringQueue.enqueue(data);
				
				//Add more nodes
				System.out.println("Would you like to add any other words or phrases?");
				ans = scanner.nextLine();
				while ( ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y") ) {
					System.out.println("What else would you like to add?");
					data = scanner.nextLine();
					stringQueue.enqueue(data);
					System.out.println("Would you like to add any other words or phrases?");
					ans = scanner.nextLine();
				}
				
				//Use functions
				System.out.println("Great! We have our inital queue. Would you like to use any of the other functions?");
				ans = scanner.nextLine();
				while ( ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y") ) {
					System.out.println("What else would you like to do? You can add, delete, peek, or check if empty");
					String doSomething = scanner.nextLine();
					if ( doSomething.equalsIgnoreCase("add") ) {
						System.out.println("What would you like to add?");
						data = scanner.nextLine();
						stringQueue.enqueue(data);
						System.out.println(data + " was added!");
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
					else if ( doSomething.equalsIgnoreCase("delete") ) {
						System.out.println(stringQueue.dequeue() + " was deleted");
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
					else if ( doSomething.equalsIgnoreCase("peek") ) {
						System.out.println( stringQueue.peek() + " is at the top of the queue" );
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
					else if ( doSomething.equalsIgnoreCase("check if empty") ) {
						System.out.println( "True or false, this queue is empty?" + "\n" + stringQueue.isEmpty() );
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
					else {
						System.out.println("Sorry I didn't understand that... try again?");
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
				}
				
				System.out.println("That was fun! Let's do it again sometime");
				
			}
			else if ( ans.equalsIgnoreCase( "numbers") ) {
				
				System.out.println("What's the first number you'd like to store?");
				double data = scanner.nextDouble();
				MyQueue<Double> numQueue = new MyQueue<Double> ();
				numQueue.enqueue(data);
				
				//Add more nodes
				System.out.println("Would you like to add any other numbers?");
				ans = scanner.nextLine();
				while ( ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y") ) {
					System.out.println("What else would you like to add?");
					data = scanner.nextDouble();
					numQueue.enqueue(data);
					System.out.println("Would you like to add any other numbers?");
					ans = scanner.nextLine();
				}
				
				//Use functions
				System.out.println("Great! We have our inital queue. Would you like to use any of the other functions?");
				ans = scanner.nextLine();
				while ( ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y") ) {
					System.out.println("What else would you like to do? You can add, delete, peek, or check if empty");
					String doSomething = scanner.nextLine();
					if ( doSomething.equalsIgnoreCase("add") ) {
						System.out.println("What would you like to add?");
						data = scanner.nextDouble();
						numQueue.enqueue(data);
						System.out.println(data + " was added!");
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
					else if ( doSomething.equalsIgnoreCase("delete") ) {
						System.out.println(numQueue.dequeue() + " was deleted");
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
					else if ( doSomething.equalsIgnoreCase("peek") ) {
						System.out.println( numQueue.peek() + " is at the top of the queue" );
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
					else if ( doSomething.equalsIgnoreCase("check if empty") ) {
						System.out.println( "True or false, this queue is empty?" + "\n" + numQueue.isEmpty() );
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
					else {
						System.out.println("Sorry I didn't understand that... try again?");
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
				}
				
				System.out.println("That was fun! Let's do it again sometime");
				
			}
			
		}
		else {
			System.out.println( "Alright, maybe next time");
		}
		
		
	}

}
