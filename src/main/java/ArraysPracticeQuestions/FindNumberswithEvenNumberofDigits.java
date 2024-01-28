/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * @author parth
 */
public class FindNumberswithEvenNumberofDigits {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length;i++){
            if(isEven(nums[i])){
                count++;
            }
        }
        return count;
    }
    public static boolean isEven(int num){
        int count = 0;
        while(num > 0){
            int remainder = num%10;
            count++;
            num = num/10;
        }
        return count % 2 == 0;
    }
}
