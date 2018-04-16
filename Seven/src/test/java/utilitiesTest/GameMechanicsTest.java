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
    public void testIncludesSeven() {
        Random rand = new Random();
        int temp = rand.nextInt(1000);
        String params = "7" + temp ;
        gameMec = new GameMechanics(Integer.parseInt(params));
        assertTrue(gameMec.includesSeven());
    }
    
    @Test
    public void testAppearsTwice() {
        Random rand = new Random();
        int temp = rand.nextInt(1000);
        String params = "7" + temp + "7" ;
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
    
}
