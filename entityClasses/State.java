package entityClasses;


import java.util.Map;
import exceptions.*;


public class State {
	
	// Maps an Input key to a Transition object
	private Map<String, Transition> inputTransition;
	private String stateKey;
	
	
	public State(Map<String, Transition> inputTransition, String stateKey){
			
		this.inputTransition = inputTransition;
		this.setStateKey(stateKey);
	}

	public Transition fire(String input) throws UnknownInput
	{
			if (!inputTransition.containsKey(input))
				throw new UnknownInput(input);
			
			return inputTransition.get(input);
	}
	
	
	
	public void setStateKey(String stateKey) {
		this.stateKey = stateKey;
	}

	public String getStateKey() {
		return stateKey;
	}
	
	public Map<String, Transition> getInputTransition()
	{
		return this.inputTransition;
	}
	
}
