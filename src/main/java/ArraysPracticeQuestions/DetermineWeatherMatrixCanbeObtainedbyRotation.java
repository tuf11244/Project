/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 01/28/2024
 *https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
 * @author parth
 */
public class DetermineWeatherMatrixCanbeObtainedbyRotation {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
         int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] target = {{1,1,1},{0,1,0},{0,0,0}};
        System.out.println(findRotation(mat,target));
    }
    public  static boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        
        // Check if the matrices have the same dimensions
        if (mat.length != target.length || mat[0].length != target[0].length) {
            return false;
        }
        
        // Check for rotations: 90, 180, and 270 degrees clockwise
        for (int k = 0; k < 4; k++) {
            rotate(mat);
            if (isEqual(mat, target)) {
                return true;
            }
        }
        
        return false;
    }
    
    // Helper function to rotate the matrix 90 degrees clockwise
    private static void rotate(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[n - j - 1][i];
                mat[n - j - 1][i] = mat[n - i - 1][n - j - 1];
                mat[n - i - 1][n - j - 1] = mat[j][n - i - 1];
                mat[j][n - i - 1] = temp;
            }
        }
    }
    
    // Helper function to check if two matrices are equal
    private static boolean isEqual(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat1[i][j] != mat2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
