package Menu;
import MOBLIMA.MovieCineplexModel;
import MOBLIMA.Password;

public class AdminLoginPage extends MenuPage {
	
	@Override
	public void Initialize() {
		// TODO Auto-generated method stub
		endWhenGoNext = true;
	}

	@Override
	public void Update() {
		System.out.println("Admin Login");
		// TODO Auto-generated method stub
		System.out.println("...Please login to continue...");
		System.out.println("...Please input password now");
		
		String pass = ValidInputManager.GetString();
		
		Password passwordHash = new Password();
		if(!passwordHash.checkPassword(pass)) // Login Failed
		{
			System.err.println("Wrong Password!");
			endMenu = true;
		}else
		{
			System.out.println("Login successful!");
			nextPage = new AdminPage();
			goNext = true;
		}
	}

	@Override
	public void End() {
		// TODO Auto-generated method stub

	}

}
