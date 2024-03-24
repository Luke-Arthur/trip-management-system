import java.util.Formatter;
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
    public void inputData(Scanner scan) {
        System.out.println("Enter leg number: ");
        this.legNumber = scan.nextInt();
        System.out.println("Enter departure: ");
        this.departure = scan.next();
        System.out.println("Enter destination: ");
        this.destination = scan.next();
    }

    @Override
    public void outputData(Formatter output) {
        output.format("%d %s %s", this.legNumber, this.departure, this.destination);

    }
}
