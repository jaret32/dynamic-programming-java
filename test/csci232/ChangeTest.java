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
    public void testGet1() {
        int[] coins = {1, 5, 10, 12, 25};
        int change = 24;
        ArrayList<Integer> expResult = new ArrayList();
        expResult.add(12);
        expResult.add(12);
        ArrayList<Integer> result = Change.get(coins, change);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGet2() {
        int[] coins = {};
        int change = 0;
        ArrayList<Integer> expResult = new ArrayList();
        Exception e = assertThrows(IllegalArgumentException.class, () -> {  Change.get(coins,change); } );
		assertEquals("Array of size 0 is not allowed", e.getMessage());
    }
    
    @Test
    public void testGet3() {
        int[] coins = {1, 5, 10, 12, 25};
        int change = 55;
        ArrayList<Integer> expResult = new ArrayList();
        expResult.add(5);
        expResult.add(25);
        expResult.add(25);
        ArrayList<Integer> result = Coin.get(coins, change);
        assertEquals(expResult, result);
    }
    
}
