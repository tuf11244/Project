/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Sorting;

import java.util.Arrays;

/**
 *Date: 04/17/2024
 * @author parth
 */
public class RadixSortAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {523,4,65,98,20,31,42,74,852,265,120,150,231,751,551,15};
        System.out.println(Arrays.toString(arr));
        radixSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));              
    }
    
    public static void radixSort(int[]arr,int n){
        int max = getMax(arr);
        
        for(int pos = 1; max/pos > 0; pos = pos * 10){
            countSort(arr,n,pos);
        }
    }
    public static void countSort(int[] arr, int n, int pos){
        // Initialize count array for digits 0 to 9
        int[] count = new int[10];
        int[] outputArray = new int[arr.length];

        // Count occurrences of digits
        for(int i = 0; i < arr.length; i++){
            count[(arr[i]/pos) % 10]++;
        }

        // Calculate cumulative count
        for(int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }

        // Build the output array
        for(int i = n - 1; i >= 0; i--){
            outputArray[count[(arr[i]/pos) % 10] - 1] = arr[i];
            count[(arr[i]/pos) % 10]--;
        }

        // Copy the elements back to the original array
        for(int i = 0; i < arr.length; i++){
            arr[i] = outputArray[i];
        }
}

    
    public static int getMax(int[] arr){
        int max = 0;
        for(int i = 0; i < arr.length;i++){
            max = Math.max(arr[i], max);
        }
        return max;
        
    }
}
