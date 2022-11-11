package MOBLIMA;
//import the necessary files;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 This class is to update and write prices to txt file
 @version 1.0
 @since 2022-11-01
 */

public class UpdateTicketPrices {
	int x;
	/**
	 * Write ticket price into txt file
	 * @param priceLatest This is the new latest price array
	 */
	public void priceLog(ArrayList priceLatest) {
		try {
			PrintWriter listp = new PrintWriter(System.getProperty("user.dir") + "/Moblimadata/prices.txt");
			// declare and initialise;
			for (x = 0; x < 7; x++) {
				// for loop;
				listp.println(priceLatest.get(x));
			}
			listp.print(priceLatest.get(7));
			listp.close();
		}
		catch (FileNotFoundException exc) {
			exc.printStackTrace();
		}
	}
}
