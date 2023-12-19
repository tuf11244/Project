/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

import java.util.ArrayList;

/**
 * Date: 12/19/2023
 *https://leetcode.com/problems/shifting-letters/;
 * @author parth
 */
public class ShiftingLetters {

    
    public static void main(String args[]) {
        int[] shifts = {3,5,9};
        System.out.println(shiftingLetters("abc",shifts));
        
    }
    public static String shiftingLetters(String s, int[] shifts){
       StringBuilder result = new StringBuilder();
        int totalShifts = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            totalShifts = (totalShifts + shifts[i]) % 26;
            char shiftedChar = (char) ((s.charAt(i) - 'a' + totalShifts) % 26 + 'a');
            System.out.println(shiftedChar);
            result.insert(0, shiftedChar); // Insert at the beginning of the StringBuilder
        }

        return result.toString();
    
    
    }
    
}
