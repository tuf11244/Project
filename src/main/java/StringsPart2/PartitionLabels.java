/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StringsPart2;
import java.util.*;
/**
 *Date: 03/29/2025
 * https://leetcode.com/problems/partition-labels/
 * @author parth
 */
public class PartitionLabels {
    public static void main(String[] args) {
        
    }
    public List<Integer> partitionLabels(String s) {

        int[] arr = new int[26]; // frequency map;

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] = arr[s.charAt(i) - 'a'] + 1;
        }

        List<Integer> list = new ArrayList<>();

        int i = 0;
        boolean partitionFound;
        
        while (i < s.length()) {
            int j = i + 1;  // Correctly initialize `j`
            partitionFound = false;

            while (j <= s.length()) {  // Ensure `j` can reach the end
                String substring = s.substring(i, j);

                if (isValidPartition(substring, arr)) {
                    list.add(substring.length());
                    partitionFound = true;
                    break;
                }
                j++;
            }

            if (partitionFound) {
                i = j;  // Move `i` to the next partition start
            } else {
                i++;  // Move forward safely if no partition was found
            }
        }
        return list;
    }

    public boolean isValidPartition(String temp, int[] arr) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < temp.length(); i++) {
            hm.put(temp.charAt(i), hm.getOrDefault(temp.charAt(i), 0) + 1);
        }

        for (char key : hm.keySet()) {
            int currentCount = hm.get(key);
            if (arr[key - 'a'] - currentCount > 0) {
                return false;
            }
        }

        return true;
    }
}
