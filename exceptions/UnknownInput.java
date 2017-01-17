package exceptions;

public class UnknownInput extends Exception
{
	private String unknownInput;
	
	public UnknownInput(String input)
	{
		super();
		unknownInput = input;
	}
	
	public String getMessage()
	{
		return "Unknown Input: " + unknownInput;
	}
}
