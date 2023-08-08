/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;

/**
 *
 * @author parth
 */
public class BinarySearchUsingRecurssion07232023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,3,5,88,99,101};
        System.out.println(binarySearch(arr,101,0, arr.length-1));
        // TODO code application logic here
    }
    
    public static int binarySearch(int[]arr, int target, int start, int end){
        if(start > end){
            return -1;
        }
        int middle = start + (end - start)/2;
        if(arr[middle] == target){
            return middle;
        }
        if(arr[middle] < target){
            return binarySearch(arr, target,middle+1,end);
        }
        return binarySearch(arr, target,start, middle-1);
    }
}
