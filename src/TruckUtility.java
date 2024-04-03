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

    public void loadTruckData(ArrayList<Truck> trucks) {
        Truck aTruck;

        String fName = "trucks.txt";
        Path pathway = Paths.get(fName);
        try {
            if(Files.exists(pathway)) {

                if(!Files.isDirectory(pathway)) { //Not a directory, read data
                    Scanner scan = new Scanner(pathway);
                    scan.useDelimiter(", |\\r\\n|\\n");
                    while(scan.hasNext()) {
                        aTruck = new Truck();
                        aTruck.inputData(scan);
                        trucks.add(aTruck);
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



    public void printTruckData(ArrayList<Truck> trucks) {
        for(Truck truck : trucks) {
            System.out.println(truck);
        }
    }

    public void findTruck(ArrayList<Truck> trucks, String regoNumber) {
        for(Truck truck : trucks) {
            if(truck.getRego().equals(regoNumber)) {
                System.out.printf("Truck %s exists\n", regoNumber);
                System.out.println(truck);
                return;
            }
        }
        System.out.printf("Truck %s does not exist\n", regoNumber);
    }


    public void addTruck(ArrayList<Truck> trucks, String reo, Validation validation) {
        for (Truck truck : trucks) {
            if (truck.getRego().equals(reo)) {
                System.out.printf("Truck %s already exists\n", reo);
                return;
            }
        }

        Scanner sc = new Scanner(System.in);

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

        trucks.add(newTruck);

    }

    public void writeTruckData(ArrayList<Truck> trucks) {
        String fName = "trucks.txt";
        try {
            Formatter output = new Formatter(fName);
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
