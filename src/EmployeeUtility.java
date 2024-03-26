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


    public void addEmployee(ArrayList<Employee> employees, int eNumber) {

        for(Employee employee : employees) {
            if (employee.getENumber() == eNumber) {
                System.out.println("The employee " + eNumber + " exists.");
                return;
            }
        }

            Scanner sc = new Scanner(System.in);
            System.out.print("Employee name: ");
            String name = sc.nextLine();
            System.out.print("Date of birth (dd-mm-yyyy): ");
            String dob = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("Admin or Driver (A or D): ");
            String cat = sc.nextLine();



        if(cat.equals("D")) {
            System.out.print("License: ");
            int license = sc.nextInt();
            sc.nextLine();
            System.out.print("Status: ");
            String status = sc.nextLine();
            anEmployee = new Driver(eNumber, name, dob, address, license, status);
        }
        else if(cat.equals("A")) {
            System.out.print("Position: ");
            String positon = sc.nextLine();
            anEmployee = new Admin(eNumber, name, dob, address, positon);
        }
        employees.add(anEmployee);

    }

    public void writeEmployeeData(ArrayList<Employee> employees) {
        String fName = "employees.txt";
        Path pathway = Paths.get(fName);
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
