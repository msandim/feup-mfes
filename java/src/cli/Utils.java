package cli;

import trainline.quotes.DownQuote;
import trainline.quotes.UpQuote;

public class Utils
{
	public static Object parseSemaphore(String value)
	{
		if(value.equalsIgnoreCase("up"))
			return UpQuote.getInstance();

		else if(value.equalsIgnoreCase("down"))
			return DownQuote.getInstance();

		return null;
	}
}
