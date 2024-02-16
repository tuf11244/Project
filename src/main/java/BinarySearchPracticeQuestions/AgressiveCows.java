/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/problems/aggressive-cows/
 *Date: 02/15/2024
 * @author parth
 */
public class AgressiveCows {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] stalls = {1,2,4,8,9};
        System.out.println(solve(stalls,3));
    }
    
    public static int solve(int[] stalls, int k){
        if(k > stalls.length){
            return -1;
        }
        Arrays.sort(stalls);
        int min = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < stalls.length;i++){
            max = Math.max(stalls[i], max);
        }
        max = max- min;
        int answer = -1;
        while(min <= max){
            int mid = min + (max - min)/2;
            if(helper(stalls,k,mid)){
                answer = mid;
                min = mid + 1;
            }else{
                max = mid -1;
            }
        }
        return answer;
    }
   public static boolean helper(int[] stalls, int k, int mid) {

    int pointer = 0;
    int cows = 1;
    int start = stalls[pointer];
    for (int i = pointer + 1; i < stalls.length; i++) {
        if (stalls[i] - start >= mid) {
            cows++;
            pointer = i;
            start = stalls[pointer];
        }
    }
    return cows >= k;
}

}
