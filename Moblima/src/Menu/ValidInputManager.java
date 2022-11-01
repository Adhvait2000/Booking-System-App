package Menu;
import java.util.Scanner;

public class ValidInputManager {	
	public static int GetInt()
	{
		boolean inputReceived = false;
		int input = -1;
		while(!inputReceived)
		{
			try
			{
				System.out.println("...Enter your choice:");
				Scanner scan = new Scanner(System.in);
				input = scan.nextInt();
				inputReceived = true;
			}
			catch (Exception e)
			{
				System.out.println("...Wrong input, please try again.");
			}
		}
		
		return input;
	}
	
	public static String GetString()
	{
		boolean inputReceived = false;
		String input = "";
		while(!inputReceived)
		{
			try
			{
				System.out.println("...Enter:");
				Scanner scan = new Scanner(System.in);
				input = scan.nextLine();
				inputReceived = true;
			}
			catch (Exception e)
			{
				System.out.println("...Wrong input, please try again.");
			}
		}
		
		return input;
	}
}
