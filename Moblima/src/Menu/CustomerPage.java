package Menu;
import MOBLIMA.MovieCineplexModel;

import java.util.ArrayList;

import MOBLIMA.Cineplex;

public class CustomerPage extends MenuPage {
	static final int MOVIES_DETAILS = 1;
	static final int SEAT_AVAILABILITY = 2;
	static final int PURCHASE_TICKETS = 3;
	static final int BOOKING_HISTORY = 4;
	static final int TOP_RANKING = 5;
	static final int ALL_CINEPLEX = 6;
	
	@Override
	public void Initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("Customer Mode");
		System.out.println("...1) List All Movies and Movie Details");
		System.out.println("...2) Check Seat Availability");
		System.out.println("...3) Book and Purchase movie tickets");
		System.out.println("...4) View booking history");
		System.out.println("...5) List top 5 movies ranked by ticket sales or overall reviewer's ratings");
		System.out.println("...6) List all Cineplexes");
		System.out.println("...7) Go Back");
		
		int choice = ValidInputManager.GetInt();
		switch(choice)
		{
		case MOVIES_DETAILS:
			break;
		case SEAT_AVAILABILITY:
			SeatAvailabilityUpdate();
			break;
		case PURCHASE_TICKETS:
			break;
		case BOOKING_HISTORY:
			break;
		case TOP_RANKING:
			break;
		case ALL_CINEPLEX:
			break;			
		case 7:
			endMenu = true;
			break;
		}
	}

	public void SeatAvailabilityUpdate()
	{
		ArrayList<Cineplex> cineplexes;
		try
		{
			cineplexes = MovieCineplexModel.getInstance().GetCineplexes();
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public void End() {
		// TODO Auto-generated method stub

	}

}
