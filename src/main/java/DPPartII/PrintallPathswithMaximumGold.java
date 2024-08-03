/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 08/02/2024
 * @author parth
 */
public class PrintallPathswithMaximumGold {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] arr = {
            {3,2,3,1},
            {2,4,6,0},
            {5,0,1,3},
            {9,1,5,1}
        };
        
        System.out.println(maxGold(arr));
    }
    
    public static int maxGold(int[][] arr){
        int[][] dp = new int[arr.length][arr[0].length];
        
        for(int j = dp[0].length - 1; j >= 0; j--){
            for(int i = dp.length - 1; i >= 0; i--){
                //Last Column
                if(j == dp[0].length - 1){
                    dp[i][j] = arr[i][j];
                }
                //First Row
                else if(i == 0){
                    dp[i][j] = arr[i][j] +  Math.max(dp[i][j+1], dp[i+1][j+1]);    
                }
                //Last Row
                else if(i == dp.length - 1){
                    dp[i][j] = arr[i][j] +  Math.max(dp[i][j+1], dp[i-1][j+1]);
                }
                else{
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], Math.max(dp[i-1][j+1], dp[i+1][j+1]));
                }
            }
        }
        int maxGold = 0;
        for(int i = 0; i < dp.length;i++){
            maxGold = Math.max(maxGold,dp[i][0]);
        }
        Queue<goldPath> queue = new LinkedList<>();
        
        for(int i = 0; i < dp.length;i++){
            if(dp[i][0] == maxGold){
               queue.add(new goldPath(i,0,i +""));
            }
        }
        
        while(!queue.isEmpty()){
            goldPath rem = queue.poll();
            
            if(rem.j == arr[0].length - 1){
                System.out.println(rem.psf);
            }
            else if(rem.i == 0){
                int max = Math.max(dp[rem.i][rem.j+1], dp[rem.i+1][rem.j+1]);
               
                if(max == dp[rem.i][rem.j+1]){
                    queue.add(new goldPath(rem.i,rem.j+1,rem.psf + "d2"));
                }else{
                    queue.add(new goldPath(rem.i+1,rem.j+1,rem.psf + "d3"));
                }
            }else if(rem.i == arr.length - 1){
                   int max = Math.max(dp[rem.i][rem.j+1], dp[rem.i-1][rem.j+1]);
               
                if(max == dp[rem.i][rem.j+1]){
                    queue.add(new goldPath(rem.i,rem.j+1,rem.psf + "d2"));
                }else{
                    queue.add(new goldPath(rem.i-1,rem.j+1,rem.psf + "d3"));
                }
            }else{
                  int max = Math.max(dp[rem.i][rem.j+1], Math.max(dp[rem.i-1][rem.j+1], dp[rem.i+1][rem.j+1]));
               
                if(max == dp[rem.i][rem.j+1]){
                    queue.add(new goldPath(rem.i,rem.j+1,rem.psf + "d2"));
                }else if(max == dp[rem.i-1][rem.j +1]){
                     queue.add(new goldPath(rem.i-1,rem.j+1,rem.psf + "d1"));
                }
                else{
                    queue.add(new goldPath(rem.i+1,rem.j+1,rem.psf + "d3"));
                }
            }    
        }
        return maxGold;
    }
}

class goldPath{
    int i;
    int j;
    String psf;
    
    public goldPath(int i, int j, String psf){
        this.i = i;
        this.j = j;
        this.psf = psf;
    }
}
