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
        System.out.println(goodNumbers(50));
       // System.out.println(pow(2.0,-5));
        
       
    }
    public static int goodNumbers(long n){
        if(n<=0){
            return 0;
        }
        long even = (n/2 + n%2);
        long odd =  (n/2);
        
        
        return (int) ((int) (power(5, (int) even) * power(4, (int) odd)) % MOD) ;
    }
    public static long power(int base, int power){
      //  int answer = 1;
        if(power == 0){
            return 1;
        }
        return (base * power(base,power-1)) % MOD;
    }
    public static double pow(double x, int y){
        if(y == 0){
            return 1.0;
        }
        if(y < 0 ){
            return powHelper(x,y,1.0);
        }
        return x * pow(x,y-1);
    }
    private static double powHelper(double x, int y,double answer){
       if(y==0){
           return answer;
       }
        answer = answer * (1/x);
        return powHelper(x,y+1,answer);
    }
}
