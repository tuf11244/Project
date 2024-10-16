/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;
import java.util.*;
/**
 *Date: 10/15/2024
 *https://leetcode.com/problems/longest-happy-string/
 * @author parth
 */
public class LongestHappyString {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public String longestDiverseString(int a, int b, int c) {
        
        StringBuilder sb = new StringBuilder();
        PriorityQueue<CharFrequency> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        if (a > 0) pq.add(new CharFrequency('a', a));
        if (b > 0) pq.add(new CharFrequency('b', b));
        if (c > 0) pq.add(new CharFrequency('c', c));

        while (!pq.isEmpty()) {
            CharFrequency first = pq.poll();

            // Check if we can safely append this character
            int n = sb.length();
            if (n >= 2 && sb.charAt(n - 1) == first.ch && sb.charAt(n - 2) == first.ch) {
                // If appending the character would result in three consecutive chars, we need to pick another
                if (pq.isEmpty()) break;  // No other characters to pick, we must stop
                CharFrequency second = pq.poll();
                sb.append(second.ch);
                second.frequency--;
                
                if (second.frequency > 0) pq.add(second);
                pq.add(first);  // Put the first one back for future use
            } else {
                // Safe to append the character
                sb.append(first.ch);
                first.frequency--;
                
                if (first.frequency > 0) pq.add(first);
            }
        }

        return sb.toString();
    }
}

class CharFrequency implements Comparable<CharFrequency> {
    char ch;
    int frequency;

    public CharFrequency(char ch, int frequency) {
        this.ch = ch;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(CharFrequency other) {
        return this.frequency - other.frequency;
    }
}

