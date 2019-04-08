package Classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/*
Player test class. Tests whether the given methods works as intended.
@Author Trym Staurheim
 */
public class PlayerTest {

    private String playerName;

    private Player playerUnderTest;

    @Before
    public void setUp() {
        playerName = "playerName";
        playerUnderTest = new Player(playerName);

    }

    @Test
    public void testGetAge() {
        // Setup
        final int expectedResult = 0;

        // Run the test
        final int result = playerUnderTest.getAge();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetAlignment() {
        // Setup
        final String expectedResult = "result";

        // Run the test
        final String result = playerUnderTest.getAlignment();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetRace() {
        // Setup
        final Race expectedResult = null;

        // Run the test
        final Race result = playerUnderTest.getRace();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetRole() {
        // Setup
        final Role expectedResult = null;

        // Run the test
        final Role result = playerUnderTest.getRole();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSetPlayerName() {
        // Setup
        final String playerName = "playerName";

        // Run the test
        playerUnderTest.setPlayerName(playerName);

        // Verify the results
    }

    @Test
    public void testSetSkills() {
        // Setup
        final Skills skills = null;

        // Run the test
        playerUnderTest.setSkills(skills);

        // Verify the results
    }
}
