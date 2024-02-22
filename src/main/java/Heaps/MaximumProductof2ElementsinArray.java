/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Heaps;

import java.util.Arrays;

/**
 *https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 * @author parth
 */
public class MaximumProductof2ElementsinArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,5,4,5};
        System.out.println(maxProduct(arr));
    }
    public static int maxProduct(int[] arr){
        int i = 0;
        int left = 2*i + 1;
        int right = 2*i + 2;
        int parent = (i-1)/2;
        //Build Heap 
        while(i < arr.length){
            if(parent >= 0 && left < arr.length && right < arr.length){
                if((arr[parent] >= arr[left]) && arr[parent] >= arr[right]){
                i++;
            }
                else if ((arr[parent] < arr[left]) || (arr[parent] < arr[right])){
                    swap(arr,parent,arr[left] > arr[right] ? left : right);
                }
           }else{
                i++;
            }
          
        }
        System.out.println(Arrays.toString(arr));
        return (arr[0] - 1) * Math.max(arr[1]-1,arr[2]-1);
    }
    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
