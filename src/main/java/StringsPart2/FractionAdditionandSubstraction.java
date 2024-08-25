/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

package StringsPart2;

/**
 *https://leetcode.com/problems/fraction-addition-and-subtraction/
 *Date: 08/25/2024
 * @author parth
 */
public class FractionAdditionandSubstraction {

    public static void main(String[] args) {
        System.out.println(fractionAddition("-1/2+1/2+1/3")); // Expected output: "1/3"
        System.out.println(fractionAddition("1/3-1/2"));       // Expected output: "-1/6"
        System.out.println(fractionAddition("5/3+1/3"));       // Expected output: "2/1"
    }
    
    public static String fractionAddition(String expression) {
        int numerator = 0;  // Initialize the final numerator
        int denominator = 1; // Initialize the final denominator
        
        int i = 0;
        
        while (i < expression.length()) {
            int currentNum = 0;
            int currentDeno = 0;
            
            boolean isNegative = false;
            
            // Check if the current fraction is negative
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                isNegative = expression.charAt(i) == '-';
                i++;
            }
            
            // Build the numerator
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                int val = expression.charAt(i) - '0';
                currentNum = currentNum * 10 + val;
                i++;
            }
            
            i++; // Skip the division character '/'
            
            // Build the denominator
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                int val = expression.charAt(i) - '0';
                currentDeno = currentDeno * 10 + val;
                i++;
            }
            
            if (isNegative) {
                currentNum = -currentNum;
            }
            
            // Update the numerator and denominator using cross multiplication
            numerator = numerator * currentDeno + denominator * currentNum;
            denominator *= currentDeno;
            
            // Simplify the fraction by dividing by the greatest common divisor (GCD)
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        return numerator + "/" + denominator;
    }
    
    // Helper method to calculate the greatest common divisor (GCD) using the Euclidean algorithm
    // Helper method to calculate the greatest common divisor (GCD) using the Euclidean algorithm
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
