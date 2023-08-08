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
public class CyclicSortAlgorithm07192023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {3,1,4,5,2};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
       
        // TODO code application logic here
    }
    public static void cyclicSort(int[]arr){
        int i = 0;
        while( i < arr.length){
            int correctIndex  = arr[i] - 1;
            if(arr[i] != arr[correctIndex]){
              int temp = arr[i];
               arr[i] = arr[correctIndex];
               arr[correctIndex] = temp;
            }
            else{
               i++;
            }
        }
            
        
    }
}
