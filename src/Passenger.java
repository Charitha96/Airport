/**
Passenger. This class will contain the properties of a passenger relevant to our simulation.
Fields - firstName:String, surname:String, secondsInQueue:int
Methods - getters and setters for each field.
 */

/**
 *
 * @author Charitha
 */
public class Passenger {

	//Declaring instance variables
	static String firstName;
	private String surName;
	private int secondsInQueue;
	
	//Setting up getters and setters
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSurName() {
		return surName;
	}
	
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	public int getSecondsInQueue() {
		return secondsInQueue;
	}
	
	public void setSecondsInQueue(int secondsInQueue) {
		this.secondsInQueue = secondsInQueue;
	}
	
	
}