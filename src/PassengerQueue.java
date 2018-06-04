/**
PassengerQueue. This class will represent the queue at the boarding gate.
Fields queueArray: Array of Passenger, first:int, last:int, maxSize:int
Methods: //add(), //remove(), getMaxSize(), isEmpty(), isFull().

 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author Charitha
 */

public class PassengerQueue {
    static int die1, die2, die3, sum, count = 0; 
    static int count1 = 0;
    static int sum1 = 0;
    
    //Creating the Passenger Queue 
    Passenger []qitems = new Passenger[21];
    //setting the pointers to zero.
    int first = 0, last = 0, maxSize = 0;
    
    //creating the Queue by setting the name of the Queue in to null
    void initialiseQ(){
    	
    	for(int i=0; i<21; i++){
    		//Setting the passenger names in to null
    		qitems[i]=new Passenger();
                qitems[i].setSecondsInQueue(i);
    		qitems[i].setFirstName("null");
                qitems[i].setSurName("null");
                
    	}
    }
    
    //adding the passengers in to seat numbers and giving the validation
    void add() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter Seat Number : ");
        if(input.hasNextInt()){
        qitems[last].setSecondsInQueue(input.nextInt());
        }else{
            //validation for inputing letters 
            System.out.println("You must enter an number");
            add();
        }
        
        input.nextLine();
        //setting the first name for the added passenger
        System.out.println("Enter First Name of the Passenger : ");
        qitems[last].setFirstName( input.next());
        //setting the last name for the added passenger
        System.out.println("Enter Surname of the Passenger : ");
        qitems[last].setSurName( input.next());
        
        last++;
        count1++;
        System.out.println("");
        
        
        System.out.println("Passenger Data successfully added to the system.");
       // System.out.println(qitems[last].getFirstName());
    }

    //delete the passenger from the queue
    void remove() {
        //check whether the seats are empty or not.
        if (last > first) {
            System.out.println("Removed the Passenger : Mr." + qitems[first].getFirstName()+" "+qitems[first].getSurName()+ " from Seat Number "+qitems[first].getSecondsInQueue());
            first++;
        } else {
            System.out.println("All Seats are Empty. ");
        }
    }
    
    //Display the passengers in he queue
    void displayqueue() {
        System.out.println("Display the passengers : ");
        //Displaying the passengers who are in the queue
        for (int i = first; i < last; i++) {
            //check whether the seats are empty or not
            if(qitems[i].getFirstName().equals("null") ){
            System.out.println("All Seats are Empty. "); 
            }else{
            System.out.print("Mr. " + qitems[i].getFirstName()+" "+qitems[i].getSurName()+" has booked Seat Number "+qitems[i].getSecondsInQueue() );
            System.out.println("");
            }
        }
        
        System.out.println("");
    }
    
    //Checking the plane is empty or not
    void isEmpty(){
        
        for (int i = first; i < 21; i++ ){			
                    
                    if (qitems[i].getFirstName().equals("null")){
                        System.out.println("The Seat No " + i + " is empty");
                    //}else{
                      //  System.out.println(" Plane is not Empty");
                    }   
		}
        
    }
    
    //getting the size of array
    void getMaxSize(){
        
        for(int i=1; i<21; i++){
            maxSize = i;
        }
        System.out.println("Max Size of the plane is "+ maxSize);
    }
    
    //when 20 customers get in the count will count and do the customers full command.
    void isFull(){
        if(count1==20){
            System.out.println("All Seats are Full.");
        }else{
            System.out.println("Plane is not Full.");
        }
    }
    
    //save the data in to the computer using printwriter objects
    void save() {
        Scanner sc = new Scanner(System.in);    
        System.out.println("Enter output file name ");
		String outputfilename=sc.next();
                        //printwritr is used to save the details in to the computer
			PrintWriter output;
			try {
				output = new PrintWriter(outputfilename);
				for (int i = first; i < last; i++) {
                                    //output.println(qitems[i].getFirstName());
                                    if(qitems[i].getFirstName()=="null"){
                                        output.println("No Data in the program ");
                                    }else{
                                     //give the output in to the program.
                                     output.println(qitems[i].getFirstName()+" " + qitems[i].getSurName()+" "+ qitems[i].getSecondsInQueue());
                                    }
				}
                                //closing the printwriter object
				output.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

                System.out.println("");
    }
    
    //Load the file in the computer
    void load() {
        System.out.println("Type the file name you want to import : ");
                //using a scanner to get the input from the user
		Scanner sc = new Scanner(System.in);
		String loadfile = sc.next();
	
		File inputfile = new File(loadfile);
		//loding the file from the computer
		try{
			Scanner loadfrom = new Scanner(inputfile);
			for(int i=1; i < 21; i++){
			String file = loadfrom.next();
			System.out.println(file);
			
                        }
                        //Scanner closed
                        loadfrom.close();
		} catch (FileNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
                System.out.println(" ");
    }
    //Run command is created.
    void run() throws IOException {
        System.out.println("");
         try{
            FileReader fr = new FileReader("passengers.dat");
            //file imported using bufferReader
            BufferedReader br = new BufferedReader(fr);
      
            //error comes; do the IO Exeption to get rid of the error
            String myfile = br.readLine();

            while(myfile!= null ){
                myfile= br.readLine();
                System.out.println(myfile+ " Delay is "+ count );
          
            }
            //close the bufferReader cuz if not it will go over and over again
             br.close();
        } 
        catch (FileNotFoundException ex) {
        System.out.println("Error in Buffer Reader.");
       }
   
    }
    
    public static void main(String[] args) {
       
        //Number of times six sided dice.
        int numberOfRolls = 3;

        //Display the result of adding the three dice
        for (int i = 0; i < numberOfRolls; i++) {
            die1 = D6();
            die2 = D6();
            die3 = D6();
            
            sum = die1+die2+die3 ;
            
            //System.out.println("Hello "+delayTime);
        }
        System.out.println("die 1 :" + die1 +" die 2: " + die2+ " die 3: " + die3+ " Sum :"  + sum);
        
       //The sum of the three 6 sided dice rolls 
        int targetValue = 18; 
        int roll; 
        
        //How many times we have rolled 
        do {
            roll = nD6(3);
            
            //System.out.println("Rolled " + roll); 
            count++;
        } while (roll != targetValue);
        System.out.println("Number of throws before die returns " + targetValue + " is: " + count);
        System.out.println(count);
        
    }
    
    //randomly generate numbers between 1 to 6  
    public static int D6() {
        return (int) (1 + 6 * Math.random());
    }

    //Calculate the sum of n six sided dice throws
    public static int nD6(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + D6(); 
        }
        return sum;
        
    }
}