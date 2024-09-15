/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 09/14/2024
 * 
 * @author parth
 */
public class LetterCombinationsofPhone {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int soln(int n){
        int[][] dp = new int[n+1][10];
        //Columns are 10 because we can press any number from 0 to 9
        //Rows are n+1 because we have to include 0
        
        int[][] data= {
            {0,8},
            {1,2,4},
            {2,1,5,3},
            {3,2,6},
            {4,1,5,7},
            {5,2,4,6,8},
            {6,5,3,9},
            {7,4,8},
            {8,5,7,9,0},
            {9,6,8}   
        };
        
        for(int i = 1; i < dp.length;i++){
            for(int j = 0; j < dp[i].length;j++){
                if(i == 1){
                    dp[i][j] = 1;
                }else{
                  for(int keys : data[j]){
                      dp[i][j] = dp[i][j] + dp[i-1][keys];
                  }
                }
            }
        }
        
        int sum = 0;
        
        for(int j = 0; j <= 9;j++){
            sum = sum + dp[n][j];
        }
        return sum;
    }
}
