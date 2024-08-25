/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;
import java.util.*;
/**
 *Date: 08/25/2024
 *https://leetcode.com/problems/find-the-closest-palindrome/
 * @author parth
 */
public class FindtheClosestPalindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        
        System.out.println(nearestPalindromic("99"));
    }
    
    public static String nearestPalindromic(String n) {
        
        int mid = n.length()/2;
        
        long firstHalf = 0;
        
        if(n.length() % 2 == 0){
            firstHalf = Long.parseLong(n.substring(0, mid));
        }else{
            firstHalf = Long.parseLong(n.substring(0, mid+1));
        }
        
           /*
            Generate possible palindromic candidates:
            1. Palindrome by mirroring the first half.
            2. Palindrome by mirroring the first half + 1.
            3. Palindrome by mirroring the first half - 1.
            4. Handle edge cases by considering palindromes of the form 999...
               and 100...001
           */
           
           List<Long> possibleResults = new ArrayList<>();
           possibleResults.add(firstHalf(firstHalf,n.length() % 2 == 0));
           possibleResults.add(firstHalf(firstHalf + 1,n.length() % 2 == 0));
           possibleResults.add(firstHalf(firstHalf - 1,n.length() % 2 == 0));
           possibleResults.add((long) Math.pow(10, n.length() - 1) - 1);  // Edge case like 999...
           possibleResults.add((long) Math.pow(10, n.length()) + 1);      // Edge case like 100...001
           
           long Difference = Long.MAX_VALUE;
           
           long OriginalNum = Long.parseLong(n);
           String answer = null;
           
         //  System.out.println(possibleResults);
           
           for(int i = 0; i < possibleResults.size();i++){
               
               if(possibleResults.get(i) == OriginalNum){
                   continue; //we want return the closest 
               }
               
               if(Difference > Math.abs(possibleResults.get(i) - OriginalNum)){
                   Difference =  Math.abs(possibleResults.get(i) - OriginalNum);
                   answer = String.valueOf(possibleResults.get(i));     
               }
               else if(Difference == Math.abs(possibleResults.get(i) - OriginalNum)){
                   
                   long Option1 = Long.parseLong(answer);
                   long Option2 = possibleResults.get(i);
                   
                   long min = Math.min(Option1, Option2);
                   
                   answer = String.valueOf(min);
                   
               }
               
           }
        return answer;
        
    }
    
    private static Long firstHalf(Long left, boolean even){
        long result = left;
        
        if(even == false){ //n was of odd length
            left = left/10;
        }
        
        while(left > 0){
            int digit = (int) (left % 10);
            result = result * 10  + digit;
            left = left/10;
        }
        return result;
    }
    
}
