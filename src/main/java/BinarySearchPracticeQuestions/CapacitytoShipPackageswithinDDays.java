/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 * Date: 01/08/2024
 *https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * @author parth
 */
public class CapacitytoShipPackageswithinDDays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
       int answer =  shipWithinDays(weights,days);
        System.out.println(answer);
    }
    public static int shipWithinDays(int[] weights, int days){
        int min = Integer.MIN_VALUE;
        int max = 0;
        int answer = -1;
        for(int i = 0; i < weights.length;i++){
            min = Math.max(weights[i], min);
            max = max + weights[i];
        }
        
        while(min <= max){
            int mid = min + (max - min)/2;
            if(helper(weights,mid) <= days){
                answer = mid;
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }
        return answer;
    }
    public static int helper(int[] weights,int mid){
       int currentDays = 1;
       int currentWeight = 0;

       for(int i = 0; i < weights.length;i++){
           if(currentWeight + weights[i] > mid){
               currentDays++;
               currentWeight = weights[i];
           }else{
               currentWeight = currentWeight + weights[i];
           }
       }
        return currentDays;
    }
}
