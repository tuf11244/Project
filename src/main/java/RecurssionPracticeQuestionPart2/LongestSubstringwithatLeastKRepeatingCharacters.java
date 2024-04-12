/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

/**
 *Date: 04/12/2024
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * @author parth
 */
public class LongestSubstringwithatLeastKRepeatingCharacters {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int longestSubstring(String s, int k) {
          return helper(0,s.length(),s,k);
    }
    public static int helper(int start, int end, String s, int k){
        //Creater a map 
        int[] map = new int[26];
        for(int i = start; i < end ;i++){
            map[s.charAt(i) - 'a']++;
        }

        for(int j = start; j < end; j++){
            int count = map[s.charAt(j)-'a'];
            if(count > 0 && count < k){
                int leftSide = helper(start,j,s,k);
                int rightSide = helper(j+1,end,s,k);
                return Math.max(leftSide,rightSide);
            }
        }
        return end - start;
    }
}
