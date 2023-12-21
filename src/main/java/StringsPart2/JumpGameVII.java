/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 * Date: 12/20/2023
 *https://leetcode.com/problems/jump-game-vii/
 * @author parth
 */
public class JumpGameVII {

    public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(canReach("011010",2,3));
	}
    public static boolean canReach(String s, int minJump, int maxJump) {
         int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;

        int prefixSum = 0;

        for (int i = 1; i < n; i++) {
            if (i >= minJump) {
                prefixSum += dp[i - minJump];
            }
            if (i > maxJump) {
                prefixSum -= dp[i - maxJump - 1];
            }

            if (s.charAt(i) == '0' && prefixSum > 0) {
                dp[i] = 1;
            }
        }

        return dp[n - 1] == 1;
    }
}
