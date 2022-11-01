package Menu;

public class AdminPage extends MenuPage {
	static final int CRU_MOVIELISTING = 1;
	static final int CRU_CINEMASHOWTIMES = 2;
	static final int CONFIGURE_SETTINGS = 3;
	
	
	@Override
	public void Initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("Admin Page");
		System.out.println("...1) Create/Update/Remove Movie Listing");
		System.out.println("...2) Create/Update/Remove Cinema Showtimes and movies to be shown");
		System.out.println("...3) Configure Settings");
		System.out.println("...4) Go back");
		
		int choice = ValidInputManager.GetInt();
		switch(choice)
		{
		case 4:
			endMenu = true;
		}

	}

	@Override
	public void End() {
		// TODO Auto-generated method stub

	}

}
