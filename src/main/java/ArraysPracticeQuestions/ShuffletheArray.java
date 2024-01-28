/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

import java.util.Arrays;

/**
 *https://leetcode.com/problems/shuffle-the-array/
 * Date: 01/28/2024
 * @author parth
 */
public class ShuffletheArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int[] shuffle(int[] nums, int n) {
        int[] answer = new int[2*n];
        int mid = nums.length/2;
        int[] left = Arrays.copyOfRange(nums,0,mid);
        int[] right = Arrays.copyOfRange(nums,mid,nums.length);
        boolean flag = true;
        int pointer1 =0;
        int pointer2 = 0;
        for(int i = 0; i < answer.length;i++){
            if(flag){
                answer[i] = left[pointer1];
                pointer1++;
                flag = false;
            }else{
                answer[i] = right[pointer2];
                pointer2++;
                flag = true;
            }
        }
        return answer;
    }
}
