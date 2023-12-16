/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

/**
 *Date: 12/15/2023
 *https://leetcode.com/problems/excel-sheet-column-title/
 *https://leetcode.com/problems/excel-sheet-column-number/
*/
public class ExcelSheet {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(convertToTitle(701));
        System.out.println(titleToNumber("ZY"));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber = columnNumber - 1;
            int remainder = columnNumber % 26;
            char ch = (char) (remainder + 'A');
            result.append(ch);
            columnNumber = columnNumber / 26;
        }

        return result.reverse().toString();
    }
    public static int titleToNumber(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int value = ch - 'A' + 1; // Map 'A' to 1, 'B' to 2, ..., 'Z' to 26
            result = result * 26 + value;
        }

        return result;
    }
}
