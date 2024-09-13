/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 09/12/2024
 *https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
 * @author parth
 */
public class EggDrop {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int eggDrop(int floors, int eggs){
        
        int[][] dp = new int[eggs + 1][floors + 1];
        
        for(int i = 1; i < dp.length;i++){ //i  is for eggs rows
            for(int j = 1; j < dp[i].length;j++){ //j is for floors
                if(j==1){ //rRepresents when we have 1 floor
                    dp[i][j] = 1;
                }else if(i == 1){ //Repesents when we have 1 egg
                    dp[i][j] = j;
                }else{
                    int min = Integer.MAX_VALUE;
                    for(int curCol = j - 1, prevCol = 0; curCol >= 0; curCol--,prevCol++){
                        int val1 = dp[i][curCol];//egg survives
                        int val2 =dp[i-1][prevCol]; //egg breaks
                        
                        int val = Math.max(val1,val2);
                        min = Math.min(val,min);
                    }
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[eggs][floors];
    }
}
