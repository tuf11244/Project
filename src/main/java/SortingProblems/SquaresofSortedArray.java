/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.Arrays;

/**
 *Date: 01/11/2024
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * @author parth
 */
public class SquaresofSortedArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];

        for(int i = 0; i < nums.length;i++){
            answer[i] = nums[i] * nums[i];
        }
        Arrays.sort(answer);
        return answer;
    }
}
