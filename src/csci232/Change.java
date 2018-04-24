/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232;

import java.util.ArrayList;


public class Change {
    
    // dynamic programming change algorithm
    public static ArrayList<Integer> get(int[] coins, int amount) {
        // table for minimum number of coins for each value up to amount
        int[] numCoins = new int[amount + 1];
        // table for the last coin used for each value up to amount
        int[] lastCoin = new int[amount + 1];
        numCoins[0] = 0;
        lastCoin[0] = 0;
        
        // iterate through each value up to amount
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            int used = 0;
            // iterate through coins
            for (int coin: coins) {
                // if the coin is less than the value
                if (coin <= i) {
                    // and using the coin results in using less coins overall
                    if (1 + numCoins[i - coin] < min) {
                        // update the min number of coins
                        min = 1 + numCoins[i - coin];
                        // and the last coin used
                        used = coin;
                    }
                }
            }
            // set min number of coins for the value
            numCoins[i] = min;
            // and the last coin used for the value
            lastCoin[i] = used;
        }
        
        // create an array list to store used coins
        ArrayList<Integer> coinsUsed = new ArrayList();
        
        // get first coin
        int last = lastCoin[amount];
        int remaining = amount;
        
        // while there is more change
        while (last != 0) {
            // get next coin and redo
            coinsUsed.add(last);
            remaining = remaining - last;
            last = lastCoin[remaining];
        }
        
        return coinsUsed;
    }
    
    // utility function to print the two tables for testing
    public static void printArray(int[] arr) {
        String output = "[ ";
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                output += ", " + arr[i];
            }
            else {
                output += arr[i];
            }
        }
        output += " ]";
        System.out.println(output);
    }
    
    // utility function to print the coin list for testing
    public static void printList(ArrayList list) {
        String output = "[ ";
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                output += ", " + list.get(i);
            }
            else {
                output += list.get(i);
            }
        }
        output += " ]";
        System.out.println(output);
    }
    
}
