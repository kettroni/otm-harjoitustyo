/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitiesTest;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utilities.GameMechanics;

/**
 *
 * @author Roni
 */
public class GameMechanicsTest {

    GameMechanics gameMec;

    @Before
    public void setUp() {
    }

    @Test
    public void testDivisibleBySeven() {

        Random rand = new Random();
        int temp = rand.nextInt(1000);
        int params = temp * 7;
        gameMec = new GameMechanics(params);
        assertTrue(gameMec.divSeven());
    }
    
    @Test
    public void testCheckIfNotSameTrue() {
        gameMec = new GameMechanics(1);
        assertTrue(gameMec.checkIfNotSame("2"));
    }
    
    @Test
    public void testCheckIfNotSameFalse() {
        gameMec = new GameMechanics(1);
        assertFalse(gameMec.checkIfNotSame("1"));
    }

    @Test
    public void testIncludesSeven() {
        String params = "17";
        gameMec = new GameMechanics(Integer.parseInt(params));
        assertTrue(gameMec.includesSeven());
    }

    @Test
    public void testAppearsTwice() {
        Random rand = new Random();
        int temp = rand.nextInt(1000);
        String params = "7" + temp + "7";
        gameMec = new GameMechanics(Integer.parseInt(params));
        assertTrue(gameMec.appearsTwice());
    }

    @Test
    public void startReturnsFalseWhenGuessDifferentThanCurrent() {
        gameMec = new GameMechanics(1);
        assertFalse(gameMec.start("2"));
    }

    @Test
    public void startReturnsTrueWhenBlankSpacedInDiv7() {
        gameMec = new GameMechanics(7);
        assertTrue(gameMec.start(""));
    }

    @Test
    public void startReturnsTrueWhenBlankSpacedInIncludes7() {
        gameMec = new GameMechanics(17);
        assertTrue(gameMec.start(""));
    }

    @Test
    public void startReturnsTrueWhenBlankSpacedInAppearsTwice() {
        gameMec = new GameMechanics(22);
        assertTrue(gameMec.start(""));
    }

    @Test
    public void getCauseIsRightWhenInclude7() {
        String params = "17";
        gameMec = new GameMechanics(Integer.parseInt(params));
        gameMec.start(params);
        String cause = "            YOU LOST               \n"
                + "-------------------------------\n"
                + "You Lost at " + params + ". \n"
                + "Caused by: " + "Includes 7";

        assertEquals(cause, gameMec.getCause());
    }

    @Test
    public void getCauseIsRightWhenDiv7() {
        String params = "14";
        gameMec = new GameMechanics(Integer.parseInt(params));
        gameMec.start(params);
        String cause = "            YOU LOST               \n"
                + "-------------------------------\n"
                + "You Lost at " + params + ". \n"
                + "Caused by: " + "Divisible By 7";

        assertEquals(cause, gameMec.getCause());
    }

    @Test
    public void getCauseIsRightWhenAppearsTwice() {
        String params = "22";
        gameMec = new GameMechanics(Integer.parseInt(params));
        gameMec.start(params);
        String cause = "            YOU LOST               \n"
                + "-------------------------------\n"
                + "You Lost at " + params + ". \n"
                + "Caused by: " + "Same appears twice";

        assertEquals(cause, gameMec.getCause());
    }

    @Test
    public void getCauseIsRightWhenGuessIsWrong() {
        String params = "1";
        gameMec = new GameMechanics(Integer.parseInt(params));
        gameMec.start("2");
        String cause = "            YOU LOST               \n"
                + "-------------------------------\n"
                + "You Lost at " + params + ". \n"
                + "Caused by: " + "\nYour input was: " + "2" + "\n"
                + "Expected value was: " + params;

        assertEquals(cause, gameMec.getCause());
    }
}
