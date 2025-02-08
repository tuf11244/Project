package RecurssionPracticeQuestionPart2;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    static int[] fact; // Array to store precomputed factorials

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9)); // Example test case
    }

    public static String getPermutation(int n, int k) {
        String answer = "";
        List<Integer> digits = new ArrayList<>();

        // Precompute factorials
        fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            digits.add(i);
        }

        return helper(answer, digits, n, k);
    }

    public static String helper(String answer, List<Integer> digits, int n, int k) {
        if (n == 1) {
            answer += digits.get(0);
            return answer;
        }

        // Calculate the index
        int index = k / fact[n - 1];

        if (k % fact[n - 1] == 0) {
            index--;
        }

        answer += digits.get(index);
        digits.remove(index);

        k -= fact[n - 1] * index;

        return helper(answer, digits, n - 1, k);
    }
}
