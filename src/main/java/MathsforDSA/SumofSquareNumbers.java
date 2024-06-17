/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

/**
 *Date: 06/16/2024
 *https://leetcode.com/problems/sum-of-square-numbers/
 * @author parth
 */
public class SumofSquareNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static boolean judgeSquareSum(int c) {
        int a = 0;
        
        while(a <= Math.sqrt(c)){

            if(isValid(a,c)){
                return true;
            }

            a++;
        }

     return false;  
 }
    public static boolean isValid(int a, int c){
           int low = 0;
           int high = (int)Math.sqrt(c);

           while(low <= high){
            int mid = low + (high - low)/2;
            if(mid*mid == c - (a*a)){
                return true;
            }else if(mid * mid < c - (a * a)){
                    low = mid + 1;
            }else{
                    high = mid -1;
            }
           }
        return false;   
 }
}
