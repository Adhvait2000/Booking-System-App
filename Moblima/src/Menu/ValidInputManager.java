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
				System.out.printf("...Enter your choice:");
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
	
	public static int GetIntWithinRange(int minInclusive, int maxExclusive)
	{
		boolean inputReceived = false;
		int input = -1;
		while(!inputReceived)
		{
			try
			{
				System.out.printf("...Enter your choice [%d ~ %d]:", minInclusive, maxExclusive-1);
				Scanner scan = new Scanner(System.in);
				input = scan.nextInt();
				if(input >= minInclusive && input < maxExclusive)
					inputReceived = true;
				else
					throw new Exception();
			}
			catch (Exception e)
			{
				System.out.println("...Wrong input, please try again.");
			}
		}
		
		return input;
	}
	
	public static double GetDoubleWithinRange(double minInclusive, double maxExclusive)
	{
		boolean inputReceived = false;
		double input = -1;
		while(!inputReceived)
		{
			try
			{
				System.out.printf("...Enter your choice [%.1f ~ %.1f]:", minInclusive, maxExclusive);
				Scanner scan = new Scanner(System.in);
				input = scan.nextDouble();
				if(input >= minInclusive && input <= maxExclusive)
					inputReceived = true;
				else
					throw new Exception();
			}
			catch (Exception e)
			{
				System.out.println("...Wrong input, please try again.");
			}
		}
		
		return input;
	}
	
	public static double GetDouble()
	{
		boolean inputReceived = false;
		double input = -1;
		while(!inputReceived)
		{
			try
			{
				System.out.printf("...Enter your choice:");
				Scanner scan = new Scanner(System.in);
				input = scan.nextDouble();
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
				System.out.printf("...Enter:");
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
	
	public static String GetStringInChoices(String[] choices)
	{
		boolean inputReceived = false;
		String input = "";
		while(!inputReceived)
		{
			try
			{
				System.out.printf("...Enter:");
				Scanner scan = new Scanner(System.in);
				input = scan.nextLine();
				boolean choiceFound = false;
				if(choices.length > 0)
				{
					for(int i = 0; i < choices.length; i++)
					{
						if(input.toLowerCase().equals(choices[i].toLowerCase()))
						{
							choiceFound = true;
							break;
						}
					}
				}
				if(!choiceFound)
					throw new Exception();
				
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
