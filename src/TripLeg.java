/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TripLeg implements MyFileIO{

    private int legNumber;
    private String departure;
    private String destination;

    public TripLeg() {
        this.legNumber = 0;
        this.departure = "";
        this.destination = "";
    }

    public TripLeg(int legNumber, String departure, String destination) {
        this.legNumber = legNumber;
        this.departure = departure;
        this.destination = destination;
    }

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

    @Override
    public void outputData(Formatter output) {
        output.format("%d, %s, %s%n", this.legNumber, this.departure, this.destination);

    }

    @Override
    public String toString() {
        return String.format("Leg number: %d, Departure: %s, Destination: %s%n", this.legNumber, this.departure, this.destination);
    }

    public int getLegNumber() {
        return legNumber;
    }
}
