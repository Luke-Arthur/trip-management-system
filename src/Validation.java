/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
* The Validation class is used to validate user input. It contains methods to validate integer, string, and double inputs.
* The class also contains a method to capitalise the first letter of each word in a string.
* The class is used in various classes to validate user input.
* There is an employee type input method that validates the input for the employee type. It only accepts "A" or "D".
* The class also contains a method to read a date in the format DD/MM/YYYY. The method loops until a valid date is entered.
* The class also contains a method to validate the input for the exit menu. It only accepts integers greater than or equal to 0.
*/
public class Validation {

// ====================================== Class Methods ======================================

    // Method to validate integer input
    public int getIntInput(Scanner scan, String prompt) {
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

    // Method to validate a mixed number and string input
    public String getMixedStringInput(Scanner scan, String prompt) {

        // Loop until a valid string is entered, rejects special characters or empty strings
        String input;
        input = scan.nextLine();
        input = input.toUpperCase();

        // Loop indefinitely until a break statement is executed
        while (true) {
            // Check if the input matches the pattern for a mixed number and string input and is not empty
            if (input.matches("^[a-zA-Z0-9\\s]*$") && !input.isEmpty()) {
                break;
            } else {
                // Display an error message and prompt the user to re-enter the input
                System.out.println("Invalid input. Please enter a valid truck registration number.");
                System.out.print(prompt);
                input = scan.nextLine().toUpperCase();
            }
        }
        // Return the validated input
        return input;
    }


    // Method to capitalise the first letter of each word in a string
    public String capitaliseFirstLetter(String input) {

        // Check if the input is null or empty
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Split the input string into words
        String[] words = input.split("\\s+");
        StringBuilder capitalisedWords = new StringBuilder();

        // Loop through each word in the input string
        for (String word : words) {
            // Capitalise the first letter of each word and add it to the StringBuilder
            String capitalisedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            capitalisedWords.append(capitalisedWord).append(" ");
        }

        // Trim the trailing space at the end
        return capitalisedWords.toString().trim();
    }

    // Method to validate a string input
    public String getJustStringInput(Scanner scan, String prompt, String errorMessage) {

        String input;

        //An unconventional Loop to test if it works - seems it does - until a valid string is entered, rejects special characters or empty strings
        for (input = scan.nextLine(); !input.matches("^[a-zA-Z\\s]*$") || input.isEmpty(); input = scan.nextLine()) {
            System.out.println(errorMessage);
            System.out.print(prompt);
        }

        return input;
    }


    // Method to validate the input for the employee type (A or D)
    public String employeeTypeInput(Scanner scan, String prompt, String errorMessage) {

        String input;

        // Convert input to uppercase right after reading it, then check if it matches "A" or "D"
        for (input = scan.nextLine().toUpperCase(); !input.matches("^[AD]$"); input = scan.nextLine().toUpperCase()) {
            System.out.println(errorMessage);
            System.out.print(prompt);
        }

        return input;
    }


    // Method to read a date in the format DD/MM/YYYY and loop until a valid date is entered
    public String readDate(Scanner scan, String prompt) {
        // Create a SimpleDateFormat object with the date format "dd-MM-yyyy"
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        // Loop until a valid date is entered
        while (true) {
            try {
                System.out.print(prompt);
                String dateStr = scan.next();
                Date date = dateFormat.parse(dateStr);
                return dateFormat.format(date);
            } catch (ParseException var6) {
                System.out.println("Please enter a date in the format DD-MM-YYYY.");
            }
        }
    }

    // Method to validate double input (non-negative)
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

    // Method to validate the input for the exit menu (non-negative integers)
    public int getExitIntInput(Scanner scan, String prompt) {
        int input1;
        // Loop until a non-negative integer is entered
        while (true) {
            System.out.print(prompt);
            // Loop while the scanner's next token is not an integer
            while (!scan.hasNextInt()) {
                scan.next();
                System.out.println("Invalid input. Please enter a number.");
                System.out.print(prompt);
            }
            // Read the integer value
            input1 = scan.nextInt();
            // Check if the value is non-negative (greater than or equal to 0)
            if (input1 >= 0) {
                // Break the loop if a non-negative integer is entered
                break;
            }
            //else print an error message
            System.out.println("Invalid input. The number must not be negative.");
        }
        return input1;
    }

}// End of Validation class
