/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *
 * @author parth
 */
public class PrintAllPathswithMinimumCostPaths {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] arr = {
            {2,6,4,1,3},
            {9,1,1,0,5},
            {0,7,5,2,0},
            {4,3,0,4,7},
            {2,0,1,4,1}
        };
        
        System.out.println(minimumCostPath(arr));
        
    }
    
    public static int minimumCostPath(int[][] arr){
        int[][] dp = new int[arr.length][arr[0].length];
        
        for(int j = dp[0].length - 1; j >= 0; j--){
            for(int i = dp.length - 1; i >= 0; i--){
                
                if(i == dp.length - 1 && j == dp[0].length - 1){
                    dp[i][j] = arr[i][j];
                }
                else if(i == dp.length - 1){
                    dp[i][j] = arr[i][j] + dp[i][j+1];
                }
                else if(j == dp[0].length - 1){
                    dp[i][j] = arr[i][j] + dp[i+1][j];
                }
                else{
                    dp[i][j] = arr[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        
        Queue<Cost> queue = new LinkedList<>();
        queue.add(new Cost(0,0,""));
        
        while(!queue.isEmpty()){
            Cost rem = queue.poll();
            
            if(rem.i == dp.length - 1 && rem.j == dp[0].length - 1){
                System.out.println(rem.psf + ".");
            }
            else if(rem.i == dp.length - 1){
                queue.add(new Cost(rem.i,rem.j+1,rem.psf + "H"));
            }else if(rem.j == dp[0].length - 1){
                queue.add(new Cost(rem.i+1,rem.j,rem.psf + "V")); 
            }
            else{
                if(dp[rem.i+1][rem.j] > dp[rem.i][rem.j+1]){
                    queue.add(new Cost(rem.i,rem.j+1,rem.psf + "H"));
                }else{
                    queue.add(new Cost(rem.i+1,rem.j,rem.psf + "V"));   
                }
                
            }
        }
        
        return dp[0][0];
    }
}

class Cost{
    int i; 
    int j;
    String psf;
    
    public Cost(int i, int j, String psf){
        this.i = i;
        this.j = j;
        this.psf = psf;
    }
}
