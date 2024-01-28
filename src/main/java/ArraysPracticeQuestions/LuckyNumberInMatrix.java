/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Date: 01/27/2024
 *https://leetcode.com/problems/lucky-numbers-in-a-matrix/
 * @author parth
 */
public class LuckyNumberInMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Hello World");
        int[][] nums = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        List<Integer> result = magicNumber(nums);
        System.out.println(result);
    }
    public static List<Integer> magicNumber(int[][] nums) {
        List<Integer> list = new ArrayList<>();

        int row = nums.length;
        int column = nums[0].length;

        int[] rows = new int[row];
        int[] columns = new int[column];

        // Initialize rows and columns arrays
        Arrays.fill(rows, Integer.MAX_VALUE);
        Arrays.fill(columns, Integer.MIN_VALUE);

        // Find the minimum element in each row and maximum element in each column
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                rows[i] = Math.min(rows[i], nums[i][j]);
                columns[j] = Math.max(columns[j], nums[i][j]);
            }
        }

        // Check if the number is the smallest in its row and largest in its column
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (nums[i][j] == rows[i] && nums[i][j] == columns[j]) {
                    list.add(nums[i][j]);
                }
            }
        }
        return list;
    }
}
