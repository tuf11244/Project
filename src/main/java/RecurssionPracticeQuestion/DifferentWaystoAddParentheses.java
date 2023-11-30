/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 *https://leetcode.com/problems/different-ways-to-add-parentheses/
 * Date: 11/29/2023
 * @author parth
 */
import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String leftPart = input.substring(0, i);
                String rightPart = input.substring(i + 1);

                List<Integer> left = diffWaysToCompute(leftPart);
                List<Integer> right = diffWaysToCompute(rightPart);

                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                result.add(l + r);
                                break;
                            case '-':
                                result.add(l - r);
                                break;
                            case '*':
                                result.add(l * r);
                                break;
                        }
                    }
                }
            }
        }

        // If there are no operators in the input, it's a single number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }

        return result;
    }

    public static void main(String[] args) {
        DifferentWaystoAddParentheses solution = new DifferentWaystoAddParentheses();
        List<Integer> result = solution.diffWaysToCompute("2*3-4*5");
        System.out.println(result); // Output: [0, 2]
    }
}
