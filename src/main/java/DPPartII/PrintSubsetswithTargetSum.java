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
public class PrintSubsetswithTargetSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static boolean subsetSum(int[] arr, int target){
        
        boolean[][] dp = new boolean[arr.length + 1][target+1];
        
        for(int i = 0; i < dp.length;i++){
            for(int j = 0; j < dp[0].length;j++){
                
                //First cell 
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }
                //First Row
                else if(i == 0){
                    dp[i][j] = false;
                }
                //First Column 
                else if(j == 0){
                    dp[i][j] = true;
                }else{
                    
                    if(dp[i-1][j] == true){
                        dp[i][j] = true;
                    }else{
                        int value = arr[i -1];
                        if(j >= value){
                            if(dp[i-1][j - value] == true){
                                dp[i][j] = true;
                            }
                        }
                        
                    }
                }
            }
        }
        
        for(boolean[] row : dp){
            System.out.println(Arrays.toString(row));
        }
        
        Queue<coordinates> queue = new LinkedList<>();
        
        queue.add(new coordinates(arr.length,target,""));
        
        while(!queue.isEmpty()){
            coordinates rem = queue.poll();
            
            if(rem.i ==0 || rem.j == 0){
                System.out.println(rem.psf);
            }
            boolean exclude = dp[rem.i - 1][rem.j];
            
            
            if(exclude == true){
                queue.add(new coordinates(rem.i -1,rem.j,rem.psf));
            }
                    
            if(rem.j >= arr[rem.i - 1]){
              boolean include = dp[rem.i - 1][rem.j - arr[rem.i - 1]];  
               if(include == true){
                   queue.add(new coordinates(rem.i-1,rem.j - arr[rem.i - 1], rem.psf + (rem.i - 1)));
               }
            }
        
        }
                
        return dp[arr.length][target];
    }
}


class coordinates{
    int i;
    int j;
    String psf;
    
    public coordinates(int i, int j, String psf){
        this.i = i;
        this.j = j;
        this.psf = psf;
    }
}
