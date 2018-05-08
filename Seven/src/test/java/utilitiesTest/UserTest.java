/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitiesTest;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utilities.User;

/**
 *
 * @author Roni
 */
public class UserTest {
    private User user;
    
    public UserTest() {
    }
    
    @Before
    public void setUp() {
        user = new User("Test", 1);
    }
    
    @Test
    public void createsUserWithRightName() {
        assertEquals("Test", user.getUsername());
    }
    
    @Test
    public void createsUserWithRightScore() {
        assertEquals(1, user.getScore());
    }
    
    @Test
    public void updatesScoreProperly() {
        user.setScore(0);
        assertNotSame(1, user.getScore());
    }
    
    @Test
    public void toStringIsProper() {
        assertEquals("Test   1", user.toString());
    }
    
    @Test
    public void compareWorksProperly() {
        User a = new User("a", 123);
        int smallerThan = user.compareTo(a);
        assertEquals(-122, smallerThan);
    }
    
    @Test
    public void equalsWorksProperly() {
        User a = new User("a", 123);
        User b = new User("a", 2);
        assertTrue(a.equals(b));
    }
}
