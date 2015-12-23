package lab07;

/*
 * Queue.java
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
 * Last Revised: September 30th, 2015
*/

public interface Queue <T> {
	
	public boolean isEmpty();
	public void enqueue (T x);
	public T dequeue();
	public T peek();

}
