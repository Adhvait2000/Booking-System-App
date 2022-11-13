package Menu;

import java.util.*;

import MOBLIMA.AdminChangeStatus;
import MOBLIMA.PriceTicket;
import MOBLIMA.PriceType;
import MOBLIMA.UpdateTicketPrices;

public class ConfigureTicketPrices extends MenuPage {
    @Override
    public void Initialize() {

    }

    @Override
    public void Update() {
        boolean back = false;

        double newPrice;

        ArrayList<Double> prices = new ArrayList();
        prices = PriceTicket.getPrice();

        System.out.println("Configuring Ticket Prices");

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
        int choice = ValidInputManager.GetIntWithinRange(1, 11);

        switch (choice) {
            case 1:
                System.out.println("Current 3D Price" + Quotation.get3DPricing());
                System.out.println("New 3D Price");
                newPrice = ValidInputManager.GetInt();
                prices.set(0, newPrice);
                break;

            case 2:
                System.out.println("Current Standard Ticket Price " + Quotation.getStandardPricing());
                System.out.println("New Standard Ticket Price");
                newPrice = ValidInputManager.GetDouble();
                prices.set(1, newPrice);
                break;

            case 3:
                System.out.println("Current Premium Ticket Price " + Quotation.getPremiumPricing());
                System.out.println("New Premium Ticket Price");
                newPrice = ValidInputManager.GetDouble();
                prices.set(2, newPrice);
                break;

            case 4:
                System.out.println("Current Platinum Ticket Price " + Quotation.getPlatinumPricing());
                System.out.println("New Platinum Ticket Price");
                newPrice = ValidInputManager.GetDouble();
                prices.set(3, newPrice);
                break;

            case 5:
                System.out.println("Current Child Ticket Price" + Quotation.getChildPricing());
                System.out.println("New Child Ticket Price");
                newPrice = ValidInputManager.GetDouble();
                prices.set(4, newPrice);
                break;

            case 6:
                System.out.println("Current Senior Citizen Price" + Quotation.getSeniorCitizenPricing());
                System.out.println("New Senior Citizen Price");
                newPrice = ValidInputManager.GetDouble();
                prices.set(5, newPrice);
                break;

            case 7:
                System.out.println("Current Public Holiday Price" + Quotation.getPublicHolidayPricing());
                System.out.println("New Public Holiday Price:");
                newPrice = ValidInputManager.GetDouble();
                prices.set(6, newPrice);
                break;

            case 8:
                System.out.println("Current Price" + Quotation.getGSTPricing());
                System.out.println("New Price:");
                newPrice = ValidInputManager.GetDouble();
                prices.set(7, newPrice);
                break;

            case 9:
                UpdateTicketPrices UpdatePrice = new UpdateTicketPrices();
                UpdatePrice.priceLog(prices);
                System.out.println(AdminChangeStatus.SUCCESSFUL.returnStatus());
                break;

            case 10:
                this.endMenu = true;
                return;
        }
    }

    @Override
    public void End() {

    }
}
