package lab07;

/*
 * MyNode.java
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

public class MyNode<T> {

	public T data;
	public MyNode <T> next;
	
	//Constructor
	public MyNode ( T data, MyNode<T> next ) {
		this.data = data;
		this.next= next;	
	}
	
}
