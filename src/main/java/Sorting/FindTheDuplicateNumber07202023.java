/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
package Sorting;
import java.util.Arrays;


/**
 *
 * @author parth
 */
public class FindTheDuplicateNumber07202023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[]arr = {1,1,2};
        int ans = missingNumber(arr);
        System.out.println(ans);
        // TODO code application logic here
    }
    public static int missingNumber(int[]arr){ 
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
        for(int index = 0; index < arr.length; index++){
            if(arr[index]!= index + 1)
                return arr[index];
        }  
        return -1;
    }
}
