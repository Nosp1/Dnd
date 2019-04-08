package Classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/*
The Test class for skills. Currently in the works.
@Author Trym Staurheim
 */
public class SkillsTest {

    private Skills skillsUnderTest;

    @Before
    public void setUp() {
        skillsUnderTest = new Skills();
    }

    @Test
    public void testGetSkillsProficiency() {
        // Setup
        final int expectedResult = 0;

        // Run the test
        final int result = skillsUnderTest.getSkillsProficiency();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
