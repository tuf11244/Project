/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 *Date: 02/08/2024
 * https://leetcode.com/problems/koko-eating-bananas/
 * @author parth
 */
public class KokoEatingBananas {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] piles = {3,6,7,11};
        System.out.println(minEatingSpeed(piles,8));
    }
    public static int minEatingSpeed(int[]piles, int h){
        int min = 1;
        int max = 0;
        int answer = -1;
        
        for(int i = 0; i < piles.length;i++){
            max = Math.max(max, piles[i]);
        }
        while(min <= max){
            int mid = min + (max - min)/2;
            if(helper(piles,mid) <= h){
                answer = mid;
                max = mid-1;
            }else{
                min = mid + 1;
            }
        }
        return answer;
    }
    public static int helper(int[] piles, int mid){
        int hours = 0;
        for(int i = 0; i < piles.length;i++){
            hours = (int) (hours + Math.ceil((double)(piles[i]/(double)(mid))));
    }
    return hours;
    }
}
