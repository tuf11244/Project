/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.Arrays;

/**
 *https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 * @author parth
 */
public class FindNUniqueIntegersSumUptoZero {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(Arrays.toString(sumZero(6)));
    }
    public static int[] sumZero(int n){
        if(n == 1){
            int[] arr = new int[n];
            //arr[0] = 0;
            return arr;
        }
        //if n is Odd 
        if(n%2!=0){
            int []arr= new int[n];
            arr[0] = -1*n/2;
            for(int i = 1; i < arr.length;i++){
                arr[i] = arr[i-1] + 1; 
            }
            return arr;
        }
        int k = 1;
        int[] arr = new int[n];
        arr[0] = -1 * n/2;
        for(int i = 1; i< arr.length;i++){
            arr[i] = arr[i-1] + 1;
            if(i >= n/2){
                arr[i] = k;
                k++;
            }
        }
        return arr;
    }
}
