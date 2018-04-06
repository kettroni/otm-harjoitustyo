package SevenTest;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import seven.TextInterface;
/**
 *
 * @author Roni
 */
public class SevenTest {

    TextInterface ti;
    Scanner scanner;
    ByteArrayOutputStream baos;
    PrintStream ps;
    PrintStream old;
    
    @Before
    public void setUp() {
        ti = new TextInterface();
        
        
    }

    @Test
    public void givesErrorWithAWrongInputInMenu() {
        //defined to capture output
        baos = new ByteArrayOutputStream();
        ps = new PrintStream(baos);
        old = System.out;
        System.setOut(ps);
        
        String input = "asd\n" + "3";
        ti.scanner = new Scanner(input);
        ti.run();
        
        //sets back to normal
        System.out.flush();
        assertTrue(baos.toString().contains("Wrong input, try again"));
    }

}
