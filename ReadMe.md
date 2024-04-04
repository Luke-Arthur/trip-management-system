# Trip Management System (TMS)

## Introduction
The Trip Management System (TMS) is a comprehensive solution designed to facilitate the management of employees, trucks, and trips for companies. Developed in Java, the system incorporates advanced concepts such as interfaces, abstraction, polymorphism, and file I/O to deliver a robust tool for organising and storing essential data. Upon initiation, TMS automatically loads existing data from text files, presenting users with an intuitive menu to navigate through various functionalities. Users can display, search, add, or modify details related to employees, trucks, and trips, ensuring a seamless operational flow. Furthermore, all changes can be saved back to text files, maintaining up-to-date records.

## Key Features
- **Data Management**: Efficiently handles data related to employees, trucks, and trips.
- **File I/O**: Automatically loads and saves data from/to text files.
- **User Interface**: Offers a user-friendly menu for easy navigation of the system's features.
- **Advanced Java Concepts**: Utilises interfaces, abstraction, polymorphism for a flexible and scalable architecture.

## System Components
- **MyFileIO Interface**: Defines essential methods for data handling.
- **Employee Superclass and Sub-classes (Admin and Driver)**: Manages employee data.
- **Truck Class**: Handles truck-related information.
- **Trip Class**: Manages trip details, including a list of TripLeg instances.
- **TripLeg Class**: Represents a segment of a trip.
- **Utility Classes**: Facilitate operations on employees, trucks, and trips.
- **Main Driver Class (TripManagement.java)**: Orchestrates the overall functionality of the TMS.

## File Structure
The source code is organised within the `src` folder, containing:

- Employee.java
- EmployeeUtility.java
- MenuCycle.java
- MyFileIO.java
- Trip.java
- TripManagement.java
- TripUtility.java
- Truck.java
- TruckUtility.java
- Validation.java

Data is stored and loaded from:

- employees.txt
- trips.txt
- trucks.txt

## Compilation and Execution
To compile and run the Trip Management System, follow these steps using the Command Line Interface (CLI):

1. Navigate to the `src` folder that contains the source code.
2. Compile the code using the Java Compiler (`javac`):
   ```bash
   javac TripManagement.java
   ```
3. Run the compiled program:
   ```bash
   java TripManagement
   ```

Ensure all associated `.java` and `.txt` files are present in the same directory to avoid compilation errors.

## Developer
- Luke Moorhouse (uow7603599)

## Date created
- Sunday, 24th March 2024

## Date completed
- Friday, 5th April 2024

## License

© 2024 Luke Moorhouse. All Rights Reserved.

This work is the property of Luke Moorhouse and the University of Wollongong. Unauthorised copying, distribution, modification, or any other misuse of this work is strictly prohibited without explicit permission from the author.



## Conclusion
The Trip Management System provides a sophisticated platform for managing crucial logistical and personnel information. Through its user-friendly interface and powerful data management capabilities, TMS stands as an essential tool for companies looking to streamline their operations.