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
    String employeeNumberStr = "Employee number";
    String employeeNameStr = "Employee name";
    String dateOfBirthStr = "Date of birth";
    String addressStr = "Address";

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
        return String.format("%s:%d,%s:%s,%s:%s,%s:%s,", employeeNumberStr, this.eNumber, employeeNameStr, this.name, dateOfBirthStr, this.dob, addressStr, this.address);
    }

}
