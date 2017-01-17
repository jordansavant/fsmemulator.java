package entityClasses;

public class Transition {
	
	private String output;
	private String nextStateKey;
	
	public Transition(String output, String nextStateKey)
	{
		this.output = output;
		this.nextStateKey = nextStateKey;
	}

	
	
	
	public void setOutput(String output) {
		this.output = output;
	}

	public String getOutput() {
		return output;
	}

	public void setNextStateKey(String nextStateKey) {
		this.nextStateKey = nextStateKey;
	}

	public String getNextStateKey() {
		return nextStateKey;
	}
	
}
