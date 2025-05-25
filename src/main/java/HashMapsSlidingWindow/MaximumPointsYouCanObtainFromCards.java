/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HashMapsSlidingWindow;

/**
 *Date: 05/23/2025
 *https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 * @author parth
 */
public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        
    }
    public int maxScore(int[] cardPoints, int k) {
        int totalPoints = 0;
        for (int point : cardPoints) {
            totalPoints += point;
        }

        int windowSize = cardPoints.length - k;
        int currentSum = 0;
        int answer = 0;
        int j = 0;

        for (int i = 0; i < cardPoints.length; i++) {
            currentSum += cardPoints[i];

            if (i - j + 1 > windowSize) {
                currentSum -= cardPoints[j];
                j++;
            }

            if (i - j + 1 == windowSize) {
                answer = Math.max(answer, totalPoints - currentSum);
            }
        }

        // Edge case: take all cards (k == cardPoints.length)
        return k == cardPoints.length ? totalPoints : answer;
    }
}
