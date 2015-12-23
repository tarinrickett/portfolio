package lab06;

/*
 * Stack.java
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
 * Last Revised: September 28th, 2015
*/

public interface Stack <T> {
	
	public boolean isEmpty();
	public void push(T x);
	public T pop();
	public T peek();

}
