/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 *Date: 02/16/2024
 * https://leetcode.com/problems/split-array-largest-sum/
 * @author parth
 */
public class SplitArrayLargestSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,4,4};
        splitArray(arr,4);
    }
    public static void splitArray(int[] arr, int k){
        int answer = -1;
        int min = Integer.MIN_VALUE;;
        int max = 0;
        for(int i = 0; i < arr.length;i++){
            min = Math.max(min,arr[i]);
            max = max + arr[i];
        }
        if(k == 1){
             System.out.println(max);;
        }
        if (k > arr.length){
            System.out.println("There cannot be a solution ");
        }
        while(min <= max){
            int mid = min + (max - min)/2;
            if(helper(arr,k,mid)){
                answer = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        System.out.println(answer);
    }
    public static boolean helper(int[] arr, int k, int mid){
        int division = 1;
        int currentSum = 0;
        for(int i = 0; i < arr.length;i++){
            currentSum = currentSum + arr[i];
            if(currentSum > mid){
                division++;
                currentSum = arr[i];
            }
        }
        return division <= k;
    }
}
