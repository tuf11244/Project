/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *https://leetcode.com/problems/reshape-the-matrix/
 * Date: 01/27/2024
 * @author parth
 */
public class ReshapeTheMatrxi {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int columns = mat[0].length;

        if((rows*columns)!=(r*c)){
            return mat;
        }
        int[][] result = new int[r][c];
        int rowNumber = 0;
        int columnNumber = 0;

        for(int i = 0; i < rows;i++){
            for(int j = 0; j < columns;j++){
                result[rowNumber][columnNumber] = mat[i][j];
                columnNumber++;
                if(columnNumber == c){
                    columnNumber  = 0;
                    rowNumber++;
                }
            }
        }
        return result;
    }
}
