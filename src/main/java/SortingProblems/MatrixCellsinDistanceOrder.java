/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.Arrays;

/**
 * 01/16/2024
 *https://leetcode.com/problems/matrix-cells-in-distance-order/
 * @author parth
 */
public class MatrixCellsinDistanceOrder {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
                System.out.println("Hello World");
		int[][] ans = allCellsDistOrder(2,3,1,2);
		
		for(int[] a : ans){
		    System.out.println(Arrays.toString(a));
		}
    }
    public  static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
	    //Below array we will return 
        int[][] ans = new int[rows*cols][2];
        
        //Fill the Array with coordinates 
        for(int i = 0;  i < rows;i++){
            for(int j  = 0; j < cols;j++){
                //Bno is short for Box Number 
                //You have to visualize the 2D array as 1D array 
                int bno = i*cols + j;
                ans[bno][0] = i;
                ans[bno][1] = j;
            }
        }
        //Lamda Function to sort the coordinates from smaller to larger based on their relative distance from (rCenter,cCenter)
        Arrays.sort(ans,(a,b)->{
            int d1 = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int d2 = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
            
            return d1-d2;
        });
        
        return ans;
    }
}
