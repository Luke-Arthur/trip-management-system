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
    Employee anEmployee;
    public EmployeeUtility() {
        loadEmployeeData(new ArrayList<>());
    }


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
                        if(cat.equals("D")) {
                            anEmployee = new Driver();
                            anEmployee.inputData(scan);
                        }
                        else if(cat.equals("A")) {
                            anEmployee = new Admin();
                            anEmployee.inputData(scan);
                        }
                        employees.add(anEmployee);
                    }


                }
                else
                    System.out.printf("File %s does not exist", pathway);

            }
        }
        catch (IOException errorCatch) {
            System.out.println("IO exception error");
        }
    }



    public void printEmployeeData(ArrayList<Employee> employees) {
        for(Employee employee : employees) {
            System.out.println(employee);
        }
    }


    public void findEmployee(ArrayList<Employee> employees, int eNumber) {
        for(Employee employee : employees) {
            if(employee.getENumber() == eNumber) {
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Employee " + eNumber + " does not exist");
    }


    public void addEmployee(ArrayList<Employee> employees, int eNumber, Validation validation) {

        for(Employee employee : employees) {
            if (employee.getENumber() == eNumber) {
                System.out.println("The employee " + eNumber + " exists.");
                return;
            }
        }

            Scanner sc = new Scanner(System.in);
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
            String catPrompt = "Admin or Driver (A or D): ";
            System.out.print(catPrompt);
            String cat = validation.employeeTypeInput(sc, catPrompt, "Invalid input. Please enter A or D.");



        if(cat.equals("D")) {
            String licensePrompt = "License: ";
            int license = validation.getIntInput(sc, licensePrompt);
            sc.nextLine();
            String statusPrompt = "Status: ";
            System.out.print(statusPrompt);
            String status = validation.getJustStringInput(sc, statusPrompt, "Invalid input. Please enter a valid status.");
            status = status.toUpperCase();
            anEmployee = new Driver(eNumber, name, dob, address, license, status);
        }
        else if(cat.equals("A")) {
            String positionPrompt = "Position: ";
            System.out.print(positionPrompt);
            String positon = validation.getJustStringInput(sc, positionPrompt, "Invalid input. Please enter a valid position.");
            positon = positon.toUpperCase();
            anEmployee = new Admin(eNumber, name, dob, address, positon);
        }
        employees.add(anEmployee);

    }

    public void writeEmployeeData(ArrayList<Employee> employees) {
        String fName = "employees.txt";
        try {
            Formatter output = new Formatter(fName);
            for (Employee employee : employees) {
                employee.outputData(output);
            }
            output.close();
        } catch (IOException errorCatch) {
            System.out.println("IO exception error");
        }
    }

}//end of class
