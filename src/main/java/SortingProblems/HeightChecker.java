/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.Arrays;

/**
 * 01/12/2024
 *https://leetcode.com/problems/height-checker/
 * @author parth
 */
public class HeightChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int heightChecker(int[] heights) {
        int [] duplicateArray = Arrays.copyOfRange(heights,0,heights.length);
        Arrays.sort(duplicateArray);

        int count = 0;
        for(int i = 0; i < heights.length;i++){
            if(heights[i]!=duplicateArray[i]){
                count++;
            }
        }
        return count;
    }
}
