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
public class PrintPathsofKnapsack {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int knapSack(int[] values, int[] weight, int capacity){
        int[][] dp = new int[weight.length + 1][capacity+1];
        
        for(int i = 1; i < dp.length;i++){
            for(int j = 1; j< dp[0].length;j++){
                if(j >= weight[i-1]){
                    int remainingWgt = j - weight[i-1];
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][remainingWgt] + values[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        Queue<Paths> queue = new LinkedList<>();
        queue.add(new Paths(values.length,capacity,""));
        while(!queue.isEmpty()){
            Paths rem = queue.poll();
            
            if(rem.i == 0 || rem.j == 0){
                System.out.println(rem.psf);
            }else{
                int exclude = dp[rem.i - 1][rem.j];
                if(rem.j >= weight[rem.i - 1]){
                    int include =  dp[rem.i - 1][rem.j - weight[rem.i - 1]] + values[rem.i - 1];
                    
                    if(include == dp[rem.i][rem.j]){
                        queue.add(new Paths(rem.i- 1,rem.j - weight[rem.i -1], rem.psf + (rem.i - 1)));
                    }
                }
                
                if(exclude == dp[rem.i][rem.j]){
                    queue.add(new Paths(rem.i- 1,rem.j , rem.psf));
                }
            }
            
        }
        
        
        
        return dp[weight.length][capacity];
    }
}

class Paths{
    int i;
    int j;
    String psf;
    
    public Paths(int i, int j, String psf){
        this.i = i;
        this.j = j;
        this.psf = psf;
    }
   
}
