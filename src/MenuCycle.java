/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCycle {


    // ====================================== MenuCycle methods ==============================

    //the menu that displays the options
    public void menu() {
        String menu = """
                1. Display all employees.
                2. Display all trucks.
                3. Display all trips.
                4. Find an employee.
                5. Find a truck.
                6. Find a trip.
                7. Add a new employee.
                8. Add a new truck.
                9. Add a new trip.
                10. Save all data into files.
                0. Exit.\s
                """;
        System.out.print(menu);
    }


    //The cycle method that runs the program and allows the user to select options from the menu
    public void cycle(Scanner sc, EmployeeUtility employeeUtility, ArrayList<Employee> employees, TruckUtility truckUtility, ArrayList<Truck> trucks, TripUtility tripUtility, ArrayList<Trip> trips) {
            int choice;
            boolean firstCycle = true;

            // do-while loop that runs the program until the user selects 0 to exit
            do {

                // if it is not the first cycle, print a new line to separate the menu from the previous output
                if(!firstCycle) {
                    System.out.println();
                }
                // display the menu
                menu();
                String prompt = "Input a choice (0-10): ";
                Validation validation = new Validation();
                // validating the user input to ensure it is an integer between 0 and 10
                choice = validation.getExitIntInput(sc, prompt);
                sc.nextLine();
                // switch statement to select the appropriate option based on the user input
                switch (choice) {

                    // case 1: display all employees
                    case 1:
                        employeeUtility.printEmployeeData(employees);
                        break;

                    // case 2: display all trucks
                    case 2:
                        truckUtility.printTruckData(trucks);
                        break;

                    // case 3: display all trips
                    case 3:
                        tripUtility.printTripData(trips);
                        break;

                    // case 4: find an employee
                    case 4:
                        String prompt4 = "Employee number: ";
                        int eNumber = validation.getIntInput(sc, prompt4);
                        employeeUtility.findEmployee(employees, eNumber);
                        break;

                    // case 5: find a truck
                    case 5:
                        String prompt5 ="Truck rego: ";
                        System.out.print(prompt5);
                        String rego = validation.getMixedStringInput(sc, prompt5);
                        truckUtility.findTruck(trucks, rego);
                        break;

                    // case 6: find a trip
                    case 6:
                        String prompt6 = "Trip number: ";
                        int tripNumber = validation.getIntInput(sc, prompt6);
                        tripUtility.findTrip(trips, tripNumber);
                        break;

                    // case 7: add a new employee
                    case 7:
                        String prompt7 = "Employee number: ";
                        int eNum = validation.getIntInput(sc, prompt7);
                        sc.nextLine();
                        employeeUtility.addEmployee(employees, eNum, validation);
                        break;

                    // case 8: add a new truck
                    case 8:
                        String prompt8 = "Truck rego: ";
                        System.out.print(prompt8);
                        String reg = validation.getMixedStringInput(sc, prompt8);
                        truckUtility.addTruck(trucks, reg, validation);
                        break;

                    // case 9: add a new trip
                    case 9:
                        String prompt9 = "Trip number: ";
                        int tNum = validation.getIntInput(sc, prompt9);
                        sc.nextLine();
                        tripUtility.addTrip(trips, tNum, validation);
                        break;

                    // case 10: save all data into files
                    case 10:
                        employeeUtility.writeEmployeeData(employees);
                        truckUtility.writeTruckData(trucks);
                        tripUtility.writeTripData(trips);
                        System.out.println("Data saved.");
                        break;

                    // case 0: exit the program
                    case 0:
                        System.out.println("Bye-bye");
                        break;

                    // default case: if the user input is not between 0 and 10, print an error message
                    default:
                        System.out.println("Input 0-10 for the selections.");
                        break;
                }
                // set firstCycle to false so that the program does not print a new line before the menu on the first cycle
                firstCycle = false;

            // end the do-while loop if the user selects 0 to exit
            } while (choice != 0);

        }

}// end of MenuCycle class
