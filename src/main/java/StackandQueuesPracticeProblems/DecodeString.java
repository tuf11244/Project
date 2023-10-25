/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;


import java.util.Stack;

/**
 *Date: 10/24/2023
 * https://leetcode.com/problems/decode-string/
 * @author parth
 */
public class DecodeString {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
     public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(num);
                strStack.push(currentString.toString());
                currentString = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = new StringBuilder(strStack.pop());
                int repeatTimes = numStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}
