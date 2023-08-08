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
public class MergeSort08022023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {0,2,1,20,18};
        System.out.println(Arrays.toString(mergeSort(arr)));
   // TODO code application logic here
    }
    
    public static int[] mergeSort(int[] arr){
      if(arr.length == 1){
          return arr;
      }
      int middle = arr.length/2;
      
      int[] left = mergeSort(Arrays.copyOfRange(arr, 0, middle));
      int[] right = mergeSort(Arrays.copyOfRange(arr, middle, arr.length));
        return merge(left,right);    
    }
    
    public static int[] merge(int[]first, int[]second){
        int[] mix = new int[first.length + second.length];
        int i = 0; 
        int j = 0;
        int k = 0;
        while(i<first.length && j<second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }
            else{
                mix[k] = second[j];
                j++;
            }
        k++;
        }
        //It may be possible that one of the arrays is not fully traversed
        //Only one of the while loops from the below will run 
        //Copy the remaining elements
        while(i<first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j<second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
        
    }
    
    //In Place MergeSort
   
}
