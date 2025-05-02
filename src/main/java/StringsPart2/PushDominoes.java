/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StringsPart2;

/**
 * Date: 05/02/2025
 * Problem: https://leetcode.com/problems/push-dominoes/
 * Author: Parth
 */

public class PushDominoes {

    public static void main(String[] args) {
        // Entry point – currently empty, you can add test cases here if needed
    }

    // Main method to simulate the final state of dominoes after pushing
    public static String pushDominoes(String dominoes) {
        int n = dominoes.length(); // Length of the original dominoes string
        
        // Create a new character array with padding at both ends
        char[] arr = new char[n + 2];
        arr[0] = 'L';          // Left padding to handle edge case at the start
        arr[n + 1] = 'R';      // Right padding to handle edge case at the end

        // Copy the input dominoes into the new array starting from index 1
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = dominoes.charAt(i - 1);
        }

        int i = 0; // Pointer to track the left boundary of a section
        int j = 1; // Pointer to find the right boundary (next non-dot character)

        // Process the array to solve all segments between two non-dot characters
        while (j < arr.length) {
            // Move 'j' until a non-dot character is found
            while (j < arr.length && arr[j] == '.') {
                j++;
            }

            // If there is a segment of dots between i and j, resolve the configuration
            if (j - i > 1) {
                solveConfiguration(arr, i, j);
            }

            // Move 'i' and 'j' forward
            i = j;
            j++;
        }

        // Build the final result string excluding the padded characters
        StringBuilder sb = new StringBuilder();
        for (int k = 1; k <= n; k++) {
            sb.append(arr[k]);
        }

        return sb.toString();
    }

    // Helper function to resolve a segment between two non-dot characters
    public static void solveConfiguration(char[] arr, int i, int j) {
        // Case 1: Both ends are 'L', all dominoes in between fall to the left
        if (arr[i] == 'L' && arr[j] == 'L') {
            for (int k = i + 1; k <= j - 1; k++) {
                arr[k] = 'L';
            }
        }
        // Case 2: Both ends are 'R', all dominoes in between fall to the right
        else if (arr[i] == 'R' && arr[j] == 'R') {
            for (int k = i + 1; k <= j - 1; k++) {
                arr[k] = 'R';
            }
        }
        // Case 3: Left end is 'L' and right end is 'R', no force acts in between
        else if (arr[i] == 'L' && arr[j] == 'R') {
            for (int k = i + 1; k <= j - 1; k++) {
                arr[k] = '.';
            }
        }
        // Case 4: Left end is 'R' and right end is 'L', forces meet in the middle
        else {
            int left = i + 1;
            int right = j - 1;
            while (left < right) {
                arr[left] = 'R'; // Domino falls rightwards
                arr[right] = 'L'; // Domino falls leftwards
                left++;
                right--;
            }
            // If there's a single domino in the middle, it remains upright ('.')
        }
    }
}
