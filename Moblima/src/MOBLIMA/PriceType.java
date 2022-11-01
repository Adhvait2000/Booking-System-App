package MOBLIMA;
import java.util.*;

//import model.TicketPrice;

public class PriceType { //class to obtain prices for different types of tickets
		
		PriceTicket PT = new PriceTicket();
		
		private ArrayList<Double> priceType = PT.getPrice();
		
		public double get3DPricing() {
			return priceType.get(0);
		}
		
		public double getStandardPricing() {
			return priceType.get(1);
		}
		
	
		public double getPremiumPricing() {
			return priceType.get(2);
		}
		

		public double getPlatinumPricing() {
			return priceType.get(3);
		}
		
		
		public double getChildPricing() {
			return priceType.get(4);
		}
		
		
		public double getSeniorCitizenPricing() {
			return priceType.get(5);
		}
		
		
		public double getPublicHolidayPricing() {
			return priceType.get(6);
		}
		
		
		public double getGSTPricing() {
			return priceType.get(7);
		}
		
}

