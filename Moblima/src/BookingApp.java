import java.util.Scanner;

public class BookingApp {	
	private static void PrintGreeting()
	{
		System.out.println(	"╔╦╗╔═╗╔╗ ╦  ╦╔╦╗╔═╗\n"
						  + "║║║║ ║╠╩╗║  ║║║║╠═╣\n"
						  + "╩ ╩╚═╝╚═╝╩═╝╩╩ ╩╩ ╩");
		System.out.println("Welcome, please choose a user mode:\n"
							+ "...1) Admin\n"
							+ "...2) Customer\n"
							+ "...3) Quit MOBLIMA"
							);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintGreeting();
		int userType = 0; // 0 = NOT SET, 1 = Admin, 2 = Customer	
		userType = ValidInputManager.GetInt();
		
	}
	
}
