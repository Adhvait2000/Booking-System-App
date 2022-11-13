package Menu;

public abstract class MenuPage {
	MenuPage nextPage;

	public boolean endWhenGoNext = false;
	public boolean goNext = false;
	public boolean endMenu = false;

	public abstract void Initialize();

	public abstract void Update();

	public abstract void End();

	/**
	 * @return MenuPage
	 */
	public MenuPage getNextPage() {
		return nextPage;
	}
}
