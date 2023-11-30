/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *https://www.geeksforgeeks.org/sum-triangle-from-array/
 * Date: 11/29/2023
 * @author parth
 */
public class SumTrianglefromanArray {

    
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5};
        sumTrianglefromanArray(arr);
    }
    public static void sumTrianglefromanArray(int[] arr){
        if(arr.length < 1){
            return;
        }
        int[] temp = new int[arr.length-1];
        for(int i = 0; i < arr.length-1;i++){
            int x = arr[i] + arr[i+1];
            temp[i] = x;
        }
        sumTrianglefromanArray(temp);
        System.out.println(Arrays.toString(arr));
    }
   
    }

