package MOBLIMA;

import Menu.*;
import java.util.Stack;

public class BookingApp {	
	static Stack<MenuPage> menuStack;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menuStack = new Stack<MenuPage>();
		menuStack.push(new AdminPage()); //
		menuStack.peek().Initialize();
		
		while(!menuStack.isEmpty())
		{
			MenuPage currentMenu = menuStack.peek();
			currentMenu.Update();
			
			if(currentMenu.goNext)
				menuStack.push(currentMenu.getNextPage());
			
			if(currentMenu.endMenu)
			{
				MenuPage prevMenu = menuStack.pop();
				prevMenu.End();
				if(!menuStack.isEmpty())
					menuStack.peek().goNext = false;
			}
		}
		
		System.out.println("Exiting MOBLIMA...");
	}
}
