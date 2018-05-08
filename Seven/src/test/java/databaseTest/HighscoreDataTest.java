package databaseTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template content, choose Tools | Templates
 * and open the template in the editor.
 */

import database.HighscoreData;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import utilities.User;

/**
 *
 * @author Roni
 */
public class HighscoreDataTest {

    HighscoreData hs;
    List<User> users;
    String content;
    File file;

    public HighscoreDataTest() {
    }

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        file = testFolder.newFile("tests.txt");
        content = file.toString();
        hs = new HighscoreData(content);
        users = hs.getAll();
    }

    @Test
    public void constructTest() {
        assertEquals(users, hs.getAll());
    }

    @Test
    public void findByName() {
        hs.create(new User("asd", 0));
        assertNull(hs.findByUsername("qwetq"));
        assertNotNull(hs.findByUsername("asd"));
    }

    @Test
    public void getTopThreeWorks() {
        hs.create(new User("UUS", 8));
        hs.create(new User("RKK", 321));
        hs.create(new User("EOS", 14));
        String expected = "RKK   321\n"
                + "EOS   14\n"
                + "UUS   8\n";
        assertEquals(expected, hs.getTopThree());
    }

    @Test
    public void createNewAdds1() {
        int start = hs.getAll().size();
        User temp = new User("Tem", 1);
        hs.create(temp);
        assertEquals(start + 1, hs.getAll().size());
    }
    
    @Test
    public void createDoesntIncreaseIfExists() {
        int start = hs.getAll().size();
        User temp1 = new User("Tem", 1);
        User temp2 = new User("Tem", 2);
        hs.create(temp1);
        hs.create(temp2);
        assertEquals(start + 1, hs.getAll().size());
    }
    
    @Test
    public void createUpdatesScoreIfAlreadyExistsAndNewBigger() {
        hs.create(new User("tes", 12));
        hs.create(new User("tes", 1111));
        assertEquals(1111, hs.findByUsername("tes").getScore());
    }
}
