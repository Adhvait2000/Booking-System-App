package MOBLIMA;

import java.io.*;

public class PublicHolidayIO {
	
	public String[] readPublicHolidays() throws IOException,Exception {
		
		FileReader text_file = new FileReader("data/PublicHolidays.txt");
		BufferedReader reader = new BufferedReader(text_file);
	    		
		try {
			return reader.readLine().split("[|]");
			
		} catch(Exception error) {
			
			String[] str = new String[0];
			return str;
		}
	            	
	    			
	}	
	    

	public void writePublicHoliday(String[] publicHolidays) throws IOException,Exception{
		
		try {
			
			FileWriter text_file = new FileWriter("data/PublicHolidays.txt", false);
			BufferedWriter reader = new BufferedWriter(text_file);
				
			for(int i=0; i<publicHolidays.length; i++)
				reader.write(publicHolidays[i] + "|");
				reader.close();
								
		} catch (IOException error) {
			
			error.printStackTrace();
		}
	    	
	}
	    


}
