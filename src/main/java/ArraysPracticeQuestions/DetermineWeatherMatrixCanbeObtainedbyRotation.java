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
        //Transpose the Matrix 
        for(int i = 0; i < mat.length;i++){
            for(int j = i; j < mat[0].length;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        
        //Reverse the Row in the matrix 
        for(int i = 0; i < mat.length;i++){
            int left = 0;
            int right = mat[i].length - 1;
            
            while(left < right){
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
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
