/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 * https://leetcode.com/problems/arranging-coins/
 *Date: 01/3/2024
 * @author parth
 */
public class ArrangingCoins {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    //Linear Time Complexity
    public static int arrangeCoins(int n) {
       int row = 1;
       while(row <= n){
           n = n - row;
           row++;
       }
       return row-1;
    }
    
    //O(LogN) Binary Search 
   public static int arrangeCoinsBS(int n) {
       long low = 0;
       long end = n;
        int answer = 0;
       while(low <= end){
            long mid = low + (end - low)/2;

            long sum = (mid * (mid  + 1))/2;

            if(sum <= n){
                answer =(int) mid;
                low = mid + 1;
            }else{
                 end = mid - 1;
            }
       }

       return answer;
    }
}
