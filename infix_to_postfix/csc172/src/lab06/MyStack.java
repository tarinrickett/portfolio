package lab06;

/*
 * MyStack.java
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

public class MyStack<T> implements Stack<T> {
	
	public MyNode<T> head;
	
	//Constructor
	public MyStack () {
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

	//Push Method
	@Override
	public void push(T x) {
		if (head == null) {
			MyNode<T> insert = new MyNode<T> (x, null);
			head = insert;
		}
		else { 
			MyNode<T> next = head;
			MyNode<T> insert = new MyNode<T> (x, next);
			head = insert;
		}
	}

	//Pop Method
	@Override
	public T pop() {
		T ans = null;
		if (isEmpty() == false) {
			
			//Return head
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
