package MOBLIMA;

import java.io.*;
import java.util.*;

public class PriceTicket {

	// Store prices for each type of ticket

	private static ArrayList<Double> priceList = new ArrayList<>(); // create a new ArrayList for storing prices of
																	// tickets

	public static ArrayList<Double> getPrice() {

        File text_file;
        
		if(System.getProperty("os.name").startsWith("Windows"))
		{
			text_file = new File(System.getProperty("user.dir") + "/data/ticket_prices.txt");
		}else
		{
			text_file = new File(System.getProperty("user.dir") + "/Moblima/data/ticket_prices.txt");
		}
        																							// ticket

		try {

			Scanner sc = new Scanner(text_file);

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
