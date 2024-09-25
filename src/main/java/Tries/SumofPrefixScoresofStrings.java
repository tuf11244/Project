/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Tries;
import java.util.HashMap;
/**
 *Date: 09/24/2024
 * https://leetcode.com/problems/sum-of-prefix-scores-of-strings
 * @author parth
 */
public class SumofPrefixScoresofStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}


class Solution {
    class TrieNode {
        HashMap<Character, TrieNode> children;
        int count; // Count of words with this prefix

        TrieNode() {
            children = new HashMap<>();
            count = 0;
        }
    }

    private TrieNode root;

    public int[] sumPrefixScores(String[] words) {
        root = new TrieNode();
        // Insert words into the Trie
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
                node.count++; // Increment prefix count
            }
        }

        int[] answer = new int[words.length];
        // Calculate prefix scores for each word
        for (int i = 0; i < words.length; i++) {
            answer[i] = calculatePrefixScore(words[i]);
        }
        return answer;
    }

    private int calculatePrefixScore(String word) {
        TrieNode node = root;
        int score = 0;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            score += node.count; // Add the count of words sharing this prefix
        }
        return score;
    }
}
