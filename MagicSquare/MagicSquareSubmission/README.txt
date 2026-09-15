********
* Magic Square
* CS 221
* 9/2/26
* Zachary Jessup
********

OVERVIEW:
This program either takes a matrix given by the user, 
or creates one with the user, 
and checks if it is a magic square.

INCLUDED FILES:
README.txt - This file, for documentation and answering questions
MagicSquareInterface.java - MagicSquare implements this
MagicSquare.java - What the project is about, creates or reads a matrix, implementing MagicSquareInterface
MagicSquareDriver.java - Driver file with main method as is required

COMPILING AND RUNNING:
Ensure you are in the directory containing all required files.
To Compile:
javac MagicSquareDriver.java
To Run:
java MagicSquareDriver <-check | -create> <filename> < |size>
i.e.  java MagicSquareDriver -create myMatrix.txt 5

The results should appear in the console, and if you create a file,
the file will be in the directory you run the program in.

PROGRAM DESIGN AND IMPORTANT CONCEPTS:

This program has two constructos, one for already made matrices and one to create a matrix.

The interface helped me create each constructor and the methods.

We import File and FIleNotFoundException that way we can actually write and read files in the directory.

I will be the first to admit the constructor for an already created matrix may be unecessary, 
but it works using a scanner to go through a file. This is the weakest part of the program.
However if it works, it works.

The first number in a file should be the dimensions, and then it should be the matrix after. If the 
matrix does not have the correct length, bad things will happen.

The constructor for a new matrix takes an inputed dimension from the command line,
then creates a matrix with that dimension that is guarenteed to be a magic square.

A magic square is a matrix that n(n^2 - 1) /2 = The sum of each individual row, column, and diagonal. 

The method isMagicSquare has all the code in order to check if a matrix is a magic square or not by checking
the sum of each row, column, and diagonal, as well as if each number from 1 to the dimension squared is present.

The getMatrix command gets the matrix. This is helpful for the toString command, 
which could be improved by using the getMatrix method which I did not use.

The toString method gives the dimensions of the matrix, the matrix, and says if it is or is not a magic square.

TESTING:

I tested this program by running it a few times with myMatrix.txt
The strategy was run it, see if the output was correct (which it rarely was) then debug.
Not getting the desired outcome meant something was wrong, so I would have to go and fix it little by little.
My program makes sure that the user inputs the correct -check and -create command, however as of
writing this, I cannot stop someone using -create with no other inputs. 

Ok I changed it. My program is mostly "idiot-proof" though I cannot be certain, as I have tried but there 
is always something I haven't thought of. I have Not encountered any bugs yet, though I think if a file has 
an incorrect first number that is not the correct dimensions, the program will not work properly.

DISCUSSION:

I did a lot of messing up. I misread how the sum was supposed to work, 
and I added up every number in the matrix instead of each individual row, column, and diagonal.
I did ask my friend for clarification though, as I was a bit too stressed to realize my error right away.

Because I did not notice the previous error, I assumed the issue was making sure the numbers up to 
the dimension squared was coded incorrectly. So I looked up on google how I would check 2 dimensional arrays,
and elarned about HashMaps, which will be useful in any array application I think.

All of the above clicked with a little bit of guidance. Another thing that clicked 
suddenly was the psuedocode description on how to create a Magic Square matrix. before
attempting to write the programming, I procrastinated that in particular because it looked challenging.
Upon reading it, it clicked isntantly, and I even messed up the code a bit and managed to fix it,
 understanding exactly where I went wrong.

