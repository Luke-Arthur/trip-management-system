/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

import java.util.Formatter;
import java.util.Scanner;

/*
* This is the interface for MyFileIO class which forces the class to implement the following methods
* inputData(Scanner input) - to read data from a file
* outputData(Formatter format) - to write data to a file
* toString() - to return a string representation of the object
*  - the public accessor is redundant as all methods in an interface are public by default though the UML diagram specifies it
*  - the abstract is redundant as all methods in an interface are abstract by default
*  - each method is followed by a semicolon as there is no method body in an interface
*/

// Interface for MyFileIO class
public interface MyFileIO {
    // input data from a file
    public void inputData(Scanner input);
    // output data to a file
    public void outputData(Formatter format);
    // toString method to return a string representation of the object
    public String toString();

} // end of MyFileIO interface
