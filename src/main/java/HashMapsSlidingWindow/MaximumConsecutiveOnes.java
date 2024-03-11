/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.HashMap;

/**
 *Date: 03/11/2024
 * https://www.geeksforgeeks.org/maximum-consecutive-ones-formed-by-deleting-at-most-k-0s/
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 * https://leetcode.com/problems/max-consecutive-ones-ii/
 * @author parth
 */
public class MaximumConsecutiveOnes {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {0,1,1,0,1,0,1,1};
        System.out.println(maxConsecutiveOnes(arr,2));
    }
    public static int maxConsecutiveOnes(int[] arr, int k){
        int answer = 0;
        
        int j = -1;
        int count = 0;
        
        for(int i = 0; i < arr.length;i++){
            if(arr[i] == 0){
                count++;
            }
            while(count > k){
                j++;
                if(arr[j] == 0){
                    count--;
                }
            }
            int length = i - j;
            if(length > answer){
                answer = length;
            }
        }
       
        return answer;
        
    }
}
