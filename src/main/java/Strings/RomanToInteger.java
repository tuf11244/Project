/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

/**
 *https://leetcode.com/problems/roman-to-integer/
 * Date: 12/15/2023
 * @author parth
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(romantoInt("MCMXCIV"));
    }

    public static int romantoInt(String S) {
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == 'I') {
                if (i + 1 < S.length() && (S.charAt(i + 1) == 'V' || S.charAt(i + 1) == 'X')) {
                    count -= 1; // Subtractive pair
                } else {
                    count += 1;
                }
            } else if (ch == 'V') {
                count += 5;
            } else if (ch == 'X') {
                if (i + 1 < S.length() && (S.charAt(i + 1) == 'L' || S.charAt(i + 1) == 'C')) {
                    count -= 10; // Subtractive pair
                } else {
                    count += 10;
                }
            } else if (ch == 'L') {
                count += 50;
            } else if (ch == 'C') {
                if (i + 1 < S.length() && (S.charAt(i + 1) == 'D' || S.charAt(i + 1) == 'M')) {
                    count -= 100; // Subtractive pair
                } else {
                    count += 100;
                }
            } else if (ch == 'D') {
                count += 500;
            } else if (ch == 'M') {
                count += 1000;
            }
        }
        return count;
    }
}
