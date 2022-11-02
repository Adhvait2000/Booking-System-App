package Menu;

public class MainMenu extends MenuPage {
	static final int USER_ADMIN = 1;
	static final int USER_CUSTOMER = 2;
	@Override
	public void Initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println(	"╔╦╗╔═╗╔╗ ╦  ╦╔╦╗╔═╗\n"
						  + "║║║║ ║╠╩╗║  ║║║║╠═╣\n"
						  + "╩ ╩╚═╝╚═╝╩═╝╩╩ ╩╩ ╩");
		System.out.println("Welcome, please choose a user mode:\n"
			+ "...1) Admin\n"
			+ "...2) Customer\n"
			+ "...3) Quit MOBLIMA"
			);
		
		int userType = 0; // 0 = NOT SET, 1 = Admin, 2 = Customer	
		userType = ValidInputManager.GetIntWithinRange(1, 4);
		
		switch(userType)
		{
		case USER_ADMIN:
			nextPage = new AdminLoginPage();
			break;
		case USER_CUSTOMER:
			nextPage = new CustomerPage();
			break;
		default:
			endMenu = true;
			return;
		}
		
		goNext = true;
	}

	@Override
	public void End() {
		// TODO Auto-generated method stub
		
	}
}
