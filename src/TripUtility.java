import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
            // remove the last line break
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



}
