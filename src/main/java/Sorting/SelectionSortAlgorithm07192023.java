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
public class SelectionSortAlgorithm07192023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {5,-25,-89,-37,101};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        // TODO code application logic here
    }
    public static void selectionSort(int[]arr){
        for(int i = 0; i < arr.length; i++){
           //find the maximum item in the remaining array and swap with correct index
           int lastIndex = arr.length-i-1;
           int max = getMax(arr,0,lastIndex);
           swap(arr,max,lastIndex);
        }
    }
    
    public static int getMax(int[]arr, int start, int end){
        int max = start;
        for(int i = start; i <= end; i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }
    
    public static void swap(int[]arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
