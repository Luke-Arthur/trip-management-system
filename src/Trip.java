/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

import java.util.*;

/*
 * The trip class is used to store trip information such as trip number, driver's license number, truck registration number,
 * trip date and an array list of trip legs. The trip legs are stored in an array list of trip leg objects.
 * The trip class implements the MyFileIO interface to read and write data to a file.
 * The trip class also has a toString method to return a string representation of the trip object.
 */

// Trip class implements the MyFileIO interface
public class Trip implements MyFileIO {

    // ====================================== Instance variables ==============================
    private int tripNumber;
    private int License;
    private String rego;
    private String tripDate;
    private ArrayList<TripLeg> legs;

    // ====================================== Constructor ======================================

    // Default constructor
    public Trip() {
        this.tripNumber = 0;
        this.License = 0;
        this.rego = "";
        this.tripDate = "";
        this.legs = new ArrayList<>();
    }

    // Constructor with parameters
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

    public ArrayList<TripLeg> getLegs() {
        return legs;
    }

    // ====================================== implementation of MyFileIO interface ==============================

    // Method to read data from a file and store it in the trip object.
    @Override
    public void inputData(Scanner input) {
        try {
            tripNumber = input.nextInt();
            License = input.nextInt();
            rego = input.next();
            tripDate = input.next();

            // Check if there's an upcoming integer for the number of legs.
            if (input.hasNextInt()) {
                int numLegs = input.nextInt();
                input.nextLine();
                // Check if the number of legs is valid.
                if (numLegs <= 0) {
                    // print an error message and return early to avoid adding legs.
                    System.out.printf("In the file, trip number %d has no legs.%n", tripNumber);
                    return;
                }

                // Loop through the number of legs and add them to the legs array list.
                for (int i = 0; i < numLegs; i++) {
                    TripLeg leg = new TripLeg();
                    leg.inputData(input);
                    legs.add(leg);
                }
                // If there's no integer for the number of legs, print an error message.
            } else {
                // Thrown an exception to be caught in the catch block.
                throw new NoSuchElementException("Missing trip number " + tripNumber + ", legs count for a trip.");
            }

            // Catch the exception thrown when the legs count is missing.
        } catch (NoSuchElementException e) {
            // catch the above exception and print an error message.
            System.out.println("Input data error for trip, missing data: " + e);

            // catch any other exceptions that may occur.
        } catch (Exception e) {
            System.out.println("General input data error: " + e);
        }
    }


    // Method to write data to a file used in option 10 of the main menu to save the data to a file.
    @Override
    public void outputData(Formatter format) {
        String result = String.format("%d, %d, %s, %s %n%d", tripNumber, License, rego, tripDate, legs.size());
        //for each loop iterates the array list and returns a trip leg
        format.format("%s\n", result);
        for (TripLeg trips : legs) {
            trips.outputData(format);
        }

    }

    // Method to return a string representation of the trip object.
    @Override
    public String toString() {
        String result = String.format("Trip number: %d, license: %d, Rego: %s, Trip date: %s%n", tripNumber, License, rego, tripDate);
        //for each loop iterates the array list and returns a trip leg
        for (TripLeg trips : legs) {
            result += trips;
        }
        //System.out.println();
        return result;

    }

} // end of Trip class


// IAW the assignment spec, the TripLeg class needed to be in the same file as the Trip class.
class TripLeg implements MyFileIO {

    // ====================================== Instance variables ==============================
    private int legNumber;
    private String departure;
    private String destination;


    // ====================================== Constructor ======================================

    // Default constructor
    public TripLeg() {
        this.legNumber = 0;
        this.departure = "";
        this.destination = "";
    }

    // Constructor with parameters
    public TripLeg(int legNumber, String departure, String destination) {
        this.legNumber = legNumber;
        this.departure = departure;
        this.destination = destination;
    }

    // ====================================== implementation of MyFileIO interface ==============================

    // Method to read data from a file and store it in the trip leg object.
    @Override
    public void inputData(Scanner input) {
        try {
            this.legNumber = input.nextInt();
            this.departure = input.next();
            this.destination = input.next();
        } catch (InputMismatchException e) {
            System.out.println("Wrong input type. " + e);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    // Method to write data to a file used in option 10 of the main menu to save the data to a file.
    @Override
    public void outputData(Formatter output) {
        output.format("%d, %s, %s%n", this.legNumber, this.departure, this.destination);

    }

    // Method to return a string representation of the trip leg object.
    @Override
    public String toString() {
        return String.format("Leg number: %d, Departure: %s, Destination: %s%n", this.legNumber, this.departure, this.destination);
    }

    // ====================================== getters and setters ==============================
    public int getLegNumber() {
        return legNumber;
    }

    public void setLegNumber(int i) {
        this.legNumber = i;
    }

    public void setDeparture(String aDefault) {
        this.departure = aDefault;
    }

    public void setDestination(String aDefault) {
        this.destination = aDefault;
    }

} // end of TripLeg class

