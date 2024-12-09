/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 01/24/2024
 * https://leetcode.com/problems/set-matrix-zeroes/
 * @author parth
 */
public class SetMatrixZeroes {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] arr = {
            {0,1,2,0},
            {3,4,5,2},
            {1,3,1,5}
        };
        print(arr);
        setZeroes(arr);
        System.out.println("");
        print(arr);
    }
    
    public static void setZeroes(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    boolean[] zeroRows = new boolean[rows];
    boolean[] zeroCols = new boolean[cols];

    // Mark rows and columns containing 0
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (matrix[i][j] == 0) {
                zeroRows[i] = true;
                zeroCols[j] = true;
            }
        }
    }

    // Set zeros in marked rows
    for (int i = 0; i < rows; i++) {
        if (zeroRows[i]) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    // Set zeros in marked columns
    for (int j = 0; j < cols; j++) {
        if (zeroCols[j]) {
            for (int i = 0; i < rows; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}

    public static void print(int[][] arr){
        for(int i = 0; i < arr.length;i++){
            for(int j = 0; j < arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    
    public static void setZeroesSpaceOptimized(int[][] arr){
        
        int colZero = 1;
        
        //int[] row --> matrix[0][..]
        //int[] col --> matrix[..][0]
        for(int i = 0; i < arr.length;i++){
            for(int j = 0; j < arr[0].length;j++){
                
                if(arr[i][j] == 0){
                    
                    //Mark the ith row 
                    arr[i][0] = 0;
                    //Mark the jth col 
                    if(j!= 0){
                        arr[0][j] =0;
                    }else{
                        colZero = 0;
                    }
                }
            }
        }
        
        
        //Step 2
        for(int i = 1; i < arr.length;i++){
            for(int j = 1; j < arr[0].length;j++){
                if(arr[i][0] ==0 || arr[0][j] == 0){
                    arr[i][j] = 0;
                }
            }
        }
        
        
        //First row
        if(arr[0][0] == 0){
            for(int j = 0; j < arr[0].length;j++){
                arr[0][j] = 0;
            }
        }
        
        
        //First Column
        if(colZero == 0){
            for(int i = 0; i < arr.length;i++){
                arr[i][0] = 0; 
            }
        }
        
    }
}
