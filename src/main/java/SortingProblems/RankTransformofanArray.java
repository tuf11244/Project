/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: 01/16/2024
 *https://leetcode.com/problems/rank-transform-of-an-array/
 * @author parth
 */
public class RankTransformofanArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int[] arrayRankTransform(int[] arr) {
         // Step 1: Sort the array and create a mapping
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        Map<Integer, Integer> rankMapping = new HashMap<>();
        int rank = 1;
        for (int num : sortedArr) {
            if (!rankMapping.containsKey(num)) {
                rankMapping.put(num, rank++);
            }
        }

        // Step 2: Assign ranks to each element
        int[] ranks = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ranks[i] = rankMapping.get(arr[i]);
        }

        return ranks;
    }
}
