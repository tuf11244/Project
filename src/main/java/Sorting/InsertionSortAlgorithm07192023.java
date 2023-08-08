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
public class InsertionSortAlgorithm07192023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[]arr = {5,4,3,2,1,0};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        // TODO code application logic here
    }
    public static void insertionSort(int[]arr){
        for(int i = 0; i <= arr.length - 2; i++){
            for(int j = i+1; j > 0; j--){
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
                else{
                    break;
                }
            }
        }
    }
}
