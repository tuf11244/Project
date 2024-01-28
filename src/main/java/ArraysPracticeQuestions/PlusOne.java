/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.Arrays;

/**
 * Date: 01/27/2024
 *https://leetcode.com/problems/plus-one/
 * @author parth
 */
public class PlusOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Hello World");
        int[] arr = {1,2,3};
        int[] result = plusOne(arr);
        System.out.println(Arrays.toString(result));
    }
    public static int[] plusOne(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i]++;
                return arr;
            } else {
                arr[i] = 0;
            }
        }
        // If we reach here, it means all digits were 9
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
