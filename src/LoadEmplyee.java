import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadEmplyee {

    //load employees from file
    public void loadEmployeeData(ArrayList<Employee> employees) {
        Employee anEmployee = null;

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




}
