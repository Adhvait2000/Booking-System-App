package MOBLIMA;
//import necessary files;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovieTicket {

	//declaration of variables
	//is movie 3D or not?;
	private boolean is3D;
	
	//ticket price;
	private double Price = 9.00;
	
	//holiday or weekday?;
	private boolean holsOrWeekday;
	
	//cateogry of cinema it falls under;
	private String typeOfCinema;
	
	//child, adult or senior?;
	private String movieGoerClass;
	
	public MovieTicket(boolean is3D, String typeOfCinema, String movieGoerClass, boolean holsOrWeekday) {
		this.is3D = is3D;
		this.typeOfCinema = typeOfCinema;
		this.movieGoerClass = movieGoerClass;
		this.holsOrWeekday = holsOrWeekday;
	}
	
	//function to calculate price;
	private double computePrice() {
		PriceType displayprice = new PriceType();
		
		//if 3D, price should be added;
		if(is3D) 
			Price = Price + displayprice.get3DPricing();
		
		//price changes according to type of cinema;
		if(typeOfCinema.equals("Standard"))
			Price = Price + displayprice.getStandardPricing();
		else if(typeOfCinema.equals("Premium"))
			Price = Price + displayprice.getPremiumPricing();
		else if(typeOfCinema.equals("Platinum"))
			Price = Price + displayprice.getPlatinumPricing();
		
		//child or senior have discounts accordingly;
		if(movieGoerClass == ("Child"))
			Price = Price - displayprice.getChildPricing();
		else if(movieGoerClass ==("SeniorCitizen"))
			Price = Price - displayprice.getSeniorCitizenPricing();
		
		//prices increase if holiday;
		if(holsOrWeekday)
			Price = Price + displayprice.getPublicHolidayPricing();
		
		//After GST;
		Price = Price + displayprice.getGSTPricing() * Price;
		return Price;
	}
	
	//total to pay;
	public double findPrice() {
		double totalPrice = computePrice();
		return totalPrice;
	}

}
