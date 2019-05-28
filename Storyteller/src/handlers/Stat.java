package handlers;

public class Stat {
	
	private String name;
	private int value;
	
	public Stat(String nameIn, int valueIn) {

		setName(nameIn);
		setValue(valueIn);
		
	}





	
	private void setName(String nameIn) {
		
		name = nameIn;
		
	}
	
	private void setValue(int valueIn) {
		
		value = valueIn;
		
	}
	
	public void changeValue(int valueIn) {
		
		value += valueIn;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public int getValue() {
		
		return value;
		
	}
	
	public String toString() {
		
		return name + ": " + value + ".";
		
	}
	
}
