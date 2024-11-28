/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 11/27/2024
 * https://leetcode.com/problems/house-robber-ii/
 * @author parth
 */
public class HouseRobberII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int rob(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int include = nums[0];
        int exclude = 0;

        for(int i = 1; i < nums.length-1;i++){
            int newInclude = exclude + nums[i];
            int newExclude = Math.max(include,exclude);

            include = newInclude;
            exclude = newExclude;
        }

        int leavingtheFirstHome = Math.max(include,exclude);


        include = nums[1];
        exclude = 0;

        for(int i = 2; i < nums.length;i++){
            int newInclude = exclude + nums[i];
            int newExclude = Math.max(include,exclude);

            include = newInclude;
            exclude = newExclude;
        }

        int leavingtheLastHome = Math.max(include,exclude);


        return Math.max(leavingtheFirstHome,leavingtheLastHome);
        
    }
}
