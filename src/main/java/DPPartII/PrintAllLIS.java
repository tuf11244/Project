/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date 08/07/2024
 * @author parth
 */
public class PrintAllLIS {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] nums = {10,22,42,33,21,50,41,60,80,3};
        
        lengthofLIS(nums);
    }
    
    public static int lengthofLIS(int[] nums){
        
        int[] dp = new int[nums.length];
        int answer = 0;
        for(int i = 0; i < dp.length;i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] <= nums[i]){
                   max = Math.max(dp[j], max);                    
            }
            }
            dp[i] = max + 1;
            answer = Math.max(dp[i],answer);
        
    }  
        
        Queue<P> queue = new LinkedList<>();
        for(int i = 0; i < dp.length;i++){
            if(dp[i] == answer){
               queue.add(new P(i,nums[i],answer,nums[i]+"")); 
            }
        }
        
        while(!queue.isEmpty()){
            P rem = queue.poll();
            
            if(rem.length == 1){
                System.out.println(rem.psf);
            }
            
            for(int j = 0; j < rem.index;j++){
                if(dp[j] == rem.length - 1 && nums[j] <= rem.value){
                    queue.add(new P(j,nums[j],dp[j], nums[j] + "-->" + rem.psf));
                }
            }
        }
       
      return answer;  
    }
}

class P{
    int index;
    int value;
    int length;
    String psf;
    
    public P(int index, int value, int length, String psf){
        this.index = index;
        this.value = value;
        this.length = length;
        this.psf = psf;
    }
}
