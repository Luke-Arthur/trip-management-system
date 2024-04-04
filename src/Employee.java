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

// Base class
public class Employee implements MyFileIO{

    // ====================================== instance variables ==============================
    private int eNumber;
    private String name;
    private String dob;
    private String address;


    // ====================================== constructors ==============================

    // default constructor
    public Employee() {
        this.eNumber = 0;
        this.name = "";
        this.dob = "";
        this.address = "";
    }

    // parameterised constructor
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

    // input data from the file to the object
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
        }
    }

    // output data from the object to the file
    @Override
    public void outputData(Formatter format) {
        format.format("%d, %s, %s, %s, ", this.eNumber, this.name, this.dob, this.address);
    }

    // return the data in a formatted string for display
    @Override
    public String toString() {
        String employeeNumberStr = "Employee number";
        String employeeNameStr = "Employee name";
        String dateOfBirthStr = "Date of birth";
        String addressStr = "Address";
        return String.format("%s: %d, %s: %s, %s: %s, %s: %s", employeeNumberStr, this.eNumber, employeeNameStr, this.name, dateOfBirthStr, this.dob, addressStr, this.address);
    }


} // end of Employee class



//==================================================== child classes =====================================================


/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

// child class of Employee
class Admin extends Employee{

    // ====================================== instance variables ==============================
    private String position;
    private String employeeType = "Admin";


    // ====================================== constructors ==============================

    // default constructor
    public Admin() {
        super();
        this.position = "";
    }

    // parameterised constructor
    public Admin(int eNumber, String name, String dob, String address, String position) {
        super(eNumber, name, dob, address);
        this.position = position;
    }

    // ====================================== implementation of MyFileIO interface ==============================
    // input data from the file to the object
    @Override
    public void inputData(Scanner input) {
        try {
            super.inputData(input);
            this.position = input.next();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // output data from the object to the file
    @Override
    public void outputData(Formatter format) {
        employeeType = "A";
        format.format("%s, ", employeeType);
        super.outputData(format);
        format.format("%s%n", this.position);
    }

    // return the data in a formatted string for display
    @Override
    public String toString() {
        String position = "Position: ";
        return  String.format("%s %s, %s%s", employeeType,super.toString(), position, this.position);
    }


} // end of Admin class


//=============================================== child classes =====================================================

/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

// child class of Employee
class Driver extends Employee {

    // ====================================== instance variables ==============================
    private int license;
    private String status;
    private String employeeType = "Driver";

    // ====================================== constructors ==============================
    // default constructor
    public Driver() {
        super();
        this.license = 0;
        this.status = "";
    }

    // parameterised constructor
    public Driver(int eNumber, String name, String dob, String address, int license, String status) {
        super(eNumber, name, dob, address);
        this.license = license;
        this.status = status;
    }

    // ====================================== implementation of MyFileIO interface ==============================
    // input data from the file to the object
    @Override
    public void inputData(Scanner input) {
        try {
            super.inputData(input);
            this.license = input.nextInt();
            this.status = input.next();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }

    // output data from the object to the file
    @Override
    public void outputData(Formatter format) {
        employeeType = "D";
        format.format("%s, ", employeeType);
        super.outputData(format);
        format.format("%d, %s%n", this.license, this.status);
    }

    // return the data in a formatted string for display
    @Override
    public String toString() {
        String status = "Status: ";
        String license = "License: ";
        return String.format("%s %s, %s%d, %s%s", employeeType, super.toString(), license, this.license, status, this.status);
    }

} // end of Driver class