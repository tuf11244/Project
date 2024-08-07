/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

/**
 *Date: 08/06/2024
 *https://leetcode.com/problems/integer-to-english-words/
 * @author parth
 */
public class IntegerToWords {
    private static final String[] BELOW_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] HUNDRED = {"Hundred"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    
    public static void main(String[] args){
        System.out.println(numberToWords(1234567));
    }
   
    public static  String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        String word = "";
        while (num != 0) {
            if (num % 1000 != 0) {
                word = numberToWord(num % 1000) + THOUSANDS[i] + " " + word;
            }
            num /= 1000;
            i++;
        }
        return word.trim();
    }

    private static  String numberToWord(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return BELOW_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + numberToWord(num % 10);
        } else {
            return BELOW_20[num / 100] + " " + HUNDRED[0] + " " + numberToWord(num % 100);
        }
    }
    
 
}

