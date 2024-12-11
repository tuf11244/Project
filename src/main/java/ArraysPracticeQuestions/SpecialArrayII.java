/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 12/08/2024 POTD 
 * https://leetcode.com/problems/special-array-ii/
 * @author parth
 */
public class SpecialArrayII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int[] cumSum = new int[n];
        // cumSum[i] = total count of violating indices till index i
        cumSum[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) { // violating index
                cumSum[i] = cumSum[i - 1] + 1;
            } else {
                cumSum[i] = cumSum[i - 1];
            }
        }

        boolean[] result = new boolean[m];
        for (int i = 0; i < m; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if (cumSum[end] - cumSum[start] == 0) {
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
    
}
