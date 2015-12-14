package cli;

public class MenuEntry
{
	private String mDescription;
	private Runnable mHandler;
	private Menu mNextMenu;

	public MenuEntry(String description)
	{
		mDescription = description;
		mHandler = null;
		mNextMenu = null;
	}
	public MenuEntry(String description, Runnable handler)
	{
		mDescription = description;
		mHandler = handler;
		mNextMenu = null;
	}
	public MenuEntry(String description, Menu nextMenu)
	{
		mDescription = description;
		mNextMenu = nextMenu;
		mHandler = null;
	}

	public void print()
	{
		Printer.println(mDescription);
	}

	public void select()
	{
		if(mHandler != null)
			mHandler.run();

		if(mNextMenu != null)
			mNextMenu.run();
	}
}
