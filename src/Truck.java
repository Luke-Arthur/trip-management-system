import java.util.Formatter;
import java.util.Scanner;

public class Truck implements MyFileIO {

    private String rego;
    private double capacity;
    private double weight;
    private String status;


    public Truck() {
        this.rego = "";
        this.capacity = 0.0;
        this.weight = 0.0;
        this.status = "";
    }

    public Truck(String rego, double capacity, double weight, String status) {
        this.rego = rego;
        this.capacity = capacity;
        this.weight = weight;
        this.status = status;
    }


    @Override
    public void inputData(Scanner scan) {

    }

    @Override
    public void outputData(Formatter pw) {

    }
}
