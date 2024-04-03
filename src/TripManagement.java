/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

import java.util.ArrayList;
import java.util.Scanner;

/*
 * The TripManagement system, developed for CSIT213 assignment two, aims to manage logistics-related data by loading it from files
 * and storing it in collections such as ArrayLists. This approach facilitates structured data access and manipulation,
 * focusing on organising trips, trucks, and employee information effectively.
 */

public class TripManagement {

    // ====================================== Instance variables ==============================
    private ArrayList<Employee> employees;
    private  ArrayList<Truck> trucks;
    private  ArrayList<Trip> trips;
    private final Scanner sc;
    private final EmployeeUtility employeeUtility;
    private final TruckUtility truckUtility;
    private final TripUtility tripUtility;


    // ====================================== Constructor ==============================
    public TripManagement() {
        // A new TripManagement object will create new ArrayLists for employees, trucks and trips
        this.employees  = new ArrayList<>();
        this.trucks = new ArrayList<>();
        this.trips = new ArrayList<>();
        this.tripUtility = new TripUtility();
        this.truckUtility = new TruckUtility();
        this.employeeUtility = new EmployeeUtility();
        this.sc = new Scanner(System.in);
    }

    // ====================================== Driver ===================================
    public static void main(String[] args) {
        TripManagement tripMan = new TripManagement();
        MenuCycle menu = new MenuCycle();
        tripMan.loadEmployees();
        tripMan.loadTrucks();
        tripMan.loadTrips();
        menu.cycle(tripMan.sc, tripMan.employeeUtility, tripMan.employees, tripMan.truckUtility, tripMan.trucks, tripMan.tripUtility, tripMan.trips);
    }

    // ====================================== Load data methods ==============================
    public void loadEmployees() {
        //load employees from file
        employeeUtility.loadEmployeeData(employees);
    }

    public void loadTrucks() {
        //load trucks from file
        truckUtility.loadTruckData(trucks);
    }

    public void loadTrips() {
        //load trips from file
        tripUtility.loadTripData(trips);
    }

}// end of class