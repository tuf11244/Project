package DP;
import java.util.*;

/**
 * Date: 06/27/2024
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 * @author parth
 */
public class ClimbingStairswithMinimumMoves {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the top floor number
        System.out.println("Please enter the top floor number ");
        int n = scanner.nextInt();

        // Input the jumps data
        int[] jumps = new int[n];
        System.out.println("Please enter the jumps data ");
        for (int i = 0; i < n; i++) {
            jumps[i] = scanner.nextInt();
        }

        // DP array to store minimum moves to reach the top from each stair
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0; // No moves needed when already at the top

        // Fill the dp array from the second last stair to the first stair
        for (int i = n - 1; i >= 0; i--) {
            if (jumps[i] > 0) {
                int min = Integer.MAX_VALUE;

                // Find the minimum moves required from the current stair
                for (int j = 1; j <= jumps[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(dp[i + j], min);
                    }
                }

                // If a valid move is found, update dp[i]
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }

        // Output the result
        System.out.println("The minimum moves are " + dp[0]);
    }
    
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        dp[n] = 0; //if you are on the top floor than the cost is 0
        dp[n - 1] = cost[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }

        return Math.min(dp[0], dp[1]);
    }
}
