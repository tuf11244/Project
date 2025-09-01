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
public class BubbleSortAlgorithm07182023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {5,4,-2,89,-78};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        // TODO code application logic here
    }
    public static void bubbleSort(int[]arr){
        for(int i = 0; i < arr.length ; i++){
            for(int j = 1; j < arr.length-i;j++){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
