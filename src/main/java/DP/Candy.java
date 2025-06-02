/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DP;
import java.util.*;

/**
 * Date: 06/02/2025
 * Problem Link: https://leetcode.com/problems/candy/
 * This class solves the Candy distribution problem using a two-pass greedy approach.
 * 
 * Rules:
 * 1. Every child must get at least one candy.
 * 2. Children with a higher rating than their immediate neighbors must get more candies.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Author: Parth
 */
public class Candy {
    
    public static void main(String[] args) {
        // You can test the method here if needed.
    }

    public int candy(int[] ratings) {
        int n = ratings.length;

        // Step 1: Initialize an array where each child gets at least one candy
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        // Step 2: Traverse from left to right
        // If current rating is greater than previous, assign one more candy than previous
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        // Step 3: Traverse from right to left
        // If current rating is greater than next, ensure more candies than the next child
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // Only update if current candies are not already more
                if (arr[i] <= arr[i + 1]) {
                    arr[i] = arr[i + 1] + 1;
                }
            }
        }

        // Step 4: Sum up all candies to get the minimum total required
        int minCandies = 0;
        for (int i = 0; i < n; i++) {
            minCandies += arr[i];
        }

        return minCandies;
    }
}
