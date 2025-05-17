package DP;
/*
Date: 05/09/2025
https://leetcode.com/problems/count-number-of-balanced-permutations/
*/
public class CountNumberofBalancedPermutations {
    int totalDigitSum;  // Total sum of digits in the input number
    int M = (int) 1e9 + 7;  // Modulo for large numbers
    long totalPermutationsPossible;  // Total base permutations with fixed even/odd positions
    int n;  // Length of the input number
    int[][][] dp;  // 3D DP array for memoization: digit index, even index count, current digit sum

    public static void main(String[] args) {
        CountNumberofBalancedPermutations obj = new CountNumberofBalancedPermutations();
        System.out.println(obj.countBalancedPermutations("123321"));  // Example input
    }

    public int countBalancedPermutations(String num) {
        totalDigitSum = 0;
        n = num.length();
        int[] freq = new int[10]; // Frequency of each digit (0 to 9)

        // Calculate total digit sum and frequency of each digit
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            totalDigitSum += digit;
            freq[digit]++;
        }

        // If total digit sum is odd, it's impossible to split into two equal sums
        if (totalDigitSum % 2 != 0) {
            return 0;
        }

        // Precompute factorials modulo M
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % M;
        }

        // Precompute modular inverses using Fermat's little theorem
        long[] inverseFactorial = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            inverseFactorial[i] = findPower(factorial[i], M - 2);  // inverse of factorial[i] mod M
        }

        // Calculate base permutations:
        // Half digits go to even indices and half to odd (for even/odd index positions)
        totalPermutationsPossible = (factorial[(n + 1) / 2] * factorial[n / 2]) % M;

        // Initialize memoization table with -1 (uncomputed states)
        dp = new int[11][(n + 1) / 2 + 1][totalDigitSum + 1];
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= (n + 1) / 2; j++) {
                for (int k = 0; k <= totalDigitSum; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        // Start recursive solution from digit 0, 0 even positions filled, 0 digit sum
        return solve(0, 0, 0, factorial, inverseFactorial, freq);
    }

    /**
     * Recursive function with memoization to explore all valid digit placements
     * @param digit Current digit being considered (0 to 9)
     * @param evenIndexCount Number of even index positions filled so far
     * @param currentSum Current digit sum of the even-indexed digits
     * @param factorial Precomputed factorial array
     * @param inverseFactorial Precomputed modular inverse factorial array
     * @param freq Frequency of digits
     * @return Number of valid balanced permutations from this state
     */
    public int solve(int digit, int evenIndexCount, int currentSum,
                     long[] factorial, long[] inverseFactorial, int[] freq) {

        // Base case: all digits from 0 to 9 considered
        if (digit == 10) {
            // Valid configuration if:
            // - currentSum equals half the total digit sum
            // - exactly half of digits placed in even positions
            if (currentSum == totalDigitSum / 2 && evenIndexCount == (n + 1) / 2) {
                return (int) totalPermutationsPossible;
            }
            return 0;
        }

        // Return already computed result
        if (dp[digit][evenIndexCount][currentSum] != -1) {
            return dp[digit][evenIndexCount][currentSum];
        }

        long ways = 0;

        // Try placing 0 to all available `digit` into even positions
        for (int count = 0; count <= Math.min(freq[digit], (n + 1) / 2 - evenIndexCount); count++) {
            int evenPosCount = count;
            int oddPosCount = freq[digit] - count;

            // Calculate the divisor = 1 / (evenPosCount! * oddPosCount!)
            long divisor = (inverseFactorial[evenPosCount] * inverseFactorial[oddPosCount]) % M;

            // Recursive call with updated states
            long value = solve(digit + 1,
                               evenIndexCount + evenPosCount,
                               currentSum + digit * evenPosCount,
                               factorial,
                               inverseFactorial,
                               freq);

            // Multiply by divisor to adjust for repeated digits
            ways = (ways + (value * divisor) % M) % M;
        }

        // Memoize and return
        dp[digit][evenIndexCount][currentSum] = (int) ways;
        return (int) ways;
    }

    /**
     * Modular exponentiation to compute (base^exponent) % M
     */
    public long findPower(long base, int exponent) {
        if (exponent == 0) return 1;
        long half = findPower(base, exponent / 2);
        long result = (half * half) % M;
        return (exponent % 2 == 0) ? result : (result * base) % M;
    }
}
