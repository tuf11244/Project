/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 01/25/2024
 *https://leetcode.com/problems/check-if-it-is-a-good-array/
 * @author parth
 */
public class CheckIfItsGoodArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] nums = {3,6};
        System.out.println(isGoodArray(nums));
       
    }
    public static boolean isGoodArray(int[] nums){
        int answer = nums[0];
        for(int i = 1; i < nums.length;i++){
            answer = gcd(answer,nums[i]);
        }
        return answer == 1;
    }
    public static int gcd(int a, int b){
        if(a== 0){
            return b;
        }
        return gcd(b%a,a);
    }

}
