package exceptions;

public class UnknownState extends Exception
{	
	private String unknownState;
	
	public UnknownState(String stateKey)
	{
		super();
		unknownState = stateKey;
	}
	
	public String getMessage()
	{
		return "Unknown state key: " + unknownState;
	}
}
