package entityClasses;

import java.util.*;
import exceptions.*;


public class FiniteStateMachine {
	
	Map<String, State> states;			// Maps a state key to a state object
	State currentState; 				// Holds the current state of the machine
	ArrayList<String> outputHistory;	// keeps a history of outputs produced by transitions
	ArrayList<String> stateHistory;		// keeps a history of state traversals produced by transitions
	ArrayList<String> inputHistory;		// keeps a history of inputs received

	public FiniteStateMachine(Map<String, State> states, String initialStateKey) throws UnknownState
	{
		this.outputHistory = new ArrayList<String>();
		this.stateHistory = new ArrayList<String>();
		this.inputHistory = new ArrayList<String>();
		
		// Print
		System.out.println("FSM Initialized. Starting state is: " + initialStateKey);
		
		// Store the given state map
		this.states = states;
		
		// Update our current state to the starting state
		updateCurrentState(initialStateKey);
		
		
	}
	
	public void updateCurrentState(String newStateKey) throws UnknownState
	{
		// Check that the state exists, if not throw exception for unknown state
		if(!states.containsKey(newStateKey))
			throw new UnknownState(newStateKey);
		
		// Update the current state of our FSM
		this.currentState = states.get(newStateKey);
		
		// Print
		System.out.println("CurrentState(" + newStateKey + ")");
	}
	
	public void input(String input) throws UnknownInput, UnknownState
	{
		// Receives the input string
		// Passes the input string to our current state
		// Gets the resulting transition from that state
		Transition transition = this.currentState.fire(input);
		String output = transition.getOutput();
		String nextStateKey = transition.getNextStateKey();
		
		// Record input, output, and currentState into history
		inputHistory.add(input);
		outputHistory.add(output);
		stateHistory.add(currentState.getStateKey());
		
		// Print
		System.out.println("\tInput(" + input + ") -> Output(" + output + ") -> NextState(" + nextStateKey + ")" );
		
		// Move to next state
		updateCurrentState(nextStateKey);
	}
	
	
	public Map<String, State> getStates()
	{
		return this.states;
	}
	
}
