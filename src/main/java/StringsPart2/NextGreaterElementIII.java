/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 *https://leetcode.com/problems/next-greater-element-iii/
 * Date: 12/20/2023
 * @author parth
 */
public class NextGreaterElementIII {

    public static void main(String[] args) {
        int n = 2143;
        int result = nextGreaterElement(n);
        System.out.println(result);
    }

    public static int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();

        int i = digits.length - 2;
        // Find the first pair of digits from the right such that digits[i] < digits[i + 1]
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such pair is found, the number is already the largest possible
        if (i == -1) {
            return -1;
        }

        // Find the smallest digit to the right of digits[i] that is larger than digits[i]
        int j = digits.length - 1;
        while (j >= 0 && digits[j] <= digits[i]) {
            j--;
        }

        // Swap digits[i] and digits[j]
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Reverse the digits to the right of digits[i]
        reverse(digits, i + 1, digits.length - 1);

        // Convert the modified array back to an integer
        long result = Long.parseLong(new String(digits));

        // Check if the result is within the 32-bit signed integer range
        return (result > Integer.MAX_VALUE) ? -1 : (int) result;
    }

    private static void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
