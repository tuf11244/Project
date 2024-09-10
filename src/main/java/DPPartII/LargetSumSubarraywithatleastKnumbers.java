/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 09/10/2024
 * https://www.geeksforgeeks.org/largest-sum-subarray-least-k-numbers/
 * @author parth
 */
public class LargetSumSubarraywithatleastKnumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int largestSumSubarray(int[] arr, int k){
        int[] kadane = new int[arr.length];
        
        int currentSum = arr[0];
        kadane[0] = currentSum;
        
        for(int i = 1; i < arr.length;i++){
            currentSum = Math.max(currentSum + arr[i], arr[i]);
            
            kadane[i] = currentSum;
        }
        
        int exactKSum = 0;
        
        // Step 2: Calculate the sum of the first subarray with exactly 'k' elements
        for(int i = 0; i < k;i++){
            exactKSum = exactKSum + arr[i];
        }
        // Initialize the answer with the sum of the first subarray of length 'k'
        int answer = exactKSum;
        for(int i = k; i < arr.length;i++){
            
            // Update the sum of subarray of length 'k' ending at index 'i'
            exactKSum = exactKSum + arr[i] - arr[i-k];
            
            // Take the maximum of: 
            // 1. Subarray with exactly 'k' elements
            // 2. Subarray with at least 'k' elements (using kadane[i-k])
            answer = Math.max(answer,Math.max(exactKSum,exactKSum + kadane[i-k]));
        }
        return answer;
    }
}
