/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;
import java.util.*;
/**
 *Date: 07/11/2024
 *https://leetcode.com/problems/maximum-score-from-removing-substrings/
 * @author parth
 */
public class MaximumScoreFromRemovingSubstrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        
        // Determine the order of removal based on the points
        if (x >= y) {
            totalScore += maximumGainHelper(s, 'a', 'b', x);
            s = cleanString(s, 'a', 'b');
            totalScore += maximumGainHelper(s, 'b', 'a', y);
        } else {
            totalScore += maximumGainHelper(s, 'b', 'a', y);
            s = cleanString(s, 'b', 'a');
            totalScore += maximumGainHelper(s, 'a', 'b', x);
        }

        return totalScore;
    }
    
    private int maximumGainHelper(String s, char first, char second, int points) {
        int score = 0;
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && c == second) {
                stack.pop();
                score += points;
            } else {
                stack.push(c);
            }
        }

        return score;
    }
    
    private String cleanString(String s, char first, char second) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == first && c == second) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
