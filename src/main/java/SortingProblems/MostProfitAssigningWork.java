/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;
import java.util.*;
/**
 *Date:  06/17/2024
 *https://leetcode.com/problems/most-profit-assigning-work/ 
* @author parth
 */
public class MostProfitAssigningWork {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
      public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        int[][] work = new int[n][2];

        for (int i = 0; i < n; i++) {
            work[i][0] = difficulty[i];
            work[i][1] = profit[i];
        }

        Arrays.sort(work, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);

        int sum = 0;
        int maxProfit = 0;
        int jobIndex = 0;

        for (int ability : worker) {
            while (jobIndex < n && ability >= work[jobIndex][0]) {
                maxProfit = Math.max(maxProfit, work[jobIndex][1]);
                jobIndex++;
            }
            sum += maxProfit;
        }

        return sum;
    }
}
