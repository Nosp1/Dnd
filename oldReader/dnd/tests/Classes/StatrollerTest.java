package Classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
/*
The Statroller testclass.
This class intends to test whether the statrolling functions work,
and returns integers that are within the boundaries of the DnD environment and rule set.


@Author Trym Staurheim
 */
public class StatrollerTest {

    private Statroller statrollerUnderTest;

    @Before
    public void setUp() {
        statrollerUnderTest = new Statroller();
    }

    @Test
    public void testGetStatTitles() {
        // Setup
        final String[] expectedResult = new String[]{"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};

        // Run the test
        final String[] result = statrollerUnderTest.getStatTitles();

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testRollstats() {
        // Setup

        // Run the test
        Statroller.rollstats();

        // Verify the results
    }
/*
 Get RandInt() is suppose to generate a roll between 1 and 6 to simulate a 6-sided dice (d6).
 This test is to confirm whether GetRandInt() functions by asserting the minimum values and max values of the expected result.

 */
    @Test
    public void testGetRandInt()  throws Exception{

        final int expectedResult = Statroller.getRandInt();
        boolean isTrue = false;
        // Run the test

        final int result = Statroller.getRandInt();
        if (result < 7 && result > 0)
            isTrue = true;


        // Verify the results
        assertEquals(expectedResult < 7 && expectedResult > 0, isTrue);
        System.out.println(expectedResult + " " + result);


    }


    @Test
    public void testGetRoll() {
        boolean isTrue = false;
        final int expectedResult = Statroller.getRoll();

        // Run the test
        final int result = Statroller.getRoll();
        if (result < 19 && result > 2)
            isTrue = true;
        System.out.println(expectedResult + " " + result);
        // Verify the results
        assertEquals(expectedResult < 19 && expectedResult > 2, isTrue);


    }


}
