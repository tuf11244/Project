/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

/**
 * Date: 04/16/2024
 * Aditya Verma Logic
 *https://www.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1
 * @author parth
 */
public class LargestNumberinKSwaps {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(findMaximumNum("5477",2));
    }
    public static String findMaximumNum(String s,int k){
        int start = 0;
        StringBuilder ans = new StringBuilder();
       // System.out.println(ans);
        solve(start, new StringBuilder(s), k, ans);
        return ans.toString();
        
    }
    //String Builder s is where we are making changes 
    //String builder answer is empty 
    //and then we set answer to s
    private static void solve(int start, StringBuilder s, int k, StringBuilder ans) {
        //Base Condition 
        //We have either exhausted all the K's or our start pointer is at the last character 
        //Than we compare our answer string to s.string
        if (k == 0 || start == s.length()) {
            if (ans.toString().compareTo(s.toString()) < 0){
                ans.replace(0, ans.length(), s.toString());
                
            }
            return;
        }

        char maxVal = s.charAt(start);
        for (int j = start + 1; j < s.length(); j++) {
            maxVal = (char) Math.max(maxVal, s.charAt(j));
        }
        
        //We start the loop with i = start + 1 because it makes no sense to swap the char with itself
        for (int i = start + 1; i < s.length(); i++) {
            if (s.charAt(i) > s.charAt(start) && s.charAt(i) == maxVal) {
                swap(s, start, i);
                solve(start + 1, s, k - 1, ans);
                swap(s, start, i); // Backtrack
            }
        }

        solve(start + 1, s, k, ans); // no swapping as suitable swapping character wasn't found
        //so we move to the next pointer 
        //note that k has not been used
    }
    
    public static void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }
}
