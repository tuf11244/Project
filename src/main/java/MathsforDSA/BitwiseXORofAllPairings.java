/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

/**
 *Date: 01/16/2025
 * https://leetcode.com/problems/bitwise-xor-of-all-pairings/
 * @author parth
 */
public class BitwiseXORofAllPairings {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int xorAllNums(int[] nums1, int[] nums2) {
    int ansxor = 0; // Variable to store the XOR result of all relevant elements.
    int n1 = nums1.length; // Get the size of the nums1 array.
    int n2 = nums2.length; // Get the size of the nums2 array.
    
    // If the length of nums1 is odd, every element of nums2 will contribute to the final XOR result.
    if (n1 % 2 == 1) { 
        // Traverse all elements of nums2 and compute their XOR.
        for (int i = 0; i < n2; i++) {
            ansxor ^= nums2[i]; // Update the result using XOR with the current element of nums2.
        }
    } 
    
    // If the length of nums2 is odd, every element of nums1 will contribute to the final XOR result.
    if (n2 % 2 == 1) {
        // Traverse all elements of nums1 and compute their XOR.
        for (int i = 0; i < n1; i++) {
            ansxor ^= nums1[i]; // Update the result using XOR with the current element of nums1.
        }
    }
    
    return ansxor; // Return the computed XOR result.
}

}
