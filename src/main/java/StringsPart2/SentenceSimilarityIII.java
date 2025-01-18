/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 * This program solves the problem "Sentence Similarity III" from LeetCode:
 * https://leetcode.com/problems/sentence-similarity-iii/
 * The problem involves determining if one sentence can be made similar to another
 * by appending or deleting words from either the start or end of the sentence.
 *
 * Date: 12/20/2023
 * @author parth
 */
public class SentenceSimilarityIII {

    public static void main(String[] args) {
        // Test the function with a sample input
        System.out.println("Hello World");
        System.out.println(areSentencesSimilar("My name is Haley", "My Haley"));
    }

    public static boolean areSentencesSimilar(String s1, String s2) {
        // Split both sentences into arrays of words
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");

        // Identify the longer and shorter sentences (word arrays)
        String[] longer = arr1.length > arr2.length ? arr1 : arr2;
        String[] shorter = longer == arr1 ? arr2 : arr1;

        // Initialize pointers for prefix and suffix comparisons
        int i1 = 0; // Prefix pointer for the longer array
        int i2 = longer.length - 1; // Suffix pointer for the longer array
        int j1 = 0; // Prefix pointer for the shorter array
        int j2 = shorter.length - 1; // Suffix pointer for the shorter array

        // Match words from the start of both arrays
        while (i1 < longer.length && j1 < shorter.length && longer[i1].equals(shorter[j1])) {
            i1++; // Move to the next word in the longer array
            j1++; // Move to the next word in the shorter array
        }

        // Match words from the end of both arrays
        while (i2 >= 0 && j2 >= 0 && longer[i2].equals(shorter[j2])) {
            i2--; // Move to the previous word in the longer array
            j2--; // Move to the previous word in the shorter array
        }

        // The sentences are similar if all the words in the shorter array
        // are consumed (j2 < j1) after matching both prefixes and suffixes.
        return j2 < j1;
    }
}
