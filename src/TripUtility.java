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


/*
* TripUtility class is used to load, print, find, add and write trip data.
* It also contains a method to check if a trip leg already exists.
* It is used as a handler for the Trip class and is used to manipulate the data in the Trip class.
* The reason this class is separate from the Trip class is to separate the data manipulation from the data itself.
* This is to ensure that the Trip class is only responsible for storing the data and the TripUtility class is responsible for manipulating the data.
*
*/
public class TripUtility {

    // Load trip data from file
    public void loadTripData(ArrayList<Trip> trips) {
        Trip aTrip;

        String fName = "trips.txt";
        Path pathway = Paths.get(fName);
        try {
            // Check if the file exists
            if(Files.exists(pathway)) {
                // Check if the file is a directory
                if(!Files.isDirectory(pathway)) {
                    Scanner scan = new Scanner(pathway);
                    // use this delimiter to read the file line by line
                    scan.useDelimiter(", |\\r\\n|\\n");
                    // read the file line by line
                    while(scan.hasNext()) {
                        aTrip = new Trip();
                        aTrip.inputData(scan);
                        // Ensure the trip has at least one leg before adding
                        if (!aTrip.getLegs().isEmpty()) {
                            trips.add(aTrip);
                  /*    else set a default trip with one leg and add it to the list. This is a fail-safe to ensure the program does not crash.
                        This is because the program will crash if a trip is added with no legs. A trip must have at least one leg. If the trip has no legs, it is invalid.
                        If a trip doesn't have a leg, the trip is still a valid trip. It will be auto assigned a default leg and the value of the leg will be "Default".
                        This is to ensure when the program reads the file, it doesn't crash if a trip has no legs. It also ensures that the program doesn't crash if a trip has no legs.
                         - a trip must have at least one leg. A default Destination and Departure will be assigned to the leg and can be changed by the user if we update the program to allow this.
                         - if a trip has no legs, it is invalid. the simple solution is to auto assign a default leg to the trip.
                         - Considering a trip isn't a trip without at least one leg. We needed to work out how to handle a trip with no legs if one was found in the file.
                         - I have already handled this happening in option 9 where we add a trip. User input is validated to ensure a trip has at least one leg.
                        */

                        } else {
                            System.out.println("Auto assigned a default trip.");
                            TripLeg defaultLeg = new TripLeg();
                            defaultLeg.setLegNumber(1);
                            defaultLeg.setDeparture("Default");
                            defaultLeg.setDestination("Default");
                            aTrip.getLegs().add(defaultLeg);
                            trips.add(aTrip);
                        }
                    }
                    scan.close();
                }
                else
                    System.out.printf("File %s does not exist", pathway);

            }
        }
        // catch any IO exceptions
        catch (IOException errorCatch) {
            System.out.println("IO exception error" + errorCatch);
        }
    }

    // Print trip data
    public void printTripData(ArrayList<Trip> trips) {
        int i = 0;
        // loop through the trips and print them
        for (Trip trip : trips) {
            System.out.print(trip);
            i++;
            // removing the last line break
            if (i < trips.size()) {
                System.out.println();
            }
        }
    }

    // Find trip data by trip number
    public void findTrip(ArrayList<Trip> trips, int tripNumber) {
        // loop through the trips and find the trip by trip number
        for(Trip trip : trips) {
            if(trip.getTripNumber()==tripNumber) {
               // System.out.printf("Trip %s exists", tripNumber);
                System.out.print(trip);
                return;
            }
        }
        System.out.printf("Trip %s does not exist\n", tripNumber);
    }

    // Add a trip to the list of trips
    public void addTrip(Scanner sc, ArrayList<Trip> trips, int tNum, Validation validation) {
        // loop through the trips and check if the trip number already exists
        for (Trip trip : trips) {
            if (trip.getTripNumber()==tNum) {
                System.out.printf("Trip %s already exists\n", tNum);
                return;
            }
        }
        // try to add a trip to the list of trips and catch any exceptions
        try {
        ArrayList<TripLeg> trplg = new ArrayList<>();
        int license = validation.getIntInput(sc, "License: ");
        sc.nextLine();
        System.out.print("Rego: ");
        String rego = validation.getMixedStringInput(sc, "Rego: ");

        String tripDate = validation.readDate(sc, "Trip Date (dd-mm-yyyy): ");
        int numLegs = validation.getIntInput(sc, "Total legs: ");
        sc.nextLine();
            // Ensure the trip has at least one leg
            if (numLegs <= 0) {
                throw new IllegalArgumentException("Invalid number of legs: Trip must have at least one leg.");
            }
        // loop through the number of legs and add them to the trip
        for (int i = 0; i < numLegs; i++) {
            int legNumber = validation.getIntInput(sc, "Leg Number: ");
            int legidx = tripLegExists(trplg, legNumber);
            // Ensure the leg number doesn't already exist
            while (legidx != -1) {
                legNumber = validation.getIntInput(sc, "Leg Number: ");
                legidx = tripLegExists(trplg, legNumber);
            }
            sc.nextLine();
            System.out.print("Departure: ");
            String departure = validation.getJustStringInput(sc, "Departure: ", "Invalid input. Please enter a valid departure.");
            departure = validation.capitaliseFirstLetter(departure);
            System.out.print("Destination: ");
            String destination = validation.getJustStringInput(sc, "Destination: ", "Invalid input. Please enter a valid destination.");
            destination = validation.capitaliseFirstLetter(destination);
            // add the leg to the trip
            trplg.add(new TripLeg(legNumber, departure, destination));
        }
        // create a new trip and add it to the list of trips
        Trip newTrip = new Trip(tNum, license, rego, tripDate, trplg);
        trips.add(newTrip);

        // catch any exceptions
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    // Write trip data to file
    public void writeTripData(ArrayList<Trip> trips) {
        String fName = "trips.txt";
        // try to write the trip data to the file and catch any exceptions
        try {
            // create a new formatter and write the trip data to the file
            Formatter output = new Formatter(fName);
            // loop through the trips and write them to the file
            for (Trip trip : trips) {
                trip.outputData(output);
            }
            // close the file
            output.close();
        }
        // catch any exceptions
        catch (IOException errorCatch) {
            System.out.println("IO exception error");
        }
    }

    // Check if a trip leg already exists in the list of trip legs
    public int tripLegExists(ArrayList<TripLeg> tripLegs, int legNumber) {
        // loop through the trip legs and check if the leg number already exists
        for (TripLeg tripLeg : tripLegs) {
            // if the leg number already exists, return the index of the trip leg
            if (tripLeg.getLegNumber() == legNumber) {
                System.out.printf("Leg %d already exists.%n", legNumber);
                return tripLegs.indexOf(tripLeg);
            }
        }
        // else return -1 if the leg number doesn't exist
        return -1;
    }

}//end of class
