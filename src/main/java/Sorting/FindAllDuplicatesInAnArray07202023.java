/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
package Sorting;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author parth
 */
public class FindAllDuplicatesInAnArray07202023 {

    /**
     * @param args the command line arguments
     * Insertion Sorting question
     */
    public static void main(String args[]) {
        int[] arr = {1,1,2};
        //duplicateNumbers(arr);
        System.out.println(duplicateNumbers(arr));
        
        // TODO code application logic here
    }
    public static ArrayList<Integer> duplicateNumbers(int[]arr){ 
        int i = 0;
        while( i < arr.length){
            int correctIndex  = arr[i] -1;
            if (arr[i] != arr[correctIndex]){
               int temp = arr[i];
               arr[i] = arr[correctIndex];
               arr[correctIndex] = temp;
            }
            else{
               i++;
            }
        } 
        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int index = 0; index < arr.length;index++){
            if(arr[index] != index + 1){
                ans.add(arr[index]);
            }
        }           
     return ans;   
    }
        
}
      
        

