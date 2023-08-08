/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Sorting;
import java.util.Arrays;

/**
 *
 * @author parth
 */
public class QuickSort08042023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] nums = {10,1,19,22,51};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
        
        
        // TODO code application logic here
    }
    public static void quickSort(int[] arr,int low, int high){
        if(low >= high){
            return;
        }
        int start = low; 
        int end = high;
        int middle = start + (end-start)/2;
        int pivot = arr[middle];
        while(start <= end){
            //also a reason why if the arrays is sorted it will not swap
            while(arr[start] < pivot){
                start++;
            }
            while(arr[end] > pivot){
                end--;
            }
            
            if(start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        
        //now the pivot is at the correct index
        quickSort(arr,low,end);
        quickSort(arr,start,high);
    }
}
