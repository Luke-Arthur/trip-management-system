import java.util.ArrayList;
import java.util.Scanner;

public class MenuCycle {

    public void menu() {
        System.out.println("1. Add employee");
        System.out.println("2. Add vehicle");
        System.out.println("3. Add trip");
        System.out.println("4. Assign vehicle to trip");
        System.out.println("5. Display all employees");
        System.out.println("6. Display all vehicles");
        System.out.println("7. Display all trips");
        System.out.println("8. Display all trips for a specific employee");
        System.out.println("9. Display all trips for a specific vehicle");
        System.out.println("10. Display all trips for a specific date");
        System.out.println("0. Exit");
    }

    //the menu that loops until the user inputs Zero
    public void cycle(Scanner sc, LoadEmplyee loadEmp,ArrayList<Employee> employees) {
        int choice;

        do{
            menu();
            System.out.print("Input a choice (0-10): ");
            choice = sc.nextInt();
            switch(choice) {

                case 1:
                    loadEmp.printEmployeeData(employees);
                    break;

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



}
