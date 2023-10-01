/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Arrays;
import java.util.Arrays;

/**
 * Date: 09/30/2023
 *https://leetcode.com/problems/matrix-diagonal-sum/
 * @author parth
 */
public class MatrixDiagonalSum {

    public static void main(String args[]) {
        int[][] arr = {{1,2,3},
            {4,5,6},
            {7,8,9}};
        int sum = 0;
        for(int i = 0; i < arr.length;i++){
           sum = sum + arr[i][i]; //main diagonal 
           sum = sum + arr[i][arr.length-i-1]; //secondary diagonal 
        }
        //to check if the arr.length is odd or not 
        //if the matrix is odd subtract the second element as it was added twice
        if(arr.length % 2 == 1){
            sum = sum - arr[arr.length/2][arr.length/2];
        }
        System.out.println(sum);
    
    
    }
    
}
