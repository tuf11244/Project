/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

//https://leetcode.com/problems/path-with-maximum-gold/

import java.util.ArrayList;

public class PrimeNumbersafterPrimePSumS {
    public static void main(String[] args) {
        int N = 3;
        int P = 2;
        int S = 23;
        findNPrimesWithSum(N, P, S, new ArrayList<>());
    }

    public static void findNPrimesWithSum(int N, int P, int S, ArrayList<Integer> current) {
        // Base Case
        if (N == 0 && S == 0) {
            System.out.println(current);
            return;
        }

        for (int i = P + 1; i <= S; i++) {
            if (isPrime(i)) {
                current.add(i);
                findNPrimesWithSum(N - 1, i, S - i, current);
                current.remove(current.size() - 1);
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
