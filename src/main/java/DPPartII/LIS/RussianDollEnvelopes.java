/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LIS;
import java.util.*;
/**
 *Date: 08/07/2024
 * https://leetcode.com/problems/russian-doll-envelopes/
 * @author parth
 */
public class RussianDollEnvelopes {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    //Time Complexity 0(n^2)
    //Passes 85/87 test cases on leetcode 
    //Need to learn how apply binary search for LIS
    public static int maxEnvelopes(int[][] envelopes){
        Envelope [] env = new Envelope[envelopes.length];
        
        for(int i = 0; i < envelopes.length;i++){
            env[i] = new Envelope(envelopes[i][0], envelopes[i][1]);
        }
        
        Arrays.sort(env);
        int[] dp = new int[envelopes.length];
        int answer = 0;
        for(int i = 0; i < envelopes.length;i++){
            int max = 0;
            for(int j = 0; j < i;j++){
                if(env[j].height < env[i].height && env[j].width < env[i].width){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] = max + 1;
            answer = Math.max(dp[i],answer);
        }
        return answer;
    }
    
    
    public static int maxEnvelopesUsingBS(int[][] envelopes){
         if (envelopes == null || envelopes.length == 0 || envelopes[0].length != 2) {
            return 0;
        }

        // Sort the envelopes: first by width in ascending order,
        // if the width is the same, sort by height in descending order
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        // Extract the heights from the sorted envelopes
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
        
        List<Integer> sorted = new ArrayList<>();

        for(int i = 0; i < height.length;i++){
            
            int index = lowerBoundBS(sorted,height[i]);
            
            if(index == -1){
                sorted.add(height[i]);
            }else{
                sorted.set(index, height[i]);
            }
        }
        
        
        return sorted.size();
    }
    
    public static int lowerBoundBS(List<Integer> sorted, int target){
        int low = 0;
        int end = sorted.size();
        int answer = -1;
        
        while(low < end){
            int mid = low + (end - low)/2;
            
            if(sorted.get(mid) < target){
                low = mid + 1;
            }else{
                answer = mid;
                end = mid;
            }
        }
        return answer;
    }
}
 class Envelope implements Comparable<Envelope>{
    int width;
    int height;
    
    public Envelope(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public int compareTo(Envelope o) {
        return this.width - o.width;
    }
}
