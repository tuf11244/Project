/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 *https://www.hackerrank.com/challenges/recursive-digit-sum/problem
 * Date: 11/23/2023
 * @author parth
 */
public class RecursiveSumDigit {

    public static void main(String args[]) {
        helper("172",3);
    }
    public static void helper(String n, int k){
        String answer = "";
        while(k>=1){
        answer = answer + n;
            k = k -1;
        }
        System.out.println(answer);
        SumDigit(answer);
    }
    private static void SumDigit(String answer){
        Long number = Long.parseLong(answer);
        Long digit = number;
        
        int sum = 0;
        while(number > 0){
            int remainder = (int) (number % 10);
            sum = sum + remainder;
            number = number/10;
        }
        System.out.println(sum);
        superSumDigit(sum);
    }
    private static void superSumDigit(int sum){
        if(sum < 10){
            System.out.println("The super Digit is " + sum);
            return;
        }
        int number = 0;
        while(sum > 0){
            int remainder = sum % 10;
            number = number + remainder;
            sum = sum/10;
        }
       superSumDigit(number);
        
    }
}
