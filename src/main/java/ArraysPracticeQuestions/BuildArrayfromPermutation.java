/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.Arrays;

/**
 * Date: 01/27/2024
 *https://leetcode.com/problems/build-array-from-permutation/
 * @author parth
 */
public class BuildArrayfromPermutation {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.println("Hello World");
		int[] nums = {5,0,1,2,3,4};
		int[] answer = buildArray(nums);
		System.out.println(Arrays.toString(answer));
    }
    public static int[] buildArray(int[] nums){
	    int[] answer = new int[nums.length];
	    for(int i = 0; i < answer.length;i++){
	       answer[i] = nums[nums[i]];
	    }
	    return answer;
	}
	
	//O(1) solution - no extra space
    public static void buildArrayOptimized(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] + (nums[nums[i]] % n) * n;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] / n;
        }
    }
}
