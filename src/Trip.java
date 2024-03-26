/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Trip implements MyFileIO {

    private int tripNumber;
    private int License;
    private String rego;
    private String tripDate;
    private ArrayList<TripLeg> legs;


    public Trip() {
        this.tripNumber = 0;
        this.License = 0;
        this.rego = "";
        this.tripDate = "";
        this.legs = new ArrayList<TripLeg>();
    }


    public Trip(int tripNumber, int License, String rego, String tripDate, ArrayList<TripLeg> legs) {
        this.tripNumber = tripNumber;
        this.License = License;
        this.rego = rego;
        this.tripDate = tripDate;
        this.legs = legs;
    }


    //======================================getters and setters======================================

    public int getTripNumber() {
        return tripNumber;
    }


    public String getTripDate() {
        return tripDate;
    }


    // ====================================== implementation of MyFileIO interface ==============================

    @Override
    public void inputData(Scanner input) {
        try {
            tripNumber = input.nextInt();
            License = input.nextInt();
            rego = input.next();
            tripDate = input.next();
            int numLegs = input.nextInt();
            input.nextLine();
            for (int i = 0; i < numLegs; i++) {
                TripLeg leg = new TripLeg();
                leg.inputData(input);
                legs.add(leg);
            }
        }
        catch (Exception e) {
            System.out.println("Wrong input data type. " + e);
            e.printStackTrace();
        }
    }

    /*A trip record consists of a trip number, a driver’s license number, a truck registration number, a trip date and
followed by a total number of trip legs and 1 or more trip leg records accordingly.*/
    @Override
    public void outputData(Formatter format) {
        String result = String.format("%d, %d, %s, %s %n%d", tripNumber, License, rego, tripDate, legs.size());
        //for each loop iterates the array list and returns a trip leg
        format.format("%s\n", result);
        for(TripLeg trips: legs) {
           trips.outputData(format);
        }

    }

    //Trip number: 1, license: 10001, Rego: PKR768, Trip date: 01-12-2021
    public String toString() {
        String result = String.format("Trip number: %d, license: %d, Rego: %s, Trip date: %s%n", tripNumber, License, rego, tripDate);
        //for each loop iterates the array list and returns a trip leg
        for(TripLeg trips: legs) {
            result += trips;
        }
        //System.out.println();
        return result;

    }





}
