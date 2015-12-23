package lab06;

import java.util.Scanner;

/*
 * Test.java
 * 
 * Version 1.0
 * 
 * Copyright Tarin Rickett
 * 
 * Course: CSC 172 Fall 2015
 * 
 * Assignment: Lab 06
 * 
 * Author: Tarin Rickett
 * 
 * Lab Session: MW 3:25-4:40
 * 
 * Lab TA: Mamiko Nagasaka
 * 
 * Last Revised: October 4th, 2015
*/

public class Test {

	public static void main (String [] args) {
		
		//Initialize Variables
		MyStack<String> stack = new MyStack<String>();

		//isEmpty
		System.out.println("\nIs it empty? "+ stack.isEmpty());
		
		//Push
		System.out.println("\nLet's push some objects onto the stack");
		stack.push("Node 1");
		stack.push("Node 2");
		
		//isEmpty
		System.out.println("\nIs it empty? "+ stack.isEmpty());
		
		//Peek
		System.out.println( "\nLet's take a peek... " + stack.peek());
		
		//Pop
		System.out.println("\nPop goes... " + stack.pop() + ", " + stack.pop());

		//isEmpty
		System.out.println("\nIs it empty now? " + stack.isEmpty());
		
		//User Generated Stacks
		Scanner scanner = new Scanner (System.in);
		System.out.println("\nWould you like to make your own stack?");
		String ans = scanner.nextLine();
		if ( ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y") ) {
			
			System.out.println("Great! Would you like to store words or numbers?");
			ans = scanner.nextLine();
			
			if ( ans.equalsIgnoreCase( "words" ) ) {
				
				//Assign head
				System.out.println("What's the first word or phrase you'd like to store?");
				String data = scanner.nextLine();
				MyStack<String> stringStack = new MyStack<String> ();
				stringStack.push(data);
				
				//Add more nodes
				System.out.println("Would you like to add any other words or phrases?");
				ans = scanner.nextLine();
				while ( ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y") ) {
					System.out.println("What else would you like to add?");
					data = scanner.nextLine();
					stringStack.push(data);
					System.out.println("Would you like to add any other words or phrases?");
					ans = scanner.nextLine();
				}
				
				//Use functions
				System.out.println("Great! We have our inital stack. Would you like to use any of the other functions?");
				ans = scanner.nextLine();
				while ( ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y") ) {
					System.out.println("What else would you like to do? You can add, delete, peek, or check if empty");
					String doSomething = scanner.nextLine();
					if ( doSomething.equalsIgnoreCase("add") ) {
						System.out.println("What would you like to add?");
						data = scanner.nextLine();
						stringStack.push(data);
						System.out.println(data + " was added!");
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
					else if ( doSomething.equalsIgnoreCase("delete") ) {
						System.out.println(stringStack.pop() + " was deleted");
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
					else if ( doSomething.equalsIgnoreCase("peek") ) {
						System.out.println( stringStack.peek() + " is at the top of the stack" );
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
					else if ( doSomething.equalsIgnoreCase("check if empty") ) {
						System.out.println( "True or false, this stack is empty?" + "\n" + stringStack.isEmpty() );
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
				MyStack<Double> numStack = new MyStack<Double> ();
				numStack.push(data);
				
				//Add more nodes
				System.out.println("Would you like to add any other numbers?");
				ans = scanner.nextLine();
				while ( ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y") ) {
					System.out.println("What else would you like to add?");
					data = scanner.nextDouble();
					numStack.push(data);
					System.out.println("Would you like to add any other numbers?");
					ans = scanner.nextLine();
				}
				
				//Use functions
				System.out.println("Great! We have our inital stack. Would you like to use any of the other functions?");
				ans = scanner.nextLine();
				while ( ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y") ) {
					System.out.println("What else would you like to do? You can add, delete, peek, or check if empty");
					String doSomething = scanner.nextLine();
					if ( doSomething.equalsIgnoreCase("add") ) {
						System.out.println("What would you like to add?");
						data = scanner.nextDouble();
						numStack.push(data);
						System.out.println(data + " was added!");
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
					else if ( doSomething.equalsIgnoreCase("delete") ) {
						System.out.println(numStack.pop() + " was deleted");
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
					else if ( doSomething.equalsIgnoreCase("peek") ) {
						System.out.println( numStack.peek() + " is at the top of the stack" );
						System.out.println("Would you like to use any of the other functions?");
						ans = scanner.nextLine();
					}
					else if ( doSomething.equalsIgnoreCase("check if empty") ) {
						System.out.println( "True or false, this stack is empty?" + "\n" + numStack.isEmpty() );
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
