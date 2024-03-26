import java.util.Formatter;
import java.util.Scanner;

public class Driver extends Employee {

    private int license;
    private String status;
    private String employeeType = "Driver";


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
        employeeType = "D";
        format.format("%s, ", employeeType);
        super.outputData(format);
        format.format("%d, %s%n", this.license, this.status);
    }
    // TODO: make the Driver and admin toString methods show a different message "driver" or "admin" for the type of employee


    @Override
    public String toString() {
        String status = "Status: ";
        String license = "License: ";
        return String.format("%s %s, %s%d, %s%s", employeeType, super.toString(), license, this.license, status, this.status);
    }


}
