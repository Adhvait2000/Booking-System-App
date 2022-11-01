package sc2002;

//import the necessary files;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class UpdateTicketPrices {
	int x;
	public void priceLog(ArrayList priceLatest) {
		
		try {
		PrintWriter listp = new PrintWriter("data/prices.txt");
		//declare and initialise;
		
		for(x = 0; x < 7; x++) {
			//for loop;
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
