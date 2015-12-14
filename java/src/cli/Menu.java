package cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu
{
	private String mTitle;
	private String mDescription;
	private List<MenuEntry> mEntries;

	public Menu(String title, String description)
	{
		mTitle = title;
		mDescription = description;
		mEntries = new ArrayList<>();
	}

	public void addEntry(MenuEntry entry)
	{
		mEntries.add(entry);
	}

	public void print()
	{
		// Print title and description of menu:
		Printer.println(mTitle);
		Printer.println(mDescription);

		for (int i = 0; i < mEntries.size(); i++)
		{
			Printer.print(String.valueOf(i + 1));
			Printer.print(". ");
			mEntries.get(i).print();
		}

		Printer.print(String.valueOf(mEntries.size() + 1));
		Printer.println(". Exit");
	}

	public void run()
	{
		Scanner scanner = new Scanner(System.in);

		// Process commands, until command == exit:
		while(true)
		{
			// Print menu:
			print();

			// Get integer:
			while (!scanner.hasNextInt())
				scanner.next();
			int option = scanner.nextInt();

			// Skip rest of the line:
			scanner.nextLine();

			// If option corresponds to the exit option, exit cycle:
			if(option == mEntries.size() + 1)
				break;

			// If option is invalid, skip:
			if(option <= 0 || option > mEntries.size() + 1)
				continue;

			// Select option:
			select(option);

			// Wait for info:
			scanner.nextLine();
		}
	}

	public void select(int option)
	{
		mEntries.get(option - 1).select();
	}
}
