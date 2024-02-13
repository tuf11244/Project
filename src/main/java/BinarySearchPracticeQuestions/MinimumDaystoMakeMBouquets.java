/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 * Date: 02/12/2024
 *https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * @author parth
 */
public class MinimumDaystoMakeMBouquets {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        System.out.println(minDays(bloomDay,2,3));
    }
    public static int minDays(int[] bloomDay, int m, int k){
        if(bloomDay.length < m * k){
            return -1;
        }
        int answer = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < bloomDay.length ;i++){
            min = Math.min(min,bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        while(min <= max){
            int mid = min + (max - min)/2;
            if(helper(bloomDay,m,k,mid)){
                answer = mid;
                max = mid -1;
            }else{
                min = mid + 1;
            }
        }
        return answer;
    }
  public static boolean helper(int[] bloomDay, int m, int k, int mid) {
    int bouquets = 0;
    int consecutiveFlowers = 0;

    for (int i = 0; i < bloomDay.length; i++) {
        if (bloomDay[i] <= mid) {
            consecutiveFlowers++;
            if (consecutiveFlowers == k) {
                bouquets++;
                consecutiveFlowers = 0;
            }
        } else {
            consecutiveFlowers = 0;
        }
    }

    return bouquets >= m;
}

}
