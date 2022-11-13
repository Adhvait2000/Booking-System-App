package MOBLIMA;

import java.io.*;

/**
 * Class created to obtain and modify dates of public holidays
 * The dates are retrieved from a data file and modifications are written
 * directly to the file
 * 
 * @version 1.0
 * @since 2022-11-02
 */

public class PublicHolidayIO {

	/**
	 * Read dates of public holidays
	 * Data is obtained from a text file retrieved from a particular directory
	 * 
	 * @throws IOException
	 * @throws Exception
	 * @return public holiday date if reading is successful, or an empty string if
	 *         there are no more dates or if an exception error has occurred
	 */
	public String[] readPublicHolidays() throws IOException, Exception {
		FileReader text_file;

		if (System.getProperty("os.name").startsWith("Windows")) {
			text_file = new FileReader(System.getProperty("user.dir") + "/data/PublicHolidays.txt");
		} else {
			text_file = new FileReader(System.getProperty("user.dir") + "/Moblima/data/PublicHolidays.txt");
		}

		BufferedReader reader = new BufferedReader(text_file);

		try {
			return reader.readLine().split("[|]");

		} catch (Exception error) {

			String[] str = new String[0];
			return str;
		}

	}

	/**
	 * Write dates of public holidays
	 * Data is written directly to the text file
	 * 
	 * @throws IOException
	 * @throws Exception
	 * @param publicHolidays String containing one or more dates of publicHolidays
	 */

	public void writePublicHoliday(String[] publicHolidays) throws IOException, Exception {

		try {

			FileWriter text_file = new FileWriter("/Moblima/data/PublicHolidays.txt", false);
			BufferedWriter reader = new BufferedWriter(text_file);

			for (int i = 0; i < publicHolidays.length; i++)
				reader.write(publicHolidays[i] + "|");
			reader.close();

		} catch (IOException error) {

			error.printStackTrace();
		}

	}

}
