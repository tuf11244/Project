/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 08/07/2024
 https://leetcode.com/problems/best-Team-with-no-conflicts/
 * @author parth
 */
public class MaximumSumIncreasingSubsequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] nums = {10,22,9,33,21,50,41,60,80,3};
        System.out.println(maxSumIncreasingSubsequence(nums));
    }
    
    public static int maxSumIncreasingSubsequence(int[] nums){
        int[] dp = new int[nums.length];
        int maxSum = 0;
        
        for(int i =0; i < dp.length;i++){
            int sum = 0;
            for(int j = 0; j < i;j++){
                if(nums[j] < nums[i]){
                    sum = Math.max(sum,dp[j]);
                }
            }
            dp[i] = nums[i] + sum;
            maxSum = Math.max(maxSum,dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return maxSum;
    }
    
    
    //https://leetcode.com/problems/best-Team-with-no-conflicts/
     public static int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[] dp = new int[n];
        
        Team arr[] = new Team[n];
        for(int i = 0; i < n;i++){
            arr[i] = new Team(scores[i],ages[i]);
        }
        
        Arrays.sort(arr);
        int maxScore = 0;
        for(int i = 0; i < arr.length;i++){
            int score = 0;
            for(int j = 0; j < i;j++){
                if(arr[j].score <= arr[i].score){
                    score = Math.max(dp[j],score);
                }
            }
            dp[i] = arr[i].score + score;
            maxScore = Math.max(maxScore,dp[i]);
        }
        
        return maxScore;
    }    
}

class Team implements Comparable<Team>{
    int score;
    int age;
    
    public Team(int score, int age){
        this.score = score;
        this.age = age;
    }

    @Override
    public int compareTo(Team o) {
        if(this.age == o.age){
            return this.score - o.score;
        }
        return this.age - o.age;
    }
}
