import java.util.Formatter;
import java.util.Scanner;

public class Admin extends Employee{

    private String position;

    public Admin() {
        super();
        this.position = "";
    }

    public Admin(int eNumber, String name, String dob, String address, String position) {
        super(eNumber, name, dob, address);
        this.position = position;
    }

    @Override
    public void inputData(Scanner input) {
        try {
            super.inputData(input);
            this.position = input.next();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            input.nextLine();
        }
    }

    @Override
    public void outputData(Formatter format) {
        super.outputData(format);
        format.format("%s%n", this.position);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Position: %s%n", this.position);
    }


}
