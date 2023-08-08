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
public class SelectionSortUsingRecurssion08022023 {

    /**
     * @param args the command line arguments
     */
    
    /* Selection Sort is a sorting technique, where we have 
     the max element in the array and swap it with last index
    now that the last index in array contains the maximum value we need to
    sort the remaining array the same way
    */
    public static void main(String args[]) {
         int[] arr = {5,-25,-89,-37,101};
         selectionSort(arr,arr.length,0,0);
         System.out.println(Arrays.toString(arr));
        // TODO code application logic here
    }
    
    public static void selectionSort(int[]arr, int row, int column, int max){
        if(row==0){
            return;
        }
        if(column < row){
            if(arr[column] > arr[max]){
                selectionSort(arr,row,column+1,column);
            }else{
                selectionSort(arr,row,column+1,max);
            }
        }
        else{
            int temp = arr[max];
            arr[max] = arr[row-1];
            arr[row-1] = temp;
            selectionSort(arr,row+1,column,max);
        }
    }
}
