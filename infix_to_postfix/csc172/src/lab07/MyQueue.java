package lab07;

/*
 * MyQueue.java
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

public class MyQueue<T> implements Queue<T> {

	public MyNode<T> head;
	
	//Constructor
	public MyQueue () {
		head = null;
	}
	
	//isEmpty Method
	@Override
	public boolean isEmpty() {
		boolean ans = true;
		if ( head != null ) {
			ans = false;
		}
		return ans;
	}

	//Enqueue Method
	@Override
	public void enqueue(T x) {
		
		
		if (head == null) {
			head = new MyNode<T> (x, null);
		}
		else {
			MyNode<T> temp = head;
			while ( temp.next != null ) {
					temp = temp.next;
			}
			temp.next = new MyNode<T> (x, null);
		}
	}

	//Dequeue Method
	@Override
	public T dequeue() {
		T ans = null;
		if (isEmpty() == false) {
			
			//Returns Head
			ans = head.data;			
			
			//Delete Head
			if ( head.next == null ) {
				head = null;
			}
			else if ( head.next != null ) {
				head.data = head.next.data;
				head.next = head.next.next;
			}
			
		}
		return ans;
	}

	//Peek Method
	@Override
	public T peek() {
		T ans = null;
		if (isEmpty() == false) {
			ans = head.data;	//Return head
		}
		return ans;
	}
	
}
