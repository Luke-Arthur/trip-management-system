import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Validation {


    protected int getIntInput(Scanner scan, String prompt) {
        int input;
            while (true) {
                System.out.print(prompt);
                while (!scan.hasNextInt()) {
                    scan.next();
                    System.out.println("Invalid input. Please enter a number.");
                    System.out.print(prompt);
                }
                input = scan.nextInt();
                if (input > 0) {
                    break;
                }
                System.out.println("Invalid input. The number must not be negative.");
            }

        return input;
    }


    protected String getMixedStringInput(Scanner scan, String prompt) {
        //System.out.print(prompt);


        String input;
        for (input = scan.nextLine().toUpperCase(); !input.matches("^[a-zA-Z0-9\\s]*$") || input.isEmpty(); input = scan.nextLine().toUpperCase()) {
            System.out.println("Invalid input. Please enter a valid truck registration number.");
            System.out.print(prompt);
        }

        return input;
    }


    public String capitaliseFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        // Split the input string into words
        String[] words = input.split("\\s+");
        StringBuilder capitalisedWords = new StringBuilder();

        for (String word : words) {
            // Capitalise the first letter of each word and add it to the StringBuilder
            String capitalisedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            capitalisedWords.append(capitalisedWord).append(" ");
        }

        // Trim the trailing space at the end
        return capitalisedWords.toString().trim();
    }


    protected String getJustStringInput(Scanner scan, String prompt, String errorMessage) {

        String input;
        for (input = scan.nextLine(); !input.matches("^[a-zA-Z\\s]*$") || input.isEmpty(); input = scan.nextLine()) {
            System.out.println(errorMessage);
            System.out.print(prompt);
        }

        return input;
    }


    protected String employeeTypeInput(Scanner scan, String prompt, String errorMessage) {
        //System.out.print(prompt);

        String input;
        // Convert input to uppercase right after reading it, then check if it matches "A" or "D"
        for (input = scan.nextLine().toUpperCase(); !input.matches("^[AD]$"); input = scan.nextLine().toUpperCase()) {
            System.out.println(errorMessage);
            System.out.print(prompt);
        }

        return input;
    }


    protected String readDate(Scanner scan, String prompt) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        while (true) {
            try {
                System.out.print(prompt);
                String dateStr = scan.next();
                Date date = dateFormat.parse(dateStr);
                return dateFormat.format(date);
            } catch (ParseException var6) {
                System.out.println("Please enter a date in the format DD/MM/YYYY.");
            }
        }
    }


    public double getDoubleInput(Scanner sc, String capacityPrompt) {
        double input;
        // Loop until a valid double is entered
        while (true) {
            System.out.print(capacityPrompt);
            // Check if the scanner's next token is a double
            while (!sc.hasNextDouble()) {
                // Consume the invalid token to prevent an infinite loop
                sc.next();
                System.out.println("Invalid input. Please enter a positive number.");
                System.out.print(capacityPrompt);
            }
            // Read the double value
            input = sc.nextDouble();
            // Check if the value is non-negative
            if (input >= 0) {
                break; // Break the loop if a valid non-negative double is entered
            }
            System.out.println("Invalid input. The number must not be negative.");
        }
        return input;
    }


    protected int getExitIntInput(Scanner scan, String prompt) {
        int input1;
        while (true) {
            System.out.print(prompt);
            while (!scan.hasNextInt()) {
                scan.next();
                System.out.println("Invalid input. Please enter a number.");
                System.out.print(prompt);
            }
            input1 = scan.nextInt();
            if (input1 >= 0) {
                break;
            }
            System.out.println("Invalid input. The number must not be negative.");
        }
        return input1;
    }

}
