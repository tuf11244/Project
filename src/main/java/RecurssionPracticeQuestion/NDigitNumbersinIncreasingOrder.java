/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

import java.util.ArrayList;

/**
 *https://practice.geeksforgeeks.org/problems/n-digit-numbers-with-digits-in-increasing-order5903/1
 * Date: 11/21/2023
 * @author parth
 */
public class NDigitNumbersinIncreasingOrder {

    
    public static void main(String args[]) {
        System.out.println(increasingNumber(2));
    }
    public static ArrayList<Integer> increasingNumber(int N){
        ArrayList<Integer> answer = new ArrayList<>();
        
        //Base Case 
        if(N == 1){
            for(int i = 0; i <= 9;i++){
                answer.add(i);
                //return answer ;
            }
        }else{
            increasingNumberHelper(1,N,0,answer);
           // return answer;
        }
        return answer;
    }
    private static void increasingNumberHelper(int last, int N, int num, ArrayList<Integer> answer){
        //Base Case : When all the slots are filled
        if(N == 0){
          answer.add(num);
        return;
        }
        for(int i = last; i<=9;i++){
            int a = num*10 + i;
            increasingNumberHelper(i+1,N-1,a,answer);
        }
    }
    
    /* Can also be solved using backtracking
    private static void increasingNumberHelper(int last, int N, StringBuilder sb, ArrayList<Integer> answer){
        //Base Case : When all the slots are filled
        if(N == 0){
          answer.add(Integer.valueOf(sb.toString()));
        return;
        }
        for(int i = last; i<=9;i++){
                sb.append(i);
                increasingNumberHelper(i+1,N-1,sb,answer);
                sb.deleteCharAt(sb.length()-1);
        }
    }
    */
}
