package MOBLIMA;

import Menu.*;
import java.util.Stack;

public class BookingApp {	
	static Stack<MenuPage> menuStack;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menuStack = new Stack<MenuPage>();
		menuStack.push(new MainMenu()); //
		menuStack.peek().Initialize();
		
		while(!menuStack.isEmpty())
		{
			MenuPage currentMenu = menuStack.peek();
			System.out.println("");
			currentMenu.Update();
			
			// if goNext Flag is set to true, go to next page
			if(currentMenu.goNext)
			{
				menuStack.push(currentMenu.getNextPage());
				menuStack.peek().Initialize();
			}
			
			// if endMenu Flag is set to true, pop page from stack.
			if(currentMenu.endMenu)
			{
				MenuPage prevMenu = menuStack.pop();
				prevMenu.End();
				
				// While stack is not empty, pop page if endWhenGoNext flag is set to true
				while(!menuStack.isEmpty())
				{
					if(menuStack.peek().endWhenGoNext)
						menuStack.pop();
					// Else, set goNext flag back to false to run page again
					else
					{
						menuStack.peek().goNext = false;
						break;
					}
				}
			}
		}
		
		System.out.println("Exiting MOBLIMA...");
	}
}
