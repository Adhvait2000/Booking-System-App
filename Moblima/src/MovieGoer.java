package project2002;

import java.util.*;
import java.io.*;

public class MovieGoer { //details of movie goers i.e. our customers
	
	private int idCustomer; //id of customer
	
	private String nameCustomer; //name of customer
    
    private int mobileNumber; //mobile number of customers
    
    private ArrayList<BookingTicekts> custBookings = new ArrayList<>(); //list of bookings made by a customer
    
    public MovieGoer() {};
   
    public MovieGoer(String nameCustomer, int mobileNumber, String email, ArrayList<BookingTicekts> custBookings){ //constructor for the class
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
	
	public int getIDCustomer() { //class to get id of customer
		return idCustomer;
	}

	public void setIDCustomer(int idCustomer) { //class to set id of customer
		this.idCustomer = idCustomer;
	}
	

	public void setBooking(BookingTickets booking) { //class to add new bookings 
		if(!custBookings.contains(booking)) {
		custBookings.add(booking);}
	}
	
	public ArrayList<BookingTickets> getCustBookings() { //class to return list of bookings by customer
		return custBookings;
	}

}
