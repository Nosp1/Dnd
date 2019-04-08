package Classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
/*
Test class for creating a new race of type Race.
@Author Trym Staurheim
 */
public class RaceTest {

    private String raceName;
    private int maxAge;
    private int raceIncreaseStats;
    private String languages;
    private String[] availableStats;

    private Race raceUnderTest;

    @Before
    public void setUp() {
        raceName = "raceName";
        maxAge = 0;
        raceIncreaseStats = 0;
        languages = "languages";
        availableStats = new String[]{};
        raceUnderTest = new Race(raceName, maxAge, raceIncreaseStats, languages, availableStats) {
        };
    }

    @Test
    public void testSetRaceName() {
        // Setup
        final String raceName = "raceName";

        // Run the test
        raceUnderTest.setRaceName(raceName);

        // Verify the results
    }

    @Test
    public void testGetMaxAge() {
        // Setup
        final int expectedResult = 0;

        // Run the test
        final int result = raceUnderTest.getMaxAge();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetAvailableStats() {
        // Setup
        final String[] expectedResult = new String[]{};

        // Run the test
        final String[] result = raceUnderTest.getAvailableStats();

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }
}
