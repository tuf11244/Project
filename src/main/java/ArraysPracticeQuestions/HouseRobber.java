/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 * Date: 01/25/2024
 *https://leetcode.com/problems/house-robber/
 * 
 * Note : This is question is DP question we solved it using Greedy Approach, 
 * this question is nothing but maximum sum of non adjacent elements 
 * https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 * Source : PepCoding 
 * @author parth
 */
public class HouseRobber {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {2,1,1,2};
        System.out.println(rob(arr));
    }
    public static int rob(int[] arr){
        int include = arr[0];
        int exclude = 0;
        
        for(int i = 1; i < arr.length;i++){
            int newInclude = exclude + arr[i];
            int newExclude = Math.max(include,exclude);
            
            include = newInclude;
            exclude = newExclude;
        }
        return Math.max(include, exclude);
    }
}
