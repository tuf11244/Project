/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

/**
 *Date: 09/23/2024
 *https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/
 * @author parth
 */

public class KthSmallestinLexicographicalOrder {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int findKthLargestNumber(int n, int k){
        
        int current = 1; // Start from '1' as the first valid number
        k--; // k-1 because we're treating the first number as index 0.
        
        while(k > 0){
            int countNumbers = countSteps(current, current+1, n);
            
            if(countNumbers <= k){
                current = current + 1; //meaning we are skipping this tree;
                k = k - countNumbers; // Skipping the elements under the current prefix tree
            }else{
                current = current * 10;
                k--; //This prefix tree has all the answers
                
            }
        }
        return current;
        
    }
    
    public static int countSteps(long curr, long next, int n){
        long countNumbers = 0;
        
        while(curr <= n){
            countNumbers = countNumbers + (next - curr);
            curr = curr * 10;
            next = next * 10;
            
            next = Math.min(next,(long)n+1); //so that next doesn't exceed more than n+1;
        }
        return (int)countNumbers;
    }
}
