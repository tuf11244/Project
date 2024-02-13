/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 02/12/2024
 *https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 * @author parth
 */
public class FindtheSmallestDivisorGivenaThreshold {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      int[] arr = {1,2,5,9};
      smallestDivisor(arr,6);
    }
    public static void smallestDivisor(int[] arr, int threshold){
        int answer = -1;
        int min = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        while(min <= max){
            int mid = min + (max - min)/2;
            if(helper(arr,threshold,mid)){
                answer = mid;
                max = mid -1;
            }else{
                min = mid + 1;
            }
        }
        System.out.println(answer);
    }
    public static boolean helper(int[] arr, int threshold, int mid){
       // List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < arr.length;i++){
            sum = sum + Math.ceilDiv(arr[i],mid);
          //  list.add(Math.ceilDiv(arr[i],mid));
        }
//        System.out.println(list);
//        int sum = 0;
//        for(int element : list){
//           sum = sum + element; 
//        }
        return sum <= threshold;
    }
}
