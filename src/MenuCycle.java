import java.util.ArrayList;
import java.util.Scanner;

public class MenuCycle {

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

    //the menu that loops until the user inputs Zero
    public void cycle(Scanner sc, EmployeeUtility employeeUtility, ArrayList<Employee> employees, TruckUtility truckUtility, ArrayList<Truck> trucks, TripUtility tripUtility, ArrayList<Trip> trips) {
            int choice;

            do {
                menu();
                String prompt = "Input a choice (0-10): ";
                Validation validation = new Validation();
                choice = validation.getExitIntInput(sc, prompt);
                sc.nextLine();
                switch (choice) {

                    case 1:
                        employeeUtility.printEmployeeData(employees);
                        System.out.println();
                        break;

                    case 2:
                        truckUtility.printTruckData(trucks);
                        System.out.println();
                        break;
                    case 3:
                        tripUtility.printTripData(trips);
                        System.out.println();
                        break;

                    case 4:
                        String prompt4 = "Employee number: ";
                        int eNumber = validation.getIntInput(sc, prompt4);
                        employeeUtility.findEmployee(employees, eNumber);
                        System.out.println();
                        break;


                    case 5:
                        String prompt5 ="Truck rego: ";
                        System.out.print(prompt5);
                        String rego = validation.getMixedStringInput(sc, prompt5);
                        truckUtility.findTruck(trucks, rego);
                        System.out.println();
                        break;


                    case 6:
                        String prompt6 = "Trip number: ";
                        int tripNumber = validation.getIntInput(sc, prompt6);
                        tripUtility.findTrip(trips, tripNumber);
                        System.out.println();
                        break;


                    case 7:
                        String prompt7 = "Employee number: ";
                        int eNum = validation.getIntInput(sc, prompt7);
                        sc.nextLine();
                        employeeUtility.addEmployee(employees, eNum, validation);
                        System.out.println();
                        break;


                    case 8:
                        String prompt8 = "Truck rego: ";
                        System.out.print(prompt8);
                        String reg = validation.getMixedStringInput(sc, prompt8);
                        truckUtility.addTruck(trucks, reg, validation);
                        System.out.println();
                        break;


                    case 9:
                        String prompt9 = "Trip number: ";
                        int tNum = validation.getIntInput(sc, prompt9);
                        sc.nextLine();
                        tripUtility.addTrip(trips, tNum, validation);
                        System.out.println();
                        break;


                    case 10:
                        employeeUtility.writeEmployeeData(employees);
                        truckUtility.writeTruckData(trucks);
                        tripUtility.writeTripData(trips);
                        System.out.println("Data saved.");
                        System.out.println();
                        break;


                    case 0:
                        System.out.println("Bye-bye");
                        break;

                    default:
                        System.out.println("Input 0-10 for the selections.");
                        System.out.println();
                        break;
                }



            } while (choice != 0);

        }

}
