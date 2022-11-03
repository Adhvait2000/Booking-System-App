package MOBLIMA;
import java.util.*;
import java.io.*;

public class MovieGoer { //details of movie goers i.e. our customers
	
	private String emailCustomer; //email address of customer
	
	private String nameCustomer; //name of customer
    
    private int mobileNumber; //mobile number of customers
    
    private ArrayList<BookingTicket> custBookings = new ArrayList<BookingTicket>(); //list of bookings made by a customer
    
    public MovieGoer() {};
   
    public MovieGoer(String nameCustomer, int mobileNumber, String email, ArrayList<BookingTicket> custBookings){ //constructor for the class
        this.nameCustomer = nameCustomer; //name of customer
        this.mobileNumber = mobileNumber; //mobile number of customer
        this.custBookings = custBookings; //bookings made by customer
    }
    
	public void setNameCustomer(String nameCustomer) { //class to set name of customer
		this.nameCustomer = nameCustomer;
	}
	
	public void setMobileNumber(int mobileNumber) { //class to set mobile number of customer
		this.mobileNumber = mobileNumber;
	}
	
	public String getNameCustomer() { //class to get name of customer
		return nameCustomer;
	}
	
	public int getMobileNumber() { //class to get mobile number of customer
		return mobileNumber;
	}
	
	public String getEmailCustomer() { //class to get email of customer
		return emailCustomer;
	}

	public void setEmailCustomer(String emailCustomer) { //class to set email address of customer
		this.emailCustomer = emailCustomer;
	}
	

	public void setBooking(BookingTicket booking) { //class to add new bookings 
		if(!custBookings.contains(booking)) {
		custBookings.add(booking);}
	}
	
	public ArrayList<BookingTicket> getCustBookings() { //class to return list of bookings by customer
		return custBookings;
	}

}
