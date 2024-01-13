/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *Date : 01/11/2024
 * https://leetcode.com/problems/relative-sort-array/
 * @author parth
 */
public class RelativeSortArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
     public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Step 1: Find the maximum element in arr1
        int max = 0;
        for (int num : arr1) {
            max = Math.max(max, num);
        }

        // Step 2: Use counting sort to count frequencies of elements in arr1
        int[] count = new int[max + 1];
        for (int num : arr1) {
            count[num]++;
        }

        // Step 3: Custom sort arr1 based on arr2's order and frequency
        int index = 0;
        for (int num : arr2) {
            while (count[num] > 0) {
                arr1[index++] = num;
                count[num]--;
            }
        }

        // Step 4: Append remaining elements from arr1
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }

        return arr1;
    }
}
