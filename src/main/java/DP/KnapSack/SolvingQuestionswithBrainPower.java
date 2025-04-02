/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DP.KnapSack;

/**
 *https://leetcode.com/problems/solving-questions-with-brainpower/
 * Date: 04/01/2025
 * @author parth
 */
public class SolvingQuestionswithBrainPower {
    
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];

        return helper(0,questions,dp);
        
    }
    public long helper(int index,int[][] questions, long[] dp){
        if(index >= questions.length){
            return 0;
        }

        if(dp[index] != 0){
            return dp[index];
        }
        long pick = (long) questions[index][0] + helper(index + questions[index][1] + 1, questions,dp);
        long skip = helper(index+1,questions,dp);

        dp[index] = Math.max(pick,skip);

        return dp[index];
    }

}