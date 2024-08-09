/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 08/01/2024
 *https://leetcode.com/problems/jump-game-ii/
 * @author parth
 */
public class PrintPathswithMinimumMoves {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] arr = {2,3,0,1,4};
        System.out.println(jump(arr));
    }
    
    public static int jump(int[] arr){
        
        Integer[] dp = new Integer[arr.length];
        dp[arr.length - 1] = 0; //We are the end 
        
        for(int i = arr.length - 2; i >= 0; i--){
            int min = Integer.MAX_VALUE;
            
            for(int j = 1; j <= arr[i] && i + j < arr.length ;j++){
                if(dp[i+j] != null){
                    min = Math.min(min,dp[i+j]);
                }
            }
            if(min != Integer.MAX_VALUE){
                dp[i] = min + 1;
            }
        }
        
        Queue<Step> queue = new LinkedList<>();
        queue.add(new Step(0,arr[0],dp[0],0+""));
        
        while(!queue.isEmpty()){
            
            Step rem = queue.poll();
            
            if(rem.jumps == 0){
                System.out.println(rem.psf + ".");
            }
            
            for(int j = 1; j <= rem.size && rem.index + j < arr.length;j++){
                int currentIdx = rem.index + j;
                if(dp[currentIdx] != null && dp[currentIdx] == rem.jumps - 1){
                    queue.add(new Step(currentIdx,arr[currentIdx],dp[currentIdx],rem.psf + "->" + currentIdx));
                }
            }
        }
        
        return dp[0];
    }
}

class Step{
    int index;
    int size;
    int jumps;
    String psf;
    
    public Step(int index, int size, int jumps, String psf){
        this.index = index;
        this.size = size;
        this.jumps = jumps;
        this.psf = psf;
    }
}
