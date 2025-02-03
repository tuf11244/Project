/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/predict-the-winner/
 * Date: 01/31/2025
 * @author parth
 */
public class PredicttheWinner {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public boolean predictTheWinner(int[] nums) {

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for(int i =1 ; i < nums.length;i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        //Our dp is 2D dp of class type player 
        //player has two attributes score for playerA, score for playerB
        player [][] dp = new player[nums.length][nums.length];

        //We use GAP strategy to solve 
        for(int g = 0; g < dp.length;g++){
            for(int i = 0, j = g; j < dp.length;i++,j++){
                    if(g == 0){
                        //Only one element
                        //so playerA has score of nums[i];
                        //and playerB has score of 0 because no elements left
                        dp[i][j] = new player(nums[i],0);
                    }else if(g == 1){
                        //That means we have 2 elements to choose from
                        //playerA will get the max because he is starting first 
                       //playerB will get the leftover that is minimum
                        int playerA = Math.max(nums[i],nums[j]);
                        int playerB = Math.min(nums[i],nums[j]);

                        dp[i][j] = new player(playerA,playerB);
                    }else{

                        //Now we are dealing with more than 2 elements 
                        //So we have 2 options 
                        //pick element from left or pick element from right  and add our playerB score
                        int option1 = nums[i] + dp[i+1][j].playerB;
                        int option2 = nums[j] + dp[i][j-1].playerB;

                        //So we will choose max for playerA from the above options
                        int playerA = Math.max(option1,option2);
                        int playerB = 0; //to calculate the score for playerB we can use prefix sum array

                        if(i == 0){
                            playerB = prefixSum[j] - playerA;
                        }else{
                            playerB = prefixSum[j] - prefixSum[i-1] - playerA;
                        }

                        dp[i][j] = new player(playerA,playerB);
                    }
            }
        }
        //get the last element in the first row
        player Player = dp[0][dp.length-1];

        return Player.playerA >= Player.playerB;
        
    }
}
class player{
    int playerA;
    int playerB;

    public player(int playerA, int playerB){
        this.playerA = playerA;
        this.playerB = playerB;
    }
}
    

