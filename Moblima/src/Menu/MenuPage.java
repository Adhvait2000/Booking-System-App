package Menu;

public abstract class MenuPage {
	MenuPage nextPage;
	
	public boolean goNext = false;
	public boolean endMenu = false;
	
	public abstract void Initialize();
	
	public abstract void Update();
	
	public abstract void End();
	
	public MenuPage getNextPage()
	{
		return nextPage;
	}
}
