package handlers;

import java.util.ArrayList;

public class Stat {
	
	private String name;
	private int value;
	private boolean isUnavailable = false;
	private int modifier;
	private ArrayList<Stat> stat;
	
	public Stat(String nameIn, int valueIn) {

		setName(nameIn);
		setValue(valueIn);


	}

	public static void statModifier (ArrayList<Stat> stat) {

		for (Stat s : stat) {
			if (s.getValue() == 20 || s.getValue() == 21) {
				s.setModifier(5);
			}
			if (s.getValue() == 18 || s.getValue() == 19) {
				s.setModifier(4);
			}
			if (s.getValue() == 16 || s.getValue() == 17) {
				s.setModifier(3);
			}
			if (s.getValue() == 14 || s.getValue() == 15) {
				s.setModifier(2);
			}
			if (s.getValue() == 12 || s.getValue() == 13) {
				s.setModifier(1);
			}
			if (s.getValue() == 10 || s.getValue() == 11) {
				s.setModifier(0);
			}
			if (s.getValue() == 8 || s.getValue() == 9) {
				s.setModifier(-1);
			}
			if (s.getValue() == 6 || s.getValue() == 7) {
				s.setModifier(-2);
			}
			if (s.getValue() == 4 || s.getValue() == 5) {
				s.setModifier(-3);
			}
			if (s.getValue() == 2 || s.getValue() == 3) {
				s.setModifier(-4);
			}
			if (s.getValue() == 0 || s.getValue() == 1) {
				s.setModifier(-5);
			}
		}
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
	public boolean changeValueIfAvailable(int valueIn) {
		if(isUnavailable)
			return false;
		else {
			value += valueIn;
			this.isUnavailable = true;
		}
		return true;
	}

	public int getModifier() {
		return modifier;
	}

	public void setModifier(int modifier) {
		this.modifier = modifier;
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
