/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 10/30/2024
 * https://leetcode.com/problems/minimum-total-distance-traveled/
 * @author parth
 */
public class MinimumTotalDistanceTravelled {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public long minimumTotalDistance(List<Integer> robot, int[][] factory){
        
        Collections.sort(robot); //Sort the robot Array 
        
        List<Integer> factoryPositions = new ArrayList<>(); //Flatten the factory Array 
        
        for(int[] f : factory){
            int position = f[0];
            int limit = f[1];
            
            for(int i = 0; i < limit;i++){
                factoryPositions.add(position);
            }
        }
        
        Collections.sort(factoryPositions); //Sort the factory Positions
        long[][] dp = new long[robot.size()][factoryPositions.size()];
        
        for(long[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(robot,factoryPositions,0,0,dp);
    }
    
    public long helper(List<Integer> robot, List<Integer> factory, int i, int j, long[][] dp){
         if(i >= robot.size()){
             return 0;
         }
         if(j >= factory.size()){
             return Long.MAX_VALUE;
         }
         if(dp[i][j] != -1){
             return dp[i][j];
         }
         
         long take = Math.abs(robot.get(i) - factory.get(j)) + helper(robot,factory,i+1,j+1,dp);
         
         long skip = helper(robot,factory,i,j+1,dp);
         
         dp[i][j] = Math.min(take, skip);
    }
    
    
}
