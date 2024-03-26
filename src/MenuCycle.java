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
            menu();
            System.out.print("Input a choice (0-10): ");
            int choice = sc.nextInt();
            do {
                switch (choice) {

                    case 1:
                        employeeUtility.printEmployeeData(employees);
                        break;

                    case 2:
                        truckUtility.printTruckData(trucks);
                        break;
                    case 3:
                        tripUtility.printTripData(trips);
                        break;

                    case 4:
                        System.out.print("Employee number: ");
                        int eNumber = sc.nextInt();
                        employeeUtility.findEmployee(employees, eNumber);
                        break;


                    case 5:
                        System.out.print("Truck rego: ");
                        String rego = sc.next();
                        truckUtility.findTruck(trucks, rego);
                        break;


                    case 6:
                        System.out.print("Trip number: ");
                        int tripNumber = sc.nextInt();
                        tripUtility.findTrip(trips, tripNumber);
                        break;


                    case 7:
                        System.out.print("Employee number: ");
                        int eNum = sc.nextInt();
                        employeeUtility.addEmployee(employees, eNum);
                        break;


                    case 8:
                        System.out.print("Truck rego: ");
                        String reg = sc.next();
                        truckUtility.addTruck(trucks, reg);
                        break;


                    case 9:
                        System.out.print("Trip number: ");
                        int tNum = sc.nextInt();
                        tripUtility.addTrip(trips, tNum);
                        break;


                    case 10:
                        employeeUtility.writeEmployeeData(employees);
                        truckUtility.writeTruckData(trucks);
                        tripUtility.writeTripData(trips);
                        System.out.println("Data saved.");
                        break;


                    case 0:
                        System.out.println("Bye-bye");
                        break;


                    default:
                        System.out.println("Input 0-10 for the selections.");
                        break;
                }
                if(choice != 0) {
                    System.out.println();
                    menu();
                    System.out.print("Input a choice (0-10): ");
                    choice = sc.nextInt();

                }
            } while (choice != 0);

        }

}
