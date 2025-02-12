/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;
import java.util.*;
/**
 *Date: 02/11/2025
 *https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
 * @author parth
 */
public class MaxSumofPairwithEqualSumofDigits {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int maximumSum(int[] nums) {

        //PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer,PriorityQueue<Integer>> hm = new HashMap<>(); //HashMap would store the sum of digits of nums[i] and priorityQueue
        int maxSum = 0;

        for(int i = 0; i < nums.length;i++){
                int digitSum = getDigitSum(nums[i]);

                if(hm.containsKey(digitSum)){
                    PriorityQueue<Integer> pq = hm.get(digitSum);
                    pq.add(nums[i]);
                    hm.put(digitSum,pq);
                }else{
                    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                    pq.add(nums[i]);
                    hm.put(digitSum,pq);
                }
        }

        for(int key : hm.keySet()){
            if(hm.get(key).size() > 1){
                  PriorityQueue<Integer> pq = hm.get(key);
                  int currentSum = pq.poll() + pq.poll();
                  maxSum = Math.max(maxSum,currentSum);
            }
        }

        return maxSum == 0 ? -1 : maxSum;
    }

    public int getDigitSum(int num){
        int sum = 0;

        while(num > 0){
            int remainder = num % 10;
            sum = sum + remainder;
            num = num/10;
        }

        return sum;
    }
}

