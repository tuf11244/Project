/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;
import java.util.Arrays;

/**
 *Date: 03/17/2024
 * https://leetcode.com/problems/array-of-doubled-pairs/
 * @author parth
 */
public class ArrayofDoubledPairs {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static boolean canReorderDoubled(int[] arr) {
        // If the array length is 0, return true
        if (arr.length == 0) {
            return true;
        }
        
        // Create a frequency map 
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // Corrected the put method usage
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        // Sort the array based on absolute values
        Integer[] ar = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ar[i] = arr[i];
        }
        
        // Corrected the comparator for sorting based on absolute values
        Arrays.sort(ar, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        for (Integer element : ar) {
            if (hm.get(element) == 0) {
                continue;
            }
            // Corrected the getOrDefault method usage
            if (hm.getOrDefault(2 * element, 0) == 0) {
                return false;
            } else {
                hm.put(element, hm.get(element) - 1);
                hm.put(2 * element, hm.get(2 * element) - 1);
            }
        }
        // Return true if all elements are successfully paired
        return true;
       
}
}
