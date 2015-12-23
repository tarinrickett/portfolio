Name: Tarin Rickett
Course: CSC 172 Fall 2015
Assignment: Infix to Postfix Calculator

DESCRIPTION: 
readByLine reads in the file taken from args[0]. It also calls inToPost on each line of 
the input file. inToPost changes the expressions from infix to postfix. Precedence is 
used to determine the order of operations of the operators. inToPost then calls calc, 
which calculates the postfix expressions. Finally, writeByLine is called, which writes 
the results to a new file

————————————————————————————————————————————————————————————————————————————————————————

OUTPUT:
cd …/csc172
javac src/lab06/*.java
javac src/lab07/*.java
javac src/project2/Calculator.java
java -cp src/project2/Calculator ex.txt output.txt