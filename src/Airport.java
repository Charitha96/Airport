/**
Airport: This is the main class that will drive the program.
Fields: passengers: Array of Passenger, queue1: PassengerQueue
Methods: main() and the other methods you implement from the menu
 */

/**
 *
 * @author Charitha
 */


import java.io.IOException;
import java.util.*;

public class Airport {
    
    //Creatd the PassengerQueue for the program.
    static PassengerQueue qu = new PassengerQueue();  
        
    /**
     * @param args the command line arguments
    */
    
    public static void main(String[] args) throws IOException {
        //initilising the queue to get inputs 
    	qu.initialiseQ();
        
        Scanner input = new Scanner(System.in);
        String menu;
        do {
                System.out.println("");
		System.out.println("                                                 Airport Program ");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Menu");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Press A to  Add a passenger to the passenger PassengerQueue.");
		System.out.println("Press V to  View the passenger Queue.");
		System.out.println("Press D to  Delete passenger from passenger Queue.");
		System.out.println("Press S to  Store passengerArray data into a plain text file.");
		System.out.println("Press L to Load passenger data back from the file into the passenger Array. ");
		System.out.println("Press R to  Run the simulation and produce report");
		System.out.println("Press Q to Exit the program");
		System.out.println("");
		System.out.println("Enter a key to proceed : ");
		
                //getting the user input
		 menu = input.next().toLowerCase();
            switch (menu) {
                case "a":
                    qu.add();
                    break;
                    
                case "v":
                    qu.displayqueue();
                    break;
                    
                case "d":
                    qu.remove();
                    break;
                    
                case "s":
                   qu.save();
                   break;
                   
                case "l":
                    qu.load();
                    break;
                    
                case "r":
                    qu.run();
                    break;
                
                case "e":
                    qu.isEmpty();
                    break;
                    
                case "m":
                    qu.getMaxSize();
                    break;
                    
                case "f":
                    qu.isFull();
                    break;
                    
                case "q":
                    System.out.println("System exit.");
                    System.exit(0);
                
                // restart the program if the user inputs any other letter.
                default:
                    System.out.println();
                    System.err.println("Please select the correct letter.");
                    System.out.println();
            }
             //System.out.println("Wrong letter.");
        } while (menu != "q");
       
        System.exit(0);
    }
    
    
}