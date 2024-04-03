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
        }
    }

    @Override
    public void outputData(Formatter format) {
        format.format("%d, %s, %s, %s, ", this.eNumber, this.name, this.dob, this.address);
    }


    @Override
    public String toString() {
        String employeeNumberStr = "Employee number";
        String employeeNameStr = "Employee name";
        String dateOfBirthStr = "Date of birth";
        String addressStr = "Address";
        return String.format("%s: %d, %s: %s, %s: %s, %s: %s", employeeNumberStr, this.eNumber, employeeNameStr, this.name, dateOfBirthStr, this.dob, addressStr, this.address);
    }


} // end of Employee class

/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

class Admin extends Employee{

    private String position;
    private String employeeType = "Admin";

    public Admin() {
        super();
        this.position = "";
    }

    public Admin(int eNumber, String name, String dob, String address, String position) {
        super(eNumber, name, dob, address);
        this.position = position;
    }

    @Override
    public void inputData(Scanner input) {
        try {
            super.inputData(input);
            this.position = input.next();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    public void outputData(Formatter format) {
        employeeType = "A";
        format.format("%s, ", employeeType);
        super.outputData(format);
        format.format("%s%n", this.position);
    }

    @Override
    public String toString() {
        String position = "Position: ";
        return  String.format("%s %s, %s%s", employeeType,super.toString(), position, this.position);
    }


} // end of Admin class


/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/


class Driver extends Employee {

    private int license;
    private String status;
    private String employeeType = "Driver";


    public Driver() {
        super();
        this.license = 0;
        this.status = "";
    }

    public Driver(int eNumber, String name, String dob, String address, int license, String status) {
        super(eNumber, name, dob, address);
        this.license = license;
        this.status = status;
    }


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

    @Override
    public void outputData(Formatter format) {
        employeeType = "D";
        format.format("%s, ", employeeType);
        super.outputData(format);
        format.format("%d, %s%n", this.license, this.status);
    }
    // TODO: make the Driver and admin toString methods show a different message "driver" or "admin" for the type of employee


    @Override
    public String toString() {
        String status = "Status: ";
        String license = "License: ";
        return String.format("%s %s, %s%d, %s%s", employeeType, super.toString(), license, this.license, status, this.status);
    }


} // end of Driver class


