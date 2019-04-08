package Classes;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
/*
Test class for creating new races. currently test the creation of a rogue race.
@Author Trym Staurheim
 */
public class RoleTest {
    private Role role;

    @Before
    public void setUp() throws Exception {
        role = new Role("Rogue", 8, null, 6) {
            @Override
            public String getRollerName() {
                return super.getRollerName();
            }
        };
    }


    @Test
    public void getRollerName() throws Exception {
        {
            assertEquals("Rogue", role.getRollerName());
        }
    }

    @Test
    public void setRollerName() throws Exception {
        assertNotEquals(null, "Rogue");

    }

    @Test
    public void getBaseHp() throws Exception {
        assertNotEquals(9, role.getBaseHp());

    }

    @Test
    public void setBaseHp() throws Exception {
        assertNotEquals("en string", "not a string", role.getBaseHp());
    }

    @Test
    public void getAvailableSkills() {
    }

    @Test
    public void setAvailableSkills() {
    }

    @Test
    public void getAmountOfSkills() {
    }

    @Test
    public void setAmountOfSkills() {
    }



}
