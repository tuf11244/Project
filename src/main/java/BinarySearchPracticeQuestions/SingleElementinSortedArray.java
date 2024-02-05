/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 * Date: 02/04/2024
 *https://leetcode.com/problems/single-element-in-a-sorted-array/
 * @author parth
 */
public class SingleElementinSortedArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int singleNonDuplicate(int[] arr) {
        int low = 0;
        int end = arr.length - 1;
        if( arr.length == 1){
            return arr[0];
        }
        if(arr[0]!=arr[1]){
           return arr[0];
        }
        if(arr[arr.length-1]!=arr[arr.length-2]){
            return arr[arr.length-1];
        }
        
        while(low <= end){
            int mid = low + (end - low)/2;
            if(arr[mid]!= arr[mid-1] && arr[mid]!=arr[mid+1]){
                return arr[mid];
            }else if(arr[mid] == arr[mid-1]){
                //Left Count is the number of element from low to mid
                int leftCount = mid - low + 1;
                if(leftCount%2 == 0){
                    low = mid + 1;
                }else{
                    end = mid - 2;
                }
            }else if(arr[mid] == arr[mid+1]){
                int rightCount = end - mid + 1;
                if(rightCount%2 == 0){
                    end = mid - 1;
                }else{
                    low = mid + 2;
                }
            }
        }
        
        return -1;
    }
}
