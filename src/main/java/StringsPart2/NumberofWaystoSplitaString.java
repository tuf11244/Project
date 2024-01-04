/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 *https://leetcode.com/problems/number-of-ways-to-split-a-string/
 * Date: 12/20/2023
 * @author parth
 */
public class NumberofWaystoSplitaString {

    public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(numWays("10101"));
	}
	 public static int numWays(String s) {
        long ones = 0;
        long n = s.length();
        long MOD = 1_000_000_007;
        for (char c : s.toCharArray()){
            if (c == '1'){
                ones++;
            }
        }
        if (ones == 0){
            // Calculate the number of ways to choose two split points
        // Formula for combinations: C(n, k) = n! / (k! * (n - k)!) 
            return (int) ((((n - 1) * (n - 2)) / 2) % MOD);
        }
            if (ones % 3 != 0)
                return 0;
            long oneThird = ones / 3;
            ones = 0;
            long ways1 = 0;
            long ways2 = 0;
            for (char c : s.toCharArray()) {
                ones += c - '0';
                if (ones == oneThird) ways1++;
                if (ones == 2 * oneThird) ways2++;
            }
             System.out.println(ways1);
             System.out.println(ways2);
            return (int) ((ways1 * ways2) % MOD);
        }
}
