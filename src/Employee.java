/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

import java.io.Serializable;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee implements MyFileIO, Serializable{

    private int eNumber;
    private String name;
    private String dob;
    private String address;


    public Employee() {
        this.eNumber = 0;
        this.name = "";
        this.dob = "";
        this.address = "";
    }

    public Employee(int eNumber, String name, String dob, String address) {
        this.eNumber = eNumber;
        this.name = name;
        this.dob = dob;
        this.address = address;
    }


    // ====================================== getters and setters ==============================

    public int getENumber() {
        return eNumber;
    }


    // ====================================== implementation of MyFileIO interface ==============================

    @Override
    public void inputData(Scanner input) {
        try {
            this.eNumber = input.nextInt();
            this.name = input.next();
            this.dob = input.next();
            this.address = input.next();
        } catch (InputMismatchException e) {
            System.out.println("Wrong input type. " + e);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            input.nextLine();
        }
    }

    @Override
    public void outputData(Formatter format) {
        format.format("%d, %s, %s, %s, ", this.eNumber, this.name, this.dob, this.address);
    }

    /*Driver Employee number: 1, Employee name: John Smith, Date of birth: 02-12-1971, Address: 42 Victoria
St. Hurstville NSW 2456, License: 10001, Position: AVAILABLE*/
    @Override
    public String toString() {
        return String.format("Employee number: %d, Employee name: %s, Date of birth: %s, Address: %s, ", this.eNumber, this.name, this.dob, this.address);
    }
}
