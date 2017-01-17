package Main;

import java.util.*;

import entityClasses.ChowGroup;
import entityClasses.FiniteStateMachine;
import entityClasses.State;
import entityClasses.Transition;
import exceptions.UnknownInput;
import exceptions.UnknownState;

public class MainFSMEmulator {

	/**
	 * @param args
	 */
	
	public static void pTables(FiniteStateMachine fsm)
	{
		ArrayList<Map<String, ChowGroup>> pTables = new ArrayList<Map<String, ChowGroup>>();
		
		// Create a map of ChowGroups, key = groupname, value = ChowGroup
		Map<String, ChowGroup> groupMap = new HashMap<String, ChowGroup>();
		
		// Pull all states from the machine
		Map<String, State> baseStates = fsm.getStates();
	    
		// Loop through all the states
	    for(String s : baseStates.keySet())
	    {
	    	// Pull out the active state
	    	State baseState = baseStates.get(s);
	    	
	    	// Grab the active state's transitions, one for each input
	    	Map<String, Transition> baseStateTransitions = baseState.getInputTransition();
	    	
	    	// Initialize the output string that will be the group names for a ChowGroup
	    	String baseStateOutput = "";
	    	
	    	// Loop through the transitions
	    	for(String t : baseStateTransitions.keySet())
	    	{
	    		// Pull out the active transition
	    		Transition transition = baseStateTransitions.get(t);
	    		
	    		// Concatenate the transition's output onto our group name string
	    		baseStateOutput += transition.getOutput();
	    	}
	    	
	    	// Once our output string has been built for this state, check to see if a group with that name already exists
	    	if(!groupMap.containsKey(baseStateOutput))
	    	{
	    		// If there is not a group for that output, then create one and save the state into it
	    		ChowGroup group =  new ChowGroup(baseStateOutput);
	    		groupMap.put(baseStateOutput, group);
	    	}
	    	
	    	groupMap.get(baseStateOutput).addState(baseState);
	    }
	    
	    // At this point our group map should have groups with splits based upon output. This is our P1 table
	    // Save our P1 table
	    pTables.add(1, groupMap);
	    
	    // Now we need to identify each transition state within each state with it's Group ID
	    // Loop through the groupMap
	    //		Loop through each state
	    //			Update each state's transition states by adding their parent group ID to each of them
	    
	    
	    // Now we have a p1 table with the transition state's group ID different than the group they reside in
	    // Save this table as a reference point
	    
	    // Now we need to regroup based upon differentiation in transitions states group ID
	    // Pull all states out of the groups
	    // Loop through all states
	    // 		Store each states transition state Group ID in an array with an index as its input
	    //		On each iteration check the previous state's group ID
	    //		If they are the same
	    //			Store the parent state in the same group as previous parent state
	    //		If they are different
	    //			Create a new group and store the parent state.
	    
	    // After this all groups should be divided based upon the transition states
	    // Save this table
	    // But now each transition group ID will be different than their actual referenced state's group ID
	    // Pass back through updating the state ID
	    
	    
	    
	    
	    // OLDER
		// Take all outputs for each states input and concatenate them into a string
		// This string represents the collection that the other states can fall into if they have matching output string
		// At this point each state should belong to a group based upon their output string
		
		// Save this table and duplicate into a new working table
		
		// loop through again and store the group id with each transition state
		
		// Save this table and duplicate into a new working table
		
		// loop through again and compare group numbers for each state input
		// if one row is different than the previous one increment our group number and store it with the parent state, not input transition states
		// At this point each state has a proper group id, and their internal transition groups need to be updated.
		
		// Save this table and duplicate into a new working table
		
		// loop through again and update each states input transitions with their proper group numbers
		
		// save this table and duplicate into a new wotking table
		
		// repeat until each parent state has a different group number, and loop through again to update its input transitions states
		
		
	}
	
	
	public static void main(String[] args) {
		
		// Viable inputs
		String inputA = "a";
		String inputB = "b";
		
		// State q1
		Map<String, Transition> q1Transitions = new HashMap<String, Transition>();
		q1Transitions.put(inputA, new Transition("0", "q1"));
		q1Transitions.put(inputB, new Transition("1", "q4"));
		State q1 = new State(q1Transitions, "q1");
		
		// State q2
		Map<String, Transition> q2Transitions = new HashMap<String, Transition>();
		q2Transitions.put(inputA, new Transition("0", "q1"));
		q2Transitions.put(inputB, new Transition("1", "q5"));
		State q2 = new State(q2Transitions, "q2");
		
		// State q3
		Map<String, Transition> q3Transitions = new HashMap<String, Transition>();
		q3Transitions.put(inputA, new Transition("0", "q5"));
		q3Transitions.put(inputB, new Transition("1", "q1"));
		State q3 = new State(q3Transitions, "q3");
		
		// State q4
		Map<String, Transition> q4Transitions = new HashMap<String, Transition>();
		q4Transitions.put(inputA, new Transition("1", "q3"));
		q4Transitions.put(inputB, new Transition("1", "q4"));
		State q4 = new State(q4Transitions, "q4");
		
		// State q5
		Map<String, Transition> q5Transitions = new HashMap<String, Transition>();
		q5Transitions.put(inputA, new Transition("1", "q2"));
		q5Transitions.put(inputB, new Transition("1", "q5"));
		State q5 = new State(q5Transitions, "q5");
		
		// State map for our Finite State Machine
		Map<String, State> states = new HashMap<String, State>();
		states.put(q1.getStateKey(), q1);
		states.put(q2.getStateKey(), q2);
		states.put(q3.getStateKey(), q3);
		states.put(q4.getStateKey(), q4);
		states.put(q5.getStateKey(), q5);
		
		// The starting state of our Finite State Machine
		String initialStateKey = "q1";
		
		// Test our finite state machine
		try
		{
			// Build the Finite State Machine
			FiniteStateMachine fsm = new FiniteStateMachine(states, initialStateKey);
			
			
			
			
			
			// Run our input string;
			LinkedList<String> inputString = new LinkedList<String>();
			inputString.add("a");
			inputString.add("a");
			inputString.add("b");
			inputString.add("a");
			
			Iterator<String> itr = inputString.iterator();
			while (itr.hasNext()) {
				
				try
				{
					fsm.input(itr.next());
				}
				catch(UnknownInput e)
				{
					e.getMessage();
				}
			}
		}
		catch(UnknownState e)
		{
			e.getMessage();
		}
		
		System.out.println("Program ending.");
		System.exit(0);
	}
}
