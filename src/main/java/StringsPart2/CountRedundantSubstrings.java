/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 *Date: 07/26/2024
 *Below Question was asked in AMAZON OA
 * 
 * A substring of a string is redundant if length of substring i.e. L = |substring| = A*V + B*C 
 * where A and B are integers given to us and V and C are the number of vowels and consonants in the substring. 
 * Find count of all such redundant substrings of a given string. Assume that string has only lower case english alphabets.
    Eg: Given string “abbacc” , A = -1 , B = 2
     ans: 5
    “abb” [len = 3 , V=1, C =2] [-1*1 + 2*2]
    “bba”
    “bac”
    “acc”
    “abbacc” 
 * 
 * 
 * @author parth
 */
public class CountRedundantSubstrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int countRedundantSubstrings(String s, int A, int B) {
        int n = s.length();
        
        // Define vowels
        String vowels = "aeiou";
        
        // Initialize prefix sums
        int[] vowelCount = new int[n + 1];
        int[] consonantCount = new int[n + 1];
        
        // Populate the prefix sums
        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);
            vowelCount[i] = vowelCount[i - 1] + (vowels.indexOf(ch) >= 0 ? 1 : 0);
            consonantCount[i] = consonantCount[i - 1] + (vowels.indexOf(ch) < 0 ? 1 : 0);
        }
        
        int count = 0;
        
        // Iterate over all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int V = vowelCount[j + 1] - vowelCount[i];
                int C = consonantCount[j + 1] - consonantCount[i];
                int L = j - i + 1;
                
                if (L == A * V + B * C) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
