/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Sorting;

import java.util.Arrays;

/**
 *Date: 04/16/2024
 * @author parth
 */
public class CountSortAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr  = {3,4,1,3,2,5,2};
        countSort(arr);
      }
    public static void countSort(int[] arr){
        if(arr == null || arr.length <=1){
            return;
        }
        int max = -1;
        for(int i = 0; i< arr.length;i++){
            max = Math.max(max, arr[i]);
        }
        int[] countArr = new int[max+1];
        //Create a frequency Array
        for(int num : arr){
            countArr[num]++;
        }
        int index  = 0;
        for(int i = 0; i <= max;i++){
            while(countArr[i] > 0){
                arr[index] = i;
                index++;
                countArr[i]--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
