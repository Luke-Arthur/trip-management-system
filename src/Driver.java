import java.util.Formatter;
import java.util.Scanner;

public class Driver extends Employee {

    private int license;
    private String status;
    private final String employeeType = "Driver";


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
            e.printStackTrace();
        }
    }

    @Override
    public void outputData(Formatter format) {
        super.outputData(format);
        format.format("%d, %s", this.license, this.status);
    }
    // TODO: make the Driver and admin toString methods show a different message "driver" or "admin" for the type of employee


    @Override
    public String toString() {

        return String.format("%s %s,%d,%s", employeeType, super.toString(), license, status);
    }


}
