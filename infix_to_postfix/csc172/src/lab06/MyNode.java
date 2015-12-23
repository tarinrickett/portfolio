package lab06;

/*
 * MyNode.java
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

public class MyNode<T> {
	
	public T data;
	public MyNode <T> next;
	
	//Constructor
	public MyNode ( T data, MyNode<T> next ) {
		this.data = data;
		this.next= next;	
	}

}
