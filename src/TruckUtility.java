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

public class TruckUtility {

    // ======================================== Instance methods ========================================
    public void loadTruckData(ArrayList<Truck> trucks) {
        Truck aTruck;
        String fName = "trucks.txt";
        Path pathway = Paths.get(fName);
        try {
            if(Files.exists(pathway)) {

                // Check if the file is a directory or not
                if(!Files.isDirectory(pathway)) {
                    Scanner scan = new Scanner(pathway);
                    // read from the file, using the comma, whitespace, and newline as the delimiter
                    scan.useDelimiter(", |\\r\\n|\\n");
                    // while the file has more data to read in keep reading in the data
                    while(scan.hasNext()) {
                        aTruck = new Truck();
                        aTruck.inputData(scan);
                        trucks.add(aTruck);
                    }
                    scan.close();
                }
                // if it's not a directory then print out the file does not exist
                else
                    System.out.printf("File %s does not exist", pathway);
            }
        }
        // catch any IO exceptions that may occur
        catch (IOException errorCatch) {
            System.out.println("IO exception error: " + errorCatch);
        }
    }


    // this method prints out the truck data in the array list. It uses the toString method in the Truck class
    public void printTruckData(ArrayList<Truck> trucks) {
        for(Truck truck : trucks) {
            System.out.println(truck);
        }
    }

    // this method finds a truck in the array list by the registration number and prints out the truck data if it exists
    public void findTruck(ArrayList<Truck> trucks, String regoNumber) {
        // loop through the array list of trucks
        for(Truck truck : trucks) {
            // if the truck registration number is equal to the registration number entered by the user then print out the truck data
            if(truck.getRego().equals(regoNumber)) {
                System.out.printf("Truck %s exists\n", regoNumber);
                System.out.println(truck);
                return;
            }
        }
        // else print out that the truck does not exist
        System.out.printf("Truck %s does not exist\n", regoNumber);
    }

    // this method adds a truck to the array list of trucks if the truck does not already exist
    public void addTruck(Scanner sc, ArrayList<Truck> trucks, String reo, Validation validation) {
        // loop through the array list of trucks
        for (Truck truck : trucks) {
            // if the truck registration number is equal to the registration number entered by the user then print out that the truck already exists
            if (truck.getRego().equals(reo)) {
                System.out.printf("Truck %s already exists\n", reo);
                // return to the main menu
                return;
            }
        }
        // prompts for the user to enter the capacity, weight and status of the truck
        String capacityPrompt = "Capacity: ";
        double capacity = validation.getDoubleInput(sc, capacityPrompt);
        String weightPrompt = "Weight: ";
        double weight = validation.getDoubleInput(sc, weightPrompt);
        sc.nextLine();
        String statusPrompt = "Status: ";
        System.out.print(statusPrompt);
        String status = validation.getJustStringInput(sc, statusPrompt, "Invalid input. Please enter a valid status.");
        status = status.toUpperCase();
        Truck newTruck = new Truck(reo, capacity, weight, status);
        // add the new truck to the array list of trucks
        trucks.add(newTruck);
    }

    // This method writes the truck data to the trucks.txt file using the Formatter class
    public void writeTruckData(ArrayList<Truck> trucks) {
        String fName = "trucks.txt";
        // try to write to the file
        try {
            // create a new formatter object
            Formatter output = new Formatter(fName);
            // loop through the array list of trucks
            for (Truck truck : trucks) {
                truck.outputData(output);
            }
            output.close();
        }
        catch (IOException errorCatch) {
            System.out.println("IO exception error");
        }
    }

}//end of class
