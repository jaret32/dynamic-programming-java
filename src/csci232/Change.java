/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232;

import java.util.ArrayList;

/**
 *
 * @author Jaret
 */
public class Change {
    
    public static ArrayList<Integer> get(int[] coins, int amount) {
        int[] numCoins = new int[amount + 1];
        int[] lastCoin = new int[amount + 1];
        numCoins[0] = 0;
        lastCoin[0] = 0;
       
        
        int p = 0;
        for(int k = 0; k < coins.length; k++){
            p += coins[k];
        }
        
        //if array is empty, throws the exception
        if(p == 0){
            throw new IllegalArgumentException("Array of size 0 is not allowed");
        }
    
        
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            int used = 0;
            for (int coin: coins) {
                if (coin <= i) {
                    if (1 + numCoins[i - coin] < min) {
                        min = 1 + numCoins[i - coin];
                        used = coin;
                    }
                }
            }
            numCoins[i] = min;
            lastCoin[i] = used;
        }
        
        ArrayList<Integer> coinsUsed = new ArrayList();
        
        int last = lastCoin[amount];
        int remaining = amount;
        
        while (last != 0) {
            coinsUsed.add(last);
            remaining = remaining - last;
            last = lastCoin[remaining];
        }
        
        return coinsUsed;
    }
    
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
