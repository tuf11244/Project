/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DP;

/**
 *Date: 02/25/2025
 * https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
 * @author parth
 */
public class NumberofSubArrayswithOddSum {
    
    public static void main(String[] args){
        
    }
    
    public int numOfSubarrays(int[] arr) {
        int countOdd = 0, countEven = 1; // countEven starts at 1 for prefix sum = 0
        int prefixSum = 0, result = 0;
        int MOD = 1_000_000_007;
        
        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) { // Even prefix sum
                result = (result + countOdd) % MOD;
                countEven++;
            } else { // Odd prefix sum
                result = (result + countEven) % MOD;
                countOdd++;
            }
        }
        
        return result;
    }
}

