import java.util.Calendar;

/**
 *  * The Class for generating Transaction IDs
 */

class Cinema
{
	String code;
}

public class TransactionID {

	private String TID;
	/**
	 * TransactionID Constructor
	 * @param cinemaID ID of the cinema
	 */
	public TransactionID(Cinema cinema) {

		createTID(cinema.code);
	}
	
	/**
	 * Create a new transaction ID
	 * @return generated Transaction ID based on format of Assignment Manual
	 */
	private void createTID(String cinemaCode) {
		TID = cinemaCode + Calendar.getInstance().get(Calendar.YEAR) + Calendar.getInstance().get(Calendar.MONTH) + Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + Calendar.getInstance().get(Calendar.MINUTE);
	}
	
	/**
	 * get the transaction ID
	 * @return transaction ID
	 */
	public String getTID() {
		return TID;
	}
}
