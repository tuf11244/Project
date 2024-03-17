/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 * Date: 03/17/2024
 *https://leetcode.com/problems/fraction-to-recurring-decimal
 * @author parth
 */
public class FractiontoRecurrsingDecimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        fractiontoDecimal(4,2);
    }
    public static String fractiontoDecimal(int numerator, int denominator){
       if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();
        // Handle negative sign
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        long quotient = num / den;
        long remainder = num % den;

        result.append(quotient);

        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        HashMap<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            } else {
                map.put(remainder, result.length());
                remainder = remainder * 10;
                quotient = remainder / den;
                remainder = remainder % den;
                result.append(Math.abs(quotient));
            }
        }

        return result.toString();
    }
}
