package MOBLIMA;

//import necessary files;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class to generate price for movie ticket
 * 
 * @version 1.0
 * @since 2022-11-01
 */

public class MovieTicket {

	// declaration of variables
	// is movie 3D or not?;
	/**
	 * Created a boolean value to find out if the movie is 3D or not
	 */
	private boolean is3D;

	// ticket price;
	/**
	 * Declare the ticket price-Base price
	 */
	private double Price = 9.00;

	// holiday or weekday?;
	/**
	 * Type of day that it falls on
	 */
	private boolean holsOrWeekday;

	// cateogry of cinema it falls under;
	/**
	 * The type of cinema category customer wants
	 */
	private String typeOfCinema;

	// child, adult or senior?;
	/**
	 * Category of the customer-Adult/Child/Senior citizen
	 */
	private String movieGoerClass;

	/**
	 * Constructor for movieticket
	 * 
	 * @param is3D           Check if the customers' movie is 3D
	 * @param typeofCinema   category of cinema-Standard/Premium/Platinum
	 * @param movieGoerClass category of customer-Adult/Child/Senior citizen
	 * @param holsOrWeekday  boolean value for the day that it falls under
	 */
	public MovieTicket(boolean is3D, String typeOfCinema, String movieGoerClass, boolean holsOrWeekday) {
		this.is3D = is3D;
		this.typeOfCinema = typeOfCinema;
		this.movieGoerClass = movieGoerClass;
		this.holsOrWeekday = holsOrWeekday;
	}

	// function to calculate price;
	/**
	 * To calculate the ticket prices
	 * Done in Singapore Dollars
	 * Increase price in certain conditions-Platninum ticket/Holiday etc
	 * 
	 * @return price of movie ticket
	 */
	private double computePrice() {
		PriceType displayprice = new PriceType();
		/**
		 * Prices computed in singapore dollars
		 */

		// if 3D, price should be added;
		/**
		 * Increase the price if movie is 3D
		 */
		if (is3D)
			Price = Price + displayprice.get3DPricing();

		// price changes according to type of cinema;
		/**
		 * Increase price according to the category of cinema it falls under
		 */
		if (typeOfCinema.equals("Standard"))
			Price = Price + displayprice.getStandardPricing();
		else if (typeOfCinema.equals("Premium"))
			Price = Price + displayprice.getPremiumPricing();
		else if (typeOfCinema.equals("Platinum"))
			Price = Price + displayprice.getPlatinumPricing();

		// child or senior have discounts accordingly;
		/**
		 * Discounts for ticketprice if customer is Child/Senior citizen
		 */
		if (movieGoerClass == ("Child"))
			Price = Price - displayprice.getChildPricing();
		else if (movieGoerClass == ("SeniorCitizen"))
			Price = Price - displayprice.getSeniorCitizenPricing();

		// prices increase if holiday;
		/**
		 * Increase the ticket price if day is public holiday
		 */
		if (holsOrWeekday)
			Price = Price + displayprice.getPublicHolidayPricing();

		// After GST;
		/**
		 * Final price after GST is included
		 */
		Price = Price + displayprice.getGSTPricing() * Price;
		return Price;
	}

	// total to pay;
	/**
	 * Get overall price of ticket
	 * 
	 * @return the function to compute overall price
	 */
	public double findPrice() {
		double totalPrice = computePrice();
		return totalPrice;
	}

}
