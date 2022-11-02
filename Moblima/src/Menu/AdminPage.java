package Menu;
import java.io.IOException;
import java.io.PrintWriter;

import MOBLIMA.Password;

public class AdminPage extends MenuPage {
	static final int CRU_MOVIELISTING = 1;
	static final int CRU_CINEMASHOWTIMES = 2;
	static final int ADDNEWADMIN = 3;
	static final int CONFIGURE_SETTINGS = 4;
	
	
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
		System.out.println("...3) Add new Admin");
		System.out.println("...4) Configure Settings");
		System.out.println("...5) Go back");
		
		int choice = ValidInputManager.GetInt();
		switch(choice)
		{
		case CRU_MOVIELISTING:
			break;
		case CRU_CINEMASHOWTIMES:
			break;
		case ADDNEWADMIN:
			AddNewAdminUpdate();
			break;
		case CONFIGURE_SETTINGS:
			break;
		case 5:
			endMenu = true;
		}

	}
	
	public void AddNewAdminUpdate()
	{
		System.out.println("New Admin Setup");
		System.out.println("...Please input new password now");
		String pass = ValidInputManager.GetString();
		
		try {
			Password.addPassword(pass);
			System.out.println("...Successfully onboarded admin");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}		
	}

	@Override
	public void End() {
		// TODO Auto-generated method stub
		
	}
}
