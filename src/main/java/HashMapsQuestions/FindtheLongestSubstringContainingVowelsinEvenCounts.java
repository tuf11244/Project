/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;
import java.util.*;
/**
 *Date: 09/17/2024
 *https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 * @author parth
 */
public class FindtheLongestSubstringContainingVowelsinEvenCounts {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int findLongestSubString(String s){
        int[] vowels = new int[5];
        
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("00000", -1); //as before traversing on the string the initial state of all vowel count is 00000
        
        int maxLength = Integer.MIN_VALUE;
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == 'a'){
                vowels[0] = (vowels[0] + 1) % 2; //We can also use XOR instead +1  doing modulo with 2;
            }else if(s.charAt(i) == 'e'){
                vowels[1] = (vowels[1] + 1) % 2;
            }else if(s.charAt(i) == 'i'){
                vowels[2] = (vowels[2] + 1) % 2;
            }else if(s.charAt(i) == 'o'){
                vowels[3] = (vowels[3] + 1) % 2;
            }else if(s.charAt(i) == 'u'){
                vowels[4] = (vowels[4] + 1) % 2;
            }
            
            String current = "";
            for(int j = 0; j < 5;j++){
                    current = current + vowels[j];
            }
            
            if(hm.containsKey(current)){
                maxLength = Math.max(maxLength, i - hm.get(current));
                
            }else{
                hm.put(current,i);
            }
        }
        return maxLength;
    }
}
