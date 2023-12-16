/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

/**
 *https://leetcode.com/problems/maximum-repeating-substring/
 * Date: 12/15/2023
 * @author parth
 */
public class MaximumRepeatingSubsequence {
  public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(maxRepeating("ababababc","ab"));
        
    }
    public static int maxRepeating(String sequence,String word){
        int count = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb)) {
            count++;
            sb.append(word);
        }
        return count;
    }    
  
}
