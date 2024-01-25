/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 * Date: 01/25/2024
 *https://leetcode.com/problems/house-robber/
 * @author parth
 */
public class HouseRobber {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {2,7,9,3,1};
        System.out.println(rob(arr));
    }
    public static int rob(int[] arr){
        int sumOdd = 0;
        int sumEven = 0;
        
        for(int i = 0; i < arr.length;i++){
            if(i%2== 0){
                sumEven = sumEven + arr[i];
            }else{
                sumOdd = sumOdd + arr[i];
            }
        }
        return Math.max(sumOdd, sumEven);
    }
}
