/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 *
 * @author parth
 */
public class EqualSubstringswithinBudget {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       //equalSubstring("abcd","acde",0);
        System.out.println(equalSubstring("abcd","acde",0));
        
    }
    public static int equalSubstring(String s, String p, int maxCost){
        
        //This is a sliding window problem
        int answer = -1;
        int left = 0;
        int window = 0;
        
        for(int right = 0; right < s.length();right++){
            window = window + Math.abs(s.charAt(right) - p.charAt(right));
            while(window > maxCost){
                window = window - Math.abs(s.charAt(left) - p.charAt(left));
                left++;
            }
            //Length of the substring is right - left + 1;
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
        
        
    }
}
