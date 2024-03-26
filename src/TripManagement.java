/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

import java.util.ArrayList;
import java.util.Scanner;

public class TripManagement {


    private ArrayList<Employee> employees;
    private  ArrayList<Truck> trucks;
    private  ArrayList<Trip> trips;
    private Scanner sc = new Scanner(System.in);
    private static TripManagement tripMan;
    private int tNum;
    private int eNumb;
    private String rego;


    public TripManagement() {
        this.employees  = new ArrayList<Employee>();
        this.trucks = new ArrayList<Truck>();
        this.trips = new ArrayList<Trip>();
        this.tNum = 0;
        this.eNumb = 0;
        this.rego = "";
    }


    //Diver method
    public static void main(String[] args) {
        tripMan = new TripManagement();
        MenuCycle menu = new MenuCycle();
        tripMan.loadEmployees();
        tripMan.loadTrucks();
        tripMan.loadTrips();
        menu.cycle(tripMan.sc,new EmployeeUtility(), tripMan.employees, new TruckUtility(), tripMan.trucks, new TripUtility(), tripMan.trips);
    }



    public void loadEmployees() {
        //load employees from file
        EmployeeUtility loadEmp = new EmployeeUtility();
        loadEmp.loadEmployeeData(employees);
    }

    public void loadTrucks() {
        //load trucks from file
        TruckUtility truckUtility = new TruckUtility();
        truckUtility.loadTruckData(trucks);
    }

    public void loadTrips() {
        //load trips from file
        TripUtility tripUtility = new TripUtility();
        tripUtility.loadTripData(trips);
    }









}// end of class