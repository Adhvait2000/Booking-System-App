package MOBLIMA;
import java.util.*;

/**
  Represents base prices that can be included in the cost of a ticket
  Prices are broken down into the type of movie, type and date of screening, age of moviegoer, and GST 
  @version 1.0
  @since 2022-11-01
 */
public class PriceType { 
		
		/**
	 	 * Create a new price ticket
	 	 */
		PriceTicket PT = new PriceTicket();
		
		/**
	 	 * List to store different price types obtained from a data file
	 	 */
		private ArrayList<Double> priceType = PT.getPrice();
		
		/**
	 	 * Gets price for 3D movies
		 * @return 3D price which is the first element in the list, priceType
	 	 */
		public double get3DPricing() {
			return priceType.get(0);
		}
		
		/**
	 	 * Gets price for standard screening
		 * @return standard price which is the second element in the list, priceType
	 	 */
		public double getStandardPricing() {
			return priceType.get(1);
		}
		
		/**
	 	 * Gets price for premium screening
		 * @return premium price which is the third element in the list, priceType
	 	 */
		public double getPremiumPricing() {
			return priceType.get(2);
		}
		
		/**
	 	 * Gets price for platinum screening
		 * @return platinum price which is the fourth element in the list, priceType
	 	 */
		public double getPlatinumPricing() {
			return priceType.get(3);
		}
		
		/**
	 	 * Gets price for children including students and children above 0.9m in height
		 * @return child price which is the fifth element in the list, priceType
	 	 */
		public double getChildPricing() {
			return priceType.get(4);
		}
		
		/**
	 	 * Gets price for senior citizens
		 * @return senior citizen price which is the sixth element in the list, priceType
	 	 */
		public double getSeniorCitizenPricing() {
			return priceType.get(5);
		}
		
		/**
	 	 * Gets price for screenings held on public holidays
		 * @return public holiday price which is the seventh element in the list, priceType
	 	 */
		public double getPublicHolidayPricing() {
			return priceType.get(6);
		}
		
		/**
	 	 * Gets price for GST
		 * @return GST price which is the eigth element in the list, priceType
	 	 */
		public double getGSTPricing() {
			return priceType.get(7);
		}
		
}

