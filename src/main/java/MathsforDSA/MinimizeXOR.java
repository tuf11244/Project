/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

/**
 *Date: 01/14/2025
 * https://leetcode.com/problems/minimize-xor/
 * @author parth
 */
public class MinimizeXOR {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int minimizeXor(int num1, int num2) {
        // Count the number of set bits (1-bits) in num2.
        // This represents how many bits we need to set in the result.
        int count = Integer.bitCount(num2); 
        
        // Variable to store the result number.
        int res = 0;

        // First, we attempt to cancel set bits of num1 from highest to lowest weight.
        // This ensures we minimize the XOR result by aligning high-weight bits first.
        for (int i = 31; i >= 0 && count > 0; i--) { // Loop over all 32 bits from MSB to LSB.
            if ((num1 & (1 << i)) != 0) { // Check if the i-th bit of num1 is set.
                count--;                // Decrement the count since we're using one set bit.
                res += (1 << i);        // Set the same bit in res to match num1.
            }
        }

        // After setting high-weight bits, we now fill in additional 1-bits, starting from LSB,
        // to meet the remaining number of required set bits.
        for (int i = 0; i < 32 && count > 0; i++) { // Loop over all 32 bits from LSB to MSB.
            if ((num1 & (1 << i)) == 0) { // Check if the i-th bit of num1 is NOT set.
                count--;                // Decrement the count since we're using one set bit.
                res += (1 << i);        // Set this bit in res.
            }
        }

        // After both loops, res will have the same number of set bits as num2,
        // and it will be designed to minimize num1 ^ res.
        return res;
    }
}
