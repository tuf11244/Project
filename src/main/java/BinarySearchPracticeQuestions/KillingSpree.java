/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

import java.util.Arrays;

/**
 * Date: 02/22/2024
 *https://www.geeksforgeeks.org/problems/killing-spree3020/
 * @author parth
 */
public class KillingSpree {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(killinSpree(10));
    }
   public static long killinSpree(long n)
    {
        if (n == 0)
            return 0;

        long low = 1, end = 100000, answer = 0, mid;
        while (low <= end) {
            mid = low + (end - low) / 2;

            long strength = helper(mid);
            if (strength > n) {
                end = mid - 1;
            } else {
                //strength <= n
                answer = mid;
                low = mid + 1;
            }
        }
        return answer;
    }

    public static long helper(long mid) {
        return (long) mid * (mid + 1) * (2 * mid + 1) / 6;  // Use long to avoid overflow
    }
}
