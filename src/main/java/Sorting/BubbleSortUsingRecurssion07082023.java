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
public class BubbleSortUsingRecurssion07082023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {5,4,3,2,1};
        bubbleSort(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
        // TODO code application logic here
    }
    
    public static void bubbleSort(int[]arr, int row, int column){
       //Base Case 
        if(row==0){
            return;
        }
       
       //Case to check if the adjacent item is greater than the previous item
       if(column < row){
           if(arr[column] > arr[column+1]){
               //Swap
               int temp = arr[column];
               arr[column] = arr[column+1];
               arr[column+1] = temp;
           }
           bubbleSort(arr,row,column+1);    
       }else{
           bubbleSort(arr,row-1,0);
       }
    }
}
