/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Truck implements MyFileIO {

    // ====================================== instance variables ==============================
    private String rego;
    private double capacity;
    private double weight;
    private String status;

    // ====================================== constructors ==============================

    // default constructor
    public Truck() {
        this.rego = "";
        this.capacity = 0.0;
        this.weight = 0.0;
        this.status = "";
    }

    // parameterised constructor
    public Truck(String rego, double capacity, double weight, String status) {
        this.rego = rego;
        this.capacity = capacity;
        this.weight = weight;
        this.status = status;
    }


    // ====================================== getters and setters ==============================

    public String getRego() {
        return rego;
    }

    // ============================== implementation of MyFileIO interface ==============================

    //input data from the file
    @Override
    public void inputData(Scanner input) {
        try {
            rego = input.next();
            capacity = input.nextDouble();
            weight = input.nextDouble();
            status = input.next();
        }
        //catch exception if the input data type is incorrect
        catch (InputMismatchException exception) {
            System.out.println("Wrong input data type. " + exception);
            // clear the buffer - stops a loop - found out the hard way
            input.next();
        }
    }

    //output data to the file
    @Override
    public void outputData(Formatter output) {
        output.format("%s, %.2f, %.2f, %s%n", rego, capacity, weight, status);
    }

    //return the data in a formatted string for display
    @Override
    public String toString() {
        return String.format( "Rego: %s, Capacity: %.2f, Weight: %.2f, Status: %s", rego, capacity, weight, status);
    }

}// end of class Truck
