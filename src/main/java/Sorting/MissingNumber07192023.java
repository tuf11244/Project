/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 * https://leetcode.com/problems/missing-number/
 */
package Sorting;
import java.util.Arrays;
/**
 *
 * @author parth
 */
public class MissingNumber07192023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[]arr = {3,0,1};
        int ans = missingNumber(arr);
        System.out.println(ans);
       
        // TODO code application logic here
    }
     public static int missingNumber(int[]arr){ 
        int i = 0;
        while( i < arr.length){
            int correctIndex  = arr[i];
            if( arr[i] < arr.length && arr[i] != arr[correctIndex]){
               int temp = arr[i];
               arr[i] = arr[correctIndex];
               arr[correctIndex] = temp;
            }
            else{
               i++;
            }
        } 
        System.out.println(Arrays.toString(arr));
        for(int index = 0; index < arr.length;index++){
            if(arr[index] != index){
                return index;
            }
        }           
     return arr.length;   
    }
    
}
