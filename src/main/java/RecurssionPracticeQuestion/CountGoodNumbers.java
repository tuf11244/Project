/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 *https://leetcode.com/problems/count-good-numbers/
 * https://leetcode.com/problems/powx-n/
 * Date: 11/12/2023
 * @author parth
 */
public class CountGoodNumbers {

    public static long MOD = 1000_000_007;
    public static void main(String args[]) {
       // System.out.println(power(3,9));
       // System.out.println(goodNumbers(50));
       // System.out.println(pow(2.0,-5));
        
       
    }
 
    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;
        
        long result = (power(5, evenCount) * power(4, oddCount)) % MOD;
        return (int) result;
        
    }
    public long power(int base, long exponent){
        if(exponent == 0){
            return 1;
        }

        long half = (power(base,exponent/2)) % MOD;

        if(exponent % 2 == 0){
            return (half * half) % MOD;
        }
        return (half * half * base) % MOD;
    }
}
