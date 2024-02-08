/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 *Date: 02/07/2024
 * https://leetcode.com/problems/find-peak-element/
 * @author parth
 */
public class FindPeakElement {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int findPeakElement(int[] arr) {
        int low = 0;
        int end = arr.length - 1;
        if(arr.length == 1){
            return 0;
        }
        while(low <= end){
            int mid = low + (end - low)/2;
            //Mid is not the first element and not the last element
            if(mid > 0 && mid < arr.length - 1){
                if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                    return mid;
                }else if(arr[mid-1] > arr[mid]){
                    end = mid -1;
                }else{
                    //arr[mid+1] > arr[mid]
                    low = mid + 1;
                }
            }
            //Mid is the first element
            else if(mid == 0){
                if(arr[mid] < arr[mid+1]){
                    return mid+1;
                }else{
                    //arr[mid] > arr[mid+1]
                    return mid;
                }
            }
            //mid is the last element
            else if(mid == arr.length - 1){
                if(arr[mid] > arr[mid -1]){
                    return mid;
                }else{
                    return mid-1;
                }
            }
        }
        return -1;
    }
}
