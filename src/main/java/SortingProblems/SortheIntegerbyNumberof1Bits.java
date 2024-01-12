/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.Arrays;

/**
 * Date: 01/12/2024
 *https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 * @author parth
 */
public class SortheIntegerbyNumberof1Bits {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        sortByBits(arr);
    }
    public static void sortByBits(int[] arr){
        int[] binaryBits = new int[arr.length];
        
        for(int i = 0; i < arr.length;i++){
            binaryBits[i] = count(Integer.toBinaryString(arr[i]));
        }
        System.out.println(Arrays.toString(binaryBits));
    }
    private static int count(String s){
        int count = 0;
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '1'){
                count++;
            }
        }
        return count;
        
    }
}
