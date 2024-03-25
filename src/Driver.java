import java.util.Formatter;
import java.util.Scanner;

public class Driver extends Employee {

    private int license;
    private String status;

    public Driver() {
        super();
        this.license = 0;
        this.status = "";
    }

    public Driver(int eNumber, String name, String dob, String address, int license, String status) {
        super(eNumber, name, dob, address);
        this.license = license;
        this.status = status;
    }


    @Override
    public void inputData(Scanner input) {
        try {
            super.inputData(input);
            this.license = input.nextInt();
            this.status = input.next();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            input.nextLine();
        }
    }

    @Override
    public void outputData(Formatter format) {
        super.outputData(format);
        format.format("%d, %s", this.license, this.status);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" License: %d, Status: %s%n", this.license, this.status);
    }
}
