/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class EmployeeUtility {

    // ====================================== instance variables ==============================
    Employee anEmployee;

    // ====================================== constructor ==============================

    //constructor
    public EmployeeUtility() {
        // call the loadEmployeeData method to load the employees from the file when the EmployeeUtility object is created
        loadEmployeeData(new ArrayList<>());
    }

    // ====================================== methods ==============================

    //load employees from file
    public void loadEmployeeData(ArrayList<Employee> employees) {

        String fName = "Employees.txt";
        Path pathway = Paths.get(fName);
        try {
            if(Files.exists(pathway)) {

                if(!Files.isDirectory(pathway)) { //Not a directory, read data
                    Scanner scan = new Scanner(pathway);
                    scan.useDelimiter(", |\\r\\n|\\n");
                    while(scan.hasNext()) {
                        String cat = scan.next();
                        //if the category is driver create a driver object
                        if(cat.equals("D")) {
                            anEmployee = new Driver();
                            // give the driver object the input data
                            anEmployee.inputData(scan);
                        }
                        // if the category is admin create an admin object
                        else if(cat.equals("A")) {
                            anEmployee = new Admin();
                            // give the admin object the input data
                            anEmployee.inputData(scan);
                        }
                        // add the employee object to the employees arraylist
                        employees.add(anEmployee);
                    }

                    scan.close();
                }
                else
                    System.out.printf("File %s does not exist", pathway);

            }
        }
        catch (IOException errorCatch) {
            System.out.println("IO exception error");
        }

    }


    //print employees
    public void printEmployeeData(ArrayList<Employee> employees) {
        for(Employee employee : employees) {
            System.out.println(employee);
        }
    }

    //find employee
    public void findEmployee(ArrayList<Employee> employees, int eNumber) {
        // loop through the employees arraylist and check if the employee number exists
        for(Employee employee : employees) {
            if(employee.getENumber() == eNumber) {
                // if the employee number exists, print the employee details
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Employee " + eNumber + " does not exist");
    }


    // add employee
    public void addEmployee(Scanner sc, ArrayList<Employee> employees, int eNumber, Validation validation) {
        // loop through the employees arraylist and check if the employee number exists
        for(Employee employee : employees) {
            // if the employee number exists, print a message and return
            if (employee.getENumber() == eNumber) {
                System.out.println("The employee " + eNumber + " exists.");
                return;
            }
        }
            // if the employee number does not exist, prompt the user to enter the employee details
            String eNamePrompt = "Employee name: ";
            System.out.print(eNamePrompt);
            String name = validation.getJustStringInput(sc, eNamePrompt, "Invalid input. Please enter a valid name.");
            name = validation.capitaliseFirstLetter(name);
            String dobPrompt = "Date of birth (dd-mm-yyyy): ";
            String dob = validation.readDate(sc, dobPrompt);
            sc.nextLine();
            String addressPrompt = "Address: ";
            System.out.print(addressPrompt);
            String address = validation.getMixedStringInput(sc, addressPrompt);
            address = address.toLowerCase();
            String catPrompt = "Admin or Driver (A or D): ";
            System.out.print(catPrompt);
            String cat = validation.employeeTypeInput(sc, catPrompt, "Invalid input. Please enter A or D.");


        // create a new employee object based on the category entered by the user and add it to the employees arraylist
        if(cat.equals("D")) {
            // if the category is driver create a driver object
            String licensePrompt = "License: ";
            int license = validation.getIntInput(sc, licensePrompt);
            sc.nextLine();
            String statusPrompt = "Status: ";
            System.out.print(statusPrompt);
            String status = validation.getJustStringInput(sc, statusPrompt, "Invalid input. Please enter a valid status.");
            status = status.toUpperCase();
            anEmployee = new Driver(eNumber, name, dob, address, license, status);
        }
        // if the category is admin create an admin object
        else if(cat.equals("A")) {
            String positionPrompt = "Position: ";
            System.out.print(positionPrompt);
            String positon = validation.getJustStringInput(sc, positionPrompt, "Invalid input. Please enter a valid position.");
            positon = positon.toUpperCase();
            anEmployee = new Admin(eNumber, name, dob, address, positon);
        }
        employees.add(anEmployee);

    }

    // write employees to file. This is used in option 10 of the menu cycle
    public void writeEmployeeData(ArrayList<Employee> employees) {
        String fName = "employees.txt";
        // try to write the employee data to the file
        try {
            Formatter output = new Formatter(fName);
            for (Employee employee : employees) {
                employee.outputData(output);
            }
            output.close();
        // catch any IO exceptions that may occur
        } catch (IOException errorCatch) {
            System.out.println("IO exception error");
        }
    }

}//end of class
