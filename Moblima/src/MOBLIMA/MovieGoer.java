package MOBLIMA;
import java.util.*;
import java.io.*;

/**
  Represents a movie goer/customer and relevant information for booking purposes
  A customer can have multiple bookings 
  @version 1.0
  @since 2022-11-01
 */
public class MovieGoer { 
	/**
	 * Email address of customer
	 */
	private String emailCustomer; 
	/**
	 * Name of customer
	 */
	private String nameCustomer; 
	/**
	 * Mobile number of customer
	 */
    	private int mobileNumber;
    	/**
	 * List of bookings made by a customer
	 */
    	public ArrayList<BookingTicket> custBookings = new ArrayList<BookingTicket>();
	
	/**
	 * Constructor for the class:
	 * Creates a new customer with relevant information
 	 * @param nameCustomer This customer's name
 	 * @param mobileNumber This customer's mobile number
	 * @param custBookings This customer's bookings 
	 */
   	public MovieGoer() {};
    	public MovieGoer(String nameCustomer, int mobileNumber, String email, ArrayList<BookingTicket> custBookings){ 
        	this.nameCustomer = nameCustomer; 
        	this.mobileNumber = mobileNumber; 
        	this.custBookings = custBookings; 
   	}
	
	/**
	 * Sets name of the customer
 	 * @param nameCustomer This customer's name
	 */
	public void setNameCustomer(String nameCustomer) { 
		this.nameCustomer = nameCustomer;
	}
	
	/**
	 * Sets mobile number of the customer
 	 * @param mobileNumber This customer's mobile number 
	 */
	public void setMobileNumber(int mobileNumber) { 
		this.mobileNumber = mobileNumber;
	}
	
	/**
	 * Sets email address of the customer
 	 * @param emailCustomer This customer's email address
	 */
	public void setEmailCustomer(String emailCustomer) { 
		this.emailCustomer = emailCustomer;
	}
	
	/**
	 * Gets name of the customer
 	 * @return nameCustomer This customer's name 
	 */
	public String getNameCustomer() { 
		return nameCustomer;
	}
	
	/**
	 * Gets mobile number of the customer
 	 * @return mobileNumber This customer's mobile number 
	 */
	public int getMobileNumber() { 
		return mobileNumber;
	}
	
	/**
	 * Gets email address of the customer
 	 * @return emailCustomer This customer's emai address 
	 */
	public String getEmailCustomer() { 
		return emailCustomer;
	}
	
	/**
	 * Sets new booking for the customer
	 * Necessary to check if booking already exists in list of bookings made by the customer, if not proceed to add the booking
 	 * @param BookingTicket booking This customer's new booking
	 */
	public void setBooking(BookingTicket booking) { 
		if(!custBookings.contains(booking)) {
		custBookings.add(booking);}
	}
	
	/**
	 * Gets list of bookings made by the customer
 	 * @return custBookings This customer's bookings 
	 */
	public ArrayList<BookingTicket> getCustBookings() { 
		return custBookings;
	}

}
