/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jaret
 */
public class ChangeTest {
    
    public ChangeTest() {
        
    }

    @Test
    public void testEmptyArray() {
        System.out.println("get");
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = Change.get();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
