import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * The test class InputTest.
 *
 * @author  Dave Avis
 * @version 8.9.2018
 */
public class InputTest
{
    private OutputStream os;
    
    /**
     * Default constructor for test class InputTest.
     */
    public InputTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Tests the Input main method with fixed input.
     * 
     * I want to test with assertEquals and check the last line of the input, 
     * but I couldn't get it to work so I went with assertTrue. --DA
     */
    @Test
    public void testInput()
    {
        //Prepare to redirect output
        os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        String ls = System.getProperty("line.separator");
        
        //Prepare to redirect input
        ByteArrayInputStream in = new ByteArrayInputStream("Dave\n41\n2018\n".getBytes() );
        System.setIn( in );
        
        String[] args = {};
        Input.main(args);
        
        String outString = os.toString();
        String result = outString.substring( outString.indexOf("Dave") ).trim();
        
        assertEquals( "Incorrect output: ", "Dave was born in 1977", result);
        
        //Reset input and output
        System.setOut( System.out );
        System.setIn( System.in );
    }
}
