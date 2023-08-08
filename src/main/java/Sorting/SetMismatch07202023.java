/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 *  https://leetcode.com/problems/set-mismatch/
 */
package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author parth
 */
public class SetMismatch07202023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,2,3,3,4};
        System.out.println(setMisMatch(arr));
        //TODO code application logic here
          
    }
    
    public static ArrayList<Integer> setMisMatch(int[]arr){ 
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
        ArrayList<Integer> ans = new ArrayList<Integer>();
        System.out.println(Arrays.toString(arr));
        for(int index = 0; index < arr.length;index++){
            if(arr[index] != index + 1){
                ans.add(arr[index]);
                ans.add(index+1);
            }
        }           
     return ans;   
    }
}
