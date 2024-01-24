/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.Arrays;

/**
 *https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
 * Date: 01/24/2024
 * @author parth
 */
public class CellswithOddValuesinMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       int[][] indices = {
           {1,1},
           {0,0}
       };
       oddCells(2,2,indices);
    }
    public static void oddCells(int m, int n, int[][] indices){
        int rowNumber = 0;
        int columnNumber = 0;
        int[][] arr = new int[m][n];
        for(int[] index : indices){
            rowNumber = index[0];
            columnNumber = index[1];
            
            for(int i = 0; i < m;i++){
                arr[i][columnNumber] = arr[i][columnNumber] + 1;
            }
            for(int j = 0; j < n;j++){
                arr[rowNumber][j] = arr[rowNumber][j] + 1;
            }
        }
        int count = 0;
        for(int row = 0; row < arr.length;row++){
            for(int column = 0; column < arr[0].length;column++){
                if((arr[row][column])%2!=0){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
