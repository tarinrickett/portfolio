package project2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Calculator {
	
	//Infix: 1+2
	//Prefix: +12
	//Postfix: 12+
	
	static ArrayList<String> evaluations = new ArrayList<String>();
	
	//Read File
	public static void readByLine (String filename) {
		File file = new File (filename);
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader (reader);
			String line;
			while ((line = br.readLine()) != null) {
				inToPost(line); //Change expression to postfix and calculate
			}
			br.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Convert infix to postfix
	public static void inToPost (String line) {
		lab06.MyStack<String> stack = new lab06.MyStack<String>(); //For each line, create a stack
		lab07.MyQueue<String> queue = new lab07.MyQueue<String>(); //and a queue
		for (int j = 0; j < line.length(); j++) { //Iterate through each character
			char c = line.charAt(j);
			//Add numbers to queue
			if (Character.isDigit(c)) {
				String num = Character.toString(c);
				//Account for double digit and decimal numbers
				while (j+1 < line.length() && (Character.isDigit(line.charAt(j+1)) || (line.charAt(j+1) == '.'))) {
					char d = line.charAt(j+1);
					j++;
					num += d;
				}
				queue.enqueue(num);
			}
			else {
				switch (c) {
				// OPERATOR: Pop all stack symbols and send to queue until a symbol of lower precedence 
				// (or a right-associative symbol of equal precedence) appears.
				// Push operator
				case '+': 
					if (stack.peek() != null) {
						char[] carray = stack.peek().toCharArray();
						while (stack.peek() != null && (precedence(carray[0]) > precedence(c))) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push("+");
					break;
				case '-':
					if (stack.peek() != null) {
						char[] carray = stack.peek().toCharArray();
						while (stack.peek() != null && (precedence(carray[0]) > precedence(c))) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push("-");
					break;
				case '/':
					if (stack.peek() != null) {
						char[] carray = stack.peek().toCharArray();
						while (stack.peek() != null && (precedence(carray[0]) > precedence(c))) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push("/");
					break;
				case '*':
					if (stack.peek() != null) {
						char[] carray = stack.peek().toCharArray();
						while (stack.peek() != null && (precedence(carray[0]) > precedence(c))) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push("*");
					break;
				case '^':
					if (stack.peek() != null) {
						char[] carray = stack.peek().toCharArray();
						while (stack.peek() != null && (precedence(carray[0]) > precedence(c))) {
							System.out.println("\t" + stack.peek());
							queue.enqueue(stack.pop());
						}
					}
					stack.push("^");
					break;
				case '<':
					if (stack.peek() != null) {
						char[] carray = stack.peek().toCharArray();
						while (stack.peek() != null && (precedence(carray[0]) > precedence(c))) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push("<");
					break;
				case '>':
					if (stack.peek() != null) {
						char[] carray = stack.peek().toCharArray();
						while (stack.peek() != null && (precedence(carray[0]) > precedence(c))) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push(">");
					break;
				case '=':
					if (stack.peek() != null) {
						char[] carray = stack.peek().toCharArray();
						while (stack.peek() != null && (precedence(carray[0]) > precedence(c))) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push("=");
					break;
				case '&':
					if (stack.peek() != null) {
						char[] carray = stack.peek().toCharArray();
						while (stack.peek() != null && (precedence(carray[0]) > precedence(c))) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push("&");
					break;
				case '|':
					if (stack.peek() != null) {
						char[] carray = stack.peek().toCharArray();
						while (stack.peek() != null && (precedence(carray[0]) > precedence(c))) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push("|");
					break;
				case '!':
					if (stack.peek() != null) {
						char[] carray = stack.peek().toCharArray();
						while (stack.peek() != null && (precedence(carray[0]) > precedence(c))) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push("!");
					break;
				// Pop stack & send to queue until you find an open parenthesis
				case ')':
					if (stack.peek() != null) {
						while (stack.peek() != null && !(stack.peek().equals("("))) {
							queue.enqueue(stack.pop());
						}
						if (stack.peek() != null && stack.peek().equals("(")) {
							stack.pop();
						}
						break;
					}
				case '(':
					stack.push("(");
					break;
				case ' ':
					break;
				}
			}
			//EOF, pop all remaining stack symbols and add to queue
			if (j == line.length() - 1) {
				while (stack.peek() != null) {
					if (!(stack.peek().equals("("))) {
						queue.enqueue(stack.pop());
					}
					else {
						stack.pop();
					}
				}
			}
		}
		calc(queue); //Calculate Result
	}
	
	//Calculate
	public static void calc (MyQueue<String> queue) {
		MyStack<String> stack = new MyStack<String>();
		while (queue.peek() != null) {
			// OPERATOR: Pop two stack values, Perform binary operation, Push result
			if (queue.peek().equals("+") ) { 
				String a = stack.pop();
				String b = stack.pop();
				double aa = Double.parseDouble(a);
				double bb = Double.parseDouble(b);
				double ans = aa+bb;
				String stringAns = String.valueOf(ans);
				stack.push(stringAns);
				queue.dequeue();
			} else if (queue.peek().equals("-")) {
				String a = stack.pop();
				String b = stack.pop();
				double aa = Double.parseDouble(a);
				double bb = Double.parseDouble(b);
				double ans = bb-aa;
				String stringAns = String.valueOf(ans);
				stack.push(stringAns);
				queue.dequeue();
			} else if (queue.peek().equals("*")) {
				String a = stack.pop();
				String b = stack.pop();
				double aa = Double.parseDouble(a);
				double bb = Double.parseDouble(b);
				double ans = aa*bb;
				String stringAns = String.valueOf(ans);
				stack.push(stringAns);
				queue.dequeue();
			} else if (queue.peek().equals("/")) {
				String a = stack.pop();
				String b = stack.pop();
				double aa = Double.parseDouble(a);
				double bb = Double.parseDouble(b);
				double ans = bb/aa;
				String stringAns = String.valueOf(ans);
				stack.push(stringAns);
				queue.dequeue();
			} else if (queue.peek().equals("^")) {
				String a = stack.pop();
				String b = stack.pop();
				double aa = Double.parseDouble(a);
				double bb = Double.parseDouble(b);
				double ans = Math.pow(aa, bb);
				String stringAns = String.valueOf(ans);
				stack.push(stringAns);
				queue.dequeue();
			} else if (queue.peek().equals("<")) {
				String a = stack.pop();
				String b = stack.pop();
				double aa = Double.parseDouble(a);
				double bb = Double.parseDouble(b);
				double ans = 0;
				if (bb < aa) {
					ans = 1;
				}
				String stringAns = String.valueOf(ans);
				stack.push(stringAns);
				queue.dequeue();
			} else if (queue.peek().equals(">")) {
				String a = stack.pop();
				String b = stack.pop();
				double aa = Double.parseDouble(a);
				double bb = Double.parseDouble(b);
				double ans = 0;
				if (bb > aa) {
					ans = 1;
				}
				String stringAns = String.valueOf(ans);
				stack.push(stringAns);
				queue.dequeue();
			} else if (queue.peek().equals("=")) {
				String a = stack.pop();
				String b = stack.pop();
				double aa = Double.parseDouble(a);
				double bb = Double.parseDouble(b);
				double ans = 0;
				if (aa == bb) {
					ans = 1;
				}
				String stringAns = String.valueOf(ans);
				stack.push(stringAns);
				queue.dequeue();
			} else if (queue.peek().equals("&")) {
				String a = stack.pop();
				String b = stack.pop();
				double aa = Double.parseDouble(a);
				double bb = Double.parseDouble(b);
				double ans = 0;
				if (aa == 1 && bb == 1) {
					ans = 1;
				}
				String stringAns = String.valueOf(ans);
				stack.push(stringAns);
				queue.dequeue();
			} else if (queue.peek().equals("|")) {
				String a = stack.pop();
				String b = stack.pop();
				double aa = Double.parseDouble(a);
				double bb = Double.parseDouble(b);
				double ans = 0;
				if (aa == 1 || bb == 1) {
					ans = 1;
				}
				String stringAns = String.valueOf(ans);
				stack.push(stringAns);
				queue.dequeue();
			} else if (queue.peek().equals("!")) {
				String a = stack.pop();
				double aa = Double.parseDouble(a);
				double ans = 0;
				if (aa == 0) {
					ans = 1;
				} else if (aa == 1) {
					ans = 0;
				}
				String stringAns = String.valueOf(ans);
				stack.push(stringAns);
				queue.dequeue();
			}
			else { //OPERAND: push onto stack
				stack.push(queue.dequeue());
			}
			if (queue.peek() == null) { //EOF: pop final result 
				String finalAns = stack.pop();
				evaluations.add(finalAns);
			}
		}
	}
	
	//Determine precedence of operators
	public static int precedence (char c) {
		switch (c) {
			case '(':
			case ')': 
				return 1;
			case '&':
			case '|': 
			case '!':
				return 2;
			case '<':
			case '>':
			case '=':
				return 3;
			case '+':
			case '-':
				return 4;
			case '*':
			case '/':
				return 5;
			case '^':
				return 6;
			default:
				return 0; //If invalid character, returns lowest precedence
		}
	}
	
	//Write evaluations to output stream
	public static void writeByLine (String filename) {
		try {
			File file = new File (filename);
			FileWriter writer = new FileWriter (file);
			for (int i = 0; i < evaluations.size(); i++) {
				String out = evaluations.get(i);
				writer.write(out + "\n");
				writer.flush();
			}
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//Main method
	public static void main (String [] args) {
		readByLine(args[0]);
		writeByLine(args[1]);
	}

}
