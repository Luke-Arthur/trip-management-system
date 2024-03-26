import java.util.Formatter;
import java.util.Scanner;

public class Admin extends Employee{

    private String position;
    private String employeeType = "Admin";

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
        }
    }

    @Override
    public void outputData(Formatter format) {
        employeeType = "A";
        format.format("%s, ", employeeType);
        super.outputData(format);
        format.format("%s%n", this.position);
    }

    @Override
    public String toString() {
        String position = "Position: ";
        return  String.format("%s %s, %s%s", employeeType,super.toString(), position, this.position);
    }


}
