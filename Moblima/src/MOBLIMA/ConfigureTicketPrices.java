import java.util.*;

public class ConfigureTicketPrices
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        boolean back = false;
        
        double newPrice;
        
        ArrayList<Double> prices = new ArrayList();
        prices = PriceTicket.getPrice();
        
        System.out.println("Configuring Ticket Prices");
        
        while(true)
        {
            PriceType Quotation = new PriceType();
            System.out.println("1. 3D Movie Price");
	          System.out.println("2. Seat Type (Standard)");
            System.out.println("3. Seat Type (Premium)");
            System.out.println("4. Seat Type (Platinum)");
            System.out.println("5. Child Price");
            System.out.println("6. Senior Citizen Price");
            System.out.println("7. Public Holiday Price");
            System.out.println("8. GST %");
            System.out.println("9. FINALIZE CHANGES");
            System.out.println("10. Back");
            
            System.out.println("Enter a choice");
            int choice = sc.nextInt();
            
            switch(choice)
            {
                case 1:
                System.out.println("Current 3D Price" + Quotation.get3DPrice());
                System.out.println("New 3D Price");
                newPrice = sc.nextDouble();
                prices.set(0,newPrice);
                break;
                
                case 2:
                System.out.println("Current Standard Ticket Price " + Quotation.getStandardPrice());
                System.out.println("New Standard Ticket Price");
                newPrice = sc.nextDouble();
                prices.set(1,newPrice);
                break;
                
                case 3:
                System.out.println("Current Premium Ticket Price " + Quotation.getPremiumPrice());
                System.out.println("New Premium Ticket Price");
                newPrice = sc.nextDouble();
                prices.set(2,newPrice);
                break;
                
                case 4:
                System.out.println("Current Platinum Ticket Price " + Quotation.getPlatinumPrice());
                System.out.println("New Platinum Ticket Price");
                newPrice = sc.nextDouble();
                prices.set(3,newPrice);
                break;
                
                case 5:
                System.out.println("Current Child Ticket Price" + Quotation.getChildPrice());
                System.out.println("New Child Ticket Price");
                newPrice = sc.nextDouble();
                prices.set(4,newPrice);
                break;
                
                case 6:
                System.out.println("Current Senior Citizen Price" + Quotation.getSeniorCitizenPrice());
                System.out.println("New Senior Citizen Price");
                newPrice = sc.nextDouble();
                prices.set(5,newPrice);
                break;
                
                case 7:
                System.out.println("Current Public Holiday Price" + Quotation.getPublicHolidayPrice());
                System.out.println("New Public Holiday Price:");
                newPrice = sc.nextDouble();
                prices.set(6,newPrice);
                break;
                
                case 8:
                System.out.println("Current Price" + Quotation.getGSTPrice());
                System.out.println("New Price:");
                newPrice = sc.nextDouble();
                prices.set(7,newPrice);
                break;
                
                case 9:
                UpdateTicketPrices UpdatePrice = new UpdateTicketPrices();
                UpdatePrice.priceLog(prices);
                System.out.println(AdminChangeStatus.SUCCESSFUL.returningStatus());
                break;
                
                case 10:
                back=true;
                break;
                
                default:
                System.out.println("Invalid Input, Please try again");
                break;
                
            }
            System.out.println("");
            
            if(back)
            return;
        }
    }
}
