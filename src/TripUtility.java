import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class TripUtility {

    public void loadTripData(ArrayList<Trip> trips) {
        Trip aTrip;

        String fName = "trips.txt";
        Path pathway = Paths.get(fName);
        try {
            if(Files.exists(pathway)) {

                if(!Files.isDirectory(pathway)) { //Not a directory, read data
                    Scanner scan = new Scanner(pathway);
                    scan.useDelimiter(", |\\r\\n|\\n");
                    while(scan.hasNext()) {
                        aTrip = new Trip();
                        aTrip.inputData(scan);
                        trips.add(aTrip);
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


    public void printTripData(ArrayList<Trip> trips) {
        int i = 0;
        for (Trip trip : trips) {
            System.out.print(trip);
            i++;
            // removing the last line break
            if (i < trips.size()) {
                System.out.println();
            }
        }
    }

    public void findTrip(ArrayList<Trip> trips, int tripNumber) {
        for(Trip trip : trips) {
            if(trip.getTripNumber()==tripNumber) {
               // System.out.printf("Trip %s exists", tripNumber);
                System.out.print(trip);
                return;
            }
        }
        System.out.printf("Trip %s does not exist\n", tripNumber);
    }


    public void addTrip(ArrayList<Trip> trips, int tNum, Validation validation) {

        for (Trip trip : trips) {
            if (trip.getTripNumber()==tNum) {
                System.out.printf("Trip %s already exists\n", tNum);
                return;
            }
        }

        ArrayList<TripLeg> trplg = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int license = validation.getIntInput(sc, "License: ");
        sc.nextLine();
        System.out.print("Rego: ");
        String rego = validation.getMixedStringInput(sc, "Rego: ");

        String tripDate = validation.readDate(sc, "Trip Date (dd-mm-yyyy): ");
        int numLegs = validation.getIntInput(sc, "Total legs: ");
        sc.nextLine();
        for (int i = 0; i < numLegs; i++) {
            int legNumber = validation.getIntInput(sc, "Leg Number: ");
            int legidx = tripLegExists(trplg, legNumber);
            while (legidx != -1) {
                legNumber = validation.getIntInput(sc, "Leg Number: ");
                legidx = tripLegExists(trplg, legNumber);
            }
            sc.nextLine();
            System.out.print("Departure: ");
            String departure = validation.getJustStringInput(sc, "Departure: ", "Invalid input. Please enter a valid departure.");
            System.out.print("Destination: ");
            String destination = validation.getJustStringInput(sc, "Destination: ", "Invalid input. Please enter a valid destination.");
            trplg.add(new TripLeg(legNumber, departure, destination));
        }
        Trip newTrip = new Trip(tNum, license, rego, tripDate, trplg);
        trips.add(newTrip);
    }

    public void writeTripData(ArrayList<Trip> trips) {
        String fName = "trips.txt";
        try {
            Formatter output = new Formatter(fName);
            for (Trip trip : trips) {
                trip.outputData(output);
            }
            output.close();
        }
        catch (IOException errorCatch) {
            System.out.println("IO exception error");
        }
    }

    public int tripLegExists(ArrayList<TripLeg> tripLegs, int legNumber) {
        for (TripLeg tripLeg : tripLegs) {
            if (tripLeg.getLegNumber() == legNumber) {
                System.out.printf("Leg %d already exists.%n", legNumber);
                return tripLegs.indexOf(tripLeg);
            }
        }
        return -1;
    }


}//end of class
