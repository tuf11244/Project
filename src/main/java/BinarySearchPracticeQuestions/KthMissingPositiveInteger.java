/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 * Date: 01/31/2024
 *https://leetcode.com/problems/kth-missing-positive-number/
 * @author parth
 */
public class KthMissingPositiveInteger {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int kthMissingNumber(int[] arr, int k){
        
        int low = 0;
        int high = arr.length -1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            int missing = arr[mid] - (mid + 1);
            
            if(missing < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        //Very Important ...learned from striver
        return low + k;
    }
    
}
