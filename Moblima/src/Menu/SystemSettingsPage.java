package Menu;

public class SystemSettingsPage extends MenuPage {
	static final int TICKETPRICES = 1;
	static final int HOLIDAYS = 2;
	

	@Override
	public void Initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("System Settings");
		System.out.println("...1. Configure Ticket Prices");
		System.out.println("...2. Configure Holidays");
		System.out.println("...3. Go back");
		int choice = ValidInputManager.GetIntWithinRange(1, 4);
		
		switch(choice)
		{
		case TICKETPRICES:
			nextPage = new ConfigureTicketPrices();
			goNext = true;
			break;
		case HOLIDAYS:
			break;
		default:
			this.endMenu = true;
			return;
		}
	}

	@Override
	public void End() {
		// TODO Auto-generated method stub

	}

}
