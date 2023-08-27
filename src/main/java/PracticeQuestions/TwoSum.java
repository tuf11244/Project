/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PracticeQuestions;

import java.util.Arrays;

/**https://leetcode.com/problems/two-sum/
 * Date: 08/25/2022
 *
 * @author parth
 */
public class TwoSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {2,7,11,13};
        System.out.println(Arrays.toString(twoSum(arr,9)));
        // TODO code application logic here
    }
    
    public static int[] twoSum(int[] arr,int target){
        for(int i = 0; i < arr.length;i++){
            for(int j = i+1; j < arr.length;j++){
                if(arr[i] + arr[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
