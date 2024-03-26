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


    public void addTrip(ArrayList<Trip> trips, int tNum) {

        for (Trip trip : trips) {
            if (trip.getTripNumber()==tNum) {
                System.out.printf("Trip %s already exists\n", tNum);
                return;
            }
        }

        ArrayList<TripLeg> trplg = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("License: ");
        int license = sc.nextInt();
        sc.nextLine();
        System.out.print("Rego: ");
        String rego = sc.nextLine();
        System.out.print("Trip Date (dd-mm-yyyy): ");
        String tripDate = sc.nextLine();
        System.out.print("Total legs: ");
        int numLegs = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numLegs; i++) {
            TripLeg leg = new TripLeg();
            System.out.print("Leg Number: ");
            int legNumber = sc.nextInt();
            sc.nextLine();
            System.out.print("Departure: ");
            String departure = sc.next();
            System.out.print("Destination: ");
            String destination = sc.next();
            trplg.add(new TripLeg(legNumber, departure, destination));
        }
        Trip newTrip = new Trip(tNum, license, rego, tripDate, trplg);
        trips.add(newTrip);
    }

    public void writeTripData(ArrayList<Trip> trips) {
        String fName = "trips.txt";
        Path pathway = Paths.get(fName);
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

}//end of class
