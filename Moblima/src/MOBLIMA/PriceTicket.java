package MOBLIMA;

import java.io.*;
import java.util.*;

/**
 * Obtain list of prices that contribute to the cost of a ticket
 * Prices are obtained from a text file
 * 
 * @version 1.0
 * @since 2022-11-01
 */
public class PriceTicket {

	/**
	 * Store prices in a list
	 */
	private static ArrayList<Double> priceList = new ArrayList<>();

	/**
	 * Read file stored in a directory to obtain prices
	 * 
	 * @return priceList The list of prices obtained from the text_file
	 */
	public static ArrayList<Double> getPrice() {

		File text_file;

		if (System.getProperty("os.name").startsWith("Windows")) // obtain file according to directory
		{
			text_file = new File(System.getProperty("user.dir") + "/data/ticket_prices.txt");
		} else {
			text_file = new File(System.getProperty("user.dir") + "/Moblima/data/ticket_prices.txt");
		}
		// ticket

		try {

			Scanner sc = new Scanner(text_file); // scan text file

			while (sc.hasNextLine()) { // while there is still data to be read continue to input next line in the file
				double input = sc.nextDouble();
				priceList.add(input);
			}
			sc.close();
		} catch (FileNotFoundException error) {
			error.printStackTrace(); // ensure that correct file is selected, backtrace and print error if the data
										// file is not found
		}

		return priceList;

	}

}
