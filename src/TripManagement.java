/*------------------------------------------------------
My name: Luke Moorhouse
My student number: 7603599
My course code: CSIT213
My email address: lm678@uowmail.edu.au
Assignment number: 2
-------------------------------------------------------*/

import java.util.ArrayList;
import java.util.Scanner;

public class TripManagement {


    private ArrayList<Employee> employees;
    private  ArrayList<Truck> trucks;
    private  ArrayList<Trip> trips;
    private Scanner sc = new Scanner(System.in);
    private static TripManagement tripMan;
    private int tNum;
    private int eNumb;
    private String rego;




    public TripManagement() {
        this.employees  = new ArrayList<Employee>();
        this.trucks = new ArrayList<Truck>();
        this.trips = new ArrayList<Trip>();
        this.tNum = 0;
        this.eNumb = 0;
        this.rego = "";
    }


    //Diver method
    public static void main(String[] args) {
        tripMan = new TripManagement();
        tripMan.cycle();
    }


    public void menu(){
        System.out.print(
                """
                1. Display all employees.
                2. Display all trucks.
                3. Display all trips.
                4. Find an employee.
                5. Find a truck.
                6. Find a trip.
                7. Add a new employee.
                8. Add a new truck.
                9. Add a new trip.
                10. Save all data into files.
                0. Exit.
                """
        );

    }

    //the menu that loops until the user inputs Zero
    public void cycle() {
        int choice;

        do{
            menu();
            System.out.print("Input a choice (0-10): ");
            choice = sc.nextInt();
            switch(choice) {

                case 1:
                /*    .menu1Emps();
                    sysMan.menu1Vechs();
                    sysMan.menu1Trips();
                    break;
*/
                case 2:
                   /* sysMan.menu2();
                    break;
*/

                case 3:
                   /* sysMan.menu3();
                    break;*/



                case 4:
                    /*sysMan.menu4();
                    break;*/


                case 5:
                  /*  sysMan.menu5();
                    break;*/


                case 6:
                   /* sysMan.menu6();
                    break;*/


                case 7:
                   /* sysMan.menu7();
                    break;
*/

                case 8:
                    /*sysMan.menu8();
                    break;

*/
                case 9:
                    /*sysMan.menu9();
                    break;*/


                case 10:
                    /*sysMan.menu9();
                    break;*/


                case 0:
                    System.out.println("Bye-bye");
                    break;


                default:
                    System.out.println("Input 0-10 for the selections.");
                    break;
            }

        }while(choice !=0);
    }













}// end of class