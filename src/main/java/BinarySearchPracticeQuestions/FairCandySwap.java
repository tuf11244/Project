/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

import java.util.Arrays;

/**
 *Date: 02/02/2024
 * https://leetcode.com/problems/fair-candy-swap/
 * @author parth
 */
public class FairCandySwap {

    
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    /**
     *   total(aliceCandies) - aliceCandies[i] + bobCandies[j] 
         equals
        total(bobCandies) - bobCandies[j] + aliceCandies[j]
        * 
        * 
        * Binary Search Intuition 
        * (aliceTotal - aliceSizes[i] + bobSizes[j]) == (bobTotal - bobSizes[j] + aliceSizes[i])
        * A_total - A[i] + B[j] = B_total - B[j] + A[i]
          B[j] + A_total - A[i] + B[j] = B_total + A[i]
          2 * B[j] + A_total - A[i] = B_total + A[i]
          2 * B[j] + A_total = B_total + A[i] + A[i]
          2 * B[j] + A_total = B_total + 2 * A[i]
          2 * B[j] = B_total - A_total + 2 * A[i]
          B[j] = (B_total - A_total + 2 * A[i]) / 2
     * @param args the command line arguments
     */
    
    
    //BruteForce Approach 
    public static int[] fairCandySwapBruteForce(int[] aliceSizes, int[] bobSizes) {
    int aliceTotal = 0;
    int bobTotal = 0;
    for (int candies : aliceSizes) aliceTotal += candies;
    for (int candies : bobSizes) bobTotal += candies;
    
    int m = aliceSizes.length, n = bobSizes.length;
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if ((aliceTotal - aliceSizes[i] + bobSizes[j]) == (bobTotal - bobSizes[j] + aliceSizes[i]))
          return new int[] { aliceSizes[i], bobSizes[j] };

    return new int[0];
  }
    
    
    
    //Binary Search Approach
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumAlice = 0;
        int sumBob = 0;
        for(int x : aliceSizes){
            sumAlice = sumAlice + x;
        }
        for(int y : bobSizes){
            sumBob = sumBob + y;
        }
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);
        
        for(int i = 0; i < aliceSizes.length;i++){
            int target = (sumBob + 2 * aliceSizes[i] - sumAlice)/2;
            if(helper(bobSizes, target)){
                return new int[] {aliceSizes[i],target};
            }
        }

        return new int[0];
    }
    public static boolean helper(int[] arr, int target){
        int low = 0;
        int end = arr.length - 1;
        while(low <= end){
            int mid = low + (end-low)/2;
            if(arr[mid] == target){
                return true;
            }else if(arr[mid] < target){
                low = mid +1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}
