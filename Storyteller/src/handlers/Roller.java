package handlers;

import java.util.Arrays;

public class Roller {

	private static int generateRandomInteger() {
		
		return (int) (Math.random() * 6 + 1);
		
	}
	
	public static int generateRoll() {
		
		int[] rolls = new int[4];
		
		for (int i = 0; i < 4; i++) {
			
			rolls[i] = generateRandomInteger();
			
		}
		
		Arrays.sort(rolls);
		
		return rolls[1] + rolls[2] + rolls[3];
		
	}

}
