/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Date: 02/10/2024
 *https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/
 * @author parth
 */
public class MinimumAbsoluteDifferencewithConstraint {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {5,3,2,10,15};
        int x = 1;
        minAbsoluteDifference(arr,x);
    }
    //Fails 5 test cases 
    //Gives output Time Error
    //Passes 2008/2013 test cases 
    public static void minAbsoluteDifference(int[] arr, int x){
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length;i++){
            if(i+x < arr.length){
                 result = Math.min(result,Math.abs(binarySearch(arr,i+x,arr.length,i) - arr[i]));
            }else{
                continue;
            }
 
        }
        System.out.println("The lowest absolute difference is " +  result);
    }
    public static int binarySearch(int[] arr, int low,int end, int element){
       int[] copiedArray = Arrays.copyOfRange(arr, low,end);
       System.out.println(Arrays.toString(copiedArray));
       Arrays.sort(copiedArray);
     //  System.out.println(Arrays.toString(copiedArray));
       int start = 0;
       int answerStart = -1;
       int answerHigh = -1;
       int high = copiedArray.length - 1;
       if(copiedArray.length == 1){
           return copiedArray[0];
       }
      if(copiedArray.length == 0){
           return 0;
       } 
       while(start <= high){
           int mid = start + (high - start)/2;
           if(copiedArray[mid] == arr[element]){
                return arr[element];
           }else if(copiedArray[mid] < arr[element]){
               answerStart = mid;
               start = mid + 1;
           }else{
               answerHigh = mid;
               high = mid -1 ;
           }
       }
       if (answerStart == -1) {
            return copiedArray[answerHigh];
        } else if (answerHigh == -1) {
            return copiedArray[answerStart];
        }
        return Math.abs(copiedArray[answerHigh] - arr[element]) < Math.abs(copiedArray[answerStart] - arr[element]) ? copiedArray[answerHigh] : copiedArray[answerStart];
    }


    //TreeSet Solution 
    //TreeSet is advanced DSA
    //Passes all test cases 
    public static int minAbsoluteDiff(List<Integer> nums, int x){
        //Starting from the back 
        int start = nums.size() - 1- x;
        
        int j = nums.size() - 1;
        TreeSet<Integer> treeSet = new TreeSet<>();
        int result = Integer.MAX_VALUE;
        for(int i = start; i >= 0;i--){
            treeSet.add(nums.get(j));
            j--;
            int element = nums.get(i);
            int diff = Integer.MAX_VALUE;
            Integer lowerBound = treeSet.lower(element);
            Integer upperBound = treeSet.ceiling(element);
            if(lowerBound!=null){
                diff = Math.min(diff,element - lowerBound);
            }
            if(upperBound!=null){
                diff = Math.min(diff,upperBound - element);
            }
           result = Math.min(result, diff);
        }
        return result;
    }
    
}
