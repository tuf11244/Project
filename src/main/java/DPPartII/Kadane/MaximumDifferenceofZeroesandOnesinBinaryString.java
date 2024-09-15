/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.Kadane;

/**
 *Date: 09/14/2024
 * https://www.geeksforgeeks.org/maximum-difference-zeros-ones-binary-string/
 * @author parth
 */
public class MaximumDifferenceofZeroesandOnesinBinaryString {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int maxDifference(String s){
       int currentSum = 0;
        int max = Integer.MIN_VALUE; // We initialize max to the smallest possible value

        for (int i = 0; i < s.length(); i++) {
            int val = 0;

            if (s.charAt(i) == '0') {  // Compare with '0' (character)
                val = 1;  // '0' contributes positively
            } else if (s.charAt(i) == '1') {  // Compare with '1' (character)
                val = -1;  // '1' contributes negatively
            }

            // Update currentSum, reset it if it becomes negative
            currentSum += val;
            if (currentSum < 0) {
                currentSum = 0;
            }

            // Update the max value
            max = Math.max(max, currentSum);
        }

        // If max is still the smallest value, it means we didn't find any valid subarray, return -1
        return max > 0 ? max : -1;
    }
}
