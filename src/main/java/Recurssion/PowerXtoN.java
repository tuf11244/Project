/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;

/**
 *Date: 01/22/2025
 * https://leetcode.com/problems/powx-n/
 * @author parth
 */
public class PowerXtoN {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public double myPow(double x, int n) {
    // Convert 'n' to a long to handle edge cases, especially when 'n' is Integer.MIN_VALUE.
    // Integer.MIN_VALUE cannot be directly negated as its absolute value exceeds Integer.MAX_VALUE.
    long power = n;

    // If the power 'n' is negative, take the reciprocal of 'x' and make 'n' positive.
    if (power < 0) {
        power = -power; // Convert power to positive.
        x = 1 / x;      // Invert 'x' since a negative power means reciprocal.
    }

    // Use a helper method to calculate the power recursively using the fast exponentiation technique.
    return fastPow(x, power);
}

private double fastPow(double x, long n) {
    // Base case: Any number raised to the power 0 is 1.
    if (n == 0) {
        return 1.0;
    }

    // Recursively compute the power for 'n / 2' (integer division).
    // This exploits the property: x^n = (x^(n/2))^2.
    double half = fastPow(x, n / 2);

    // If 'n' is even, simply square the result from the recursive call.
    if (n % 2 == 0) {
        return half * half;
    } 
    // If 'n' is odd, multiply the squared result by 'x' to account for the leftover factor of 'x'.
    else {
        return half * half * x;
    }
}

}
