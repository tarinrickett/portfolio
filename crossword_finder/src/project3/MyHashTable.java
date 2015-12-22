/*
 * Tarin Rickett
 * Project 3
 * CSC 172
 * Mamiko
 * Last edited: 11/21/15
 */

package project3;

public class MyHashTable {
	
	String [] hashtable;
	private int capacity = 0; //capacity of array
	private int unique = 0; //total unique words added
	private double load = 0.5; //load factor is .5
	private int hashcode = 0;
	
	//Constructor
	public MyHashTable (int capacity) {
		this.capacity = capacity;
		hashtable = new String [capacity];
	}
	
	public int getHashcode () {
		return this.hashcode;
	}
	
	public int getHashcode (String s) {
		lookUp(s);
		return this.hashcode;
	}
	
	public int getCapacity () {
		return this.capacity;
	}
	
	public int getUnique () {
		return this.unique;
	}
	
	public double getLoad () {
		return this.load;
	}
	
	//Hash ÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐ
	public int hash (String s, String [] hashtable, int capacity) {
		//djb2 algorithm: hash = ((hash << 5) + hash) + c; /* hash * 33 + c */ 
		hashcode = 5381;
		int count = 0;
		do {
			for (int i = 0; i < s.length(); i++) {
				hashcode = ((hashcode << 5) + hashcode) + s.charAt(i);
			}
			hashcode = Math.abs(hashcode);
			hashcode = (int)hashcode%capacity;
			if (hashtable[hashcode] == null) { //until no collision
				break;
			}
			else if (hashtable[hashcode].equals(s)) { //for lookUp
				break;
			}
			else if (count >= 50) {
				do {
					hashcode += 1;
					hashcode = Math.abs(hashcode);
					hashcode = (int)hashcode%capacity;
					if (hashtable[hashcode] == null) { //until no collision
						break;
					}
					else if (hashtable[hashcode].equals(s)) { //for lookUp
						break;
					}
				} while((hashtable[hashcode] != null) || !(hashtable[hashcode].equals(s)));
				break;
			}
			count++;
		}
		while ((hashtable[hashcode] != null) || !(hashtable[hashcode].equals(s))); 
		return hashcode;
	}

	// LookUp word ÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐ
	public boolean lookUp (String s) {
		boolean exists = false;
		hash(s, hashtable, capacity);
		if (hashtable[hashcode] != null) {
			if (hashtable[hashcode].equalsIgnoreCase(s)) {
				exists = true;
			}
		}
		return exists;
	}
	
	//Word insert ÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐ
	public void insert (String s) {
		if (!lookUp(s)) {
			//Check load factor
			if (unique >= (int)(capacity*load)) {
				extend();
			}
			//HashFunction
			hashtable[hashcode] = s; //hashcode found during lookUp
			unique++;
		}
	}
	
	//Extend ÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐ
	public void extend () {
		capacity = capacity*2;
		String [] hashtableEx = new String [capacity];
		for (int i = 0; i < hashtable.length; i++) {
			if (hashtable[i] != null) {
				hash(hashtable[i], hashtableEx, capacity);
				hashtableEx[hashcode] = hashtable[i];
			}
		}
		hashtable = hashtableEx;
	}
	
	//Print ÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐÐ
	public void print() {
		for (int i = 0; i < hashtable.length; i++) {
			if (hashtable[i] != null) {
				System.out.println(i + ": \t" + hashtable[i]);
			}
		}
	}

}
