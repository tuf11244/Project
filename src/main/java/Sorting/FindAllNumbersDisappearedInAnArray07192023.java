/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
package Sorting;
import java.util.*;

/**
 *
 * @author parth
 */
public class FindAllNumbersDisappearedInAnArray07192023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[]arr = {4,3,2,7,8,2,3,1};
        System.out.println(missingNumber(arr));
        
        // TODO code application logic here
    }
     public static ArrayList<Integer> missingNumber(int[]arr){ 
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
                ans.add(index +1);
            }
        }           
     return ans;   
    }
}
