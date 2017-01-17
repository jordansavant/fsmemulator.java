package entityClasses;

import java.util.ArrayList;

public class ChowGroup {
	
	private String groupName;
	private ArrayList<State> groupStates;
	
	public ChowGroup(String groupName)
	{
		this.groupName = groupName;
	}

	public void addState(State state)
	{
		this.groupStates.add(state);
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupStates(ArrayList<State> groupStates) {
		this.groupStates = groupStates;
	}

	public ArrayList<State> getGroupStates() {
		return groupStates;
	}
	
	
}
