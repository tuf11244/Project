/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 *Date: 12/07/2024
 * https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
 * @author parth
 */
public class MinimumLimitofBallsinBag {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public int minimumSize(int[] nums, int maxOperations) {
        
      int min = 1;
      int max = -1;

      for(int num : nums){
          max = Math.max(max,num);
      }
      int answer = 0;
      while(min <= max){
        int mid = min + (max-min)/2;

        if(isValid(mid,nums,maxOperations)){
            answer = mid;
            max = mid -1;
        }else{
            min = mid + 1;
        }
      }
      
        return answer;
    }

    public boolean isValid(int mid, int[] nums, int maxOperations){
        int operations = 0;
        int totalOperations = 0;
        for(int num : nums){
            operations = num/mid;
            
            if(num % mid == 0){
                operations--;
            }
            totalOperations = totalOperations + operations;
        }

        return totalOperations <= maxOperations;
    }
}
