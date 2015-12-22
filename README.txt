Name: Tarin Rickett
Course: CSC 172 Fall 2015

DESCRIPTION: 

This program reads in a crossword puzzle and returns a .txt file with all words found.

readByLine reads in the file taken from args[0], the dictionary. It inserts word s
into a dictionary hashtable. For my hashfunction, I applied the djb2 algorithm: 
	hash = ((hash << 5) + hash) + c; /* hash * 33 + c */
	(found at: http://www.cse.yorku.ca/~oz/hash.html)
	(referenced: https://goo.gl/OfcIDY)

To save space and reduce runtime, my method only adds words that are the size of the 
puzzle or smaller (a 10x10 puzzle can't contain a word that's 11 letters long)

readPuzzle reads in the file taken from args[1], the puzzle itself. It constructs an 
square array based on the size of the initial line.

find method is what finds the words hidden in the wordsearch. Using multiple for loops 
for various directions, words are searched for forwards and backwards across, down, and 
diagonally. Any words found in the word search and looked up in the dictionary (checked 
by re-evaluating the hashcode of the word in question and searching in that spot to see 
if an equivalent string exists there) are added to an arraylist of found letters.

Finally, writeByLine writes out all the letters from found into a file named by args[2]

–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––

NOTES:
Words less than 3 letters long are not included

–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––

OUTPUT:
cd …/crossword_finder
javac src/project3/*.java
java -cp src project3.Test linux.words puzzle20x20.txt output.txt
