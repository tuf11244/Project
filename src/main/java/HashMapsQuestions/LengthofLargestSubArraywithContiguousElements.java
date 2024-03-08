/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashSet;

/**
 *https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/
 * @author parth
 */
public class LengthofLargestSubArraywithContiguousElements {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       int[] arr = {9,2,7,5,6};
        System.out.println("the length of the contiguous subarray is :");
        System.out.println(lengthofContiguousElements(arr));
    }
    public static int lengthofContiguousElements(int[] arr){
        int maxLength = 0;
        
        
        for(int i=0; i < arr.length - 1;i++){
            int min = arr[i];
            int max = arr[i];
            HashSet<Integer> set = new HashSet<>();
            set.add(arr[i]);
            for(int j = i+ 1; j < arr.length;j++){
                if(set.contains(arr[j])){
                    break;
                }
                set.add(arr[j]);
                min = Math.min(arr[j],min);
                max = Math.max(arr[j], max);
                
                if(max - min == j - i){
                    int length = j - i + 1;
                    if(length > maxLength){
                        maxLength = length;
                    }
                }
            }
        }
        return maxLength;
    }
}
