/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;
import java.util.*;
/**
 *Date: 06/27/2024
 * @author parth
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number ");
        int n = scanner.nextInt();
      //  int ans = fibonacci(n);
       // System.out.println(ans);
       for(int i = 0; i <= n;i++){
           System.out.println(fibonacci(i));
       }
        
    }
    public static int fibonacci(int n){
        return helper(n,new int[n+1]);
    }
    public static int helper(int n, int[] memo){
        if(n == 0 || n == 1){
            return n;
        }
        if(memo[n]!=0){
            return memo[n];
        }
        memo[n] = helper(n-1,memo) + helper(n-2,memo);
        
        return memo[n];
    }
}
