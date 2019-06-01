package handlers;

import java.util.Arrays;

/** Class Roller Handles the randomly generated rolls for the character.
 *
 *
 */

public class Roller {
	/**
	 * generateRandomInteger() is a help method for generateRoll()
	 * @return a random {@code int } value between 1-6
	 */

	private static int generateRandomInteger() {
		
		return (int) (Math.random() * 6 + 1);
		
	}

	/**
	 *
	 * @return  the sum of: rolls[1] + rolls[2] + rolls[3]
	 */
	public static int generateRoll() {
		
		int[] rolls = new int[4];
		
		for (int i = 0; i < 4; i++) {
			
			rolls[i] = generateRandomInteger();
			
		}
		
		Arrays.sort(rolls);
		
		return rolls[1] + rolls[2] + rolls[3];
		
	}

}
