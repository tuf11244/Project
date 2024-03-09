/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.HashMap;

/**
 * Date: 03/08/2024
 *https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @author parth
 */
public class LongestSubstringwithoutRepeatingcharacters {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static  int lengthOfLongestSubstring(String s) {
    HashMap<Character,Integer> hm = new HashMap<>();
    int i = -1;
    int j = -1;
    int answer = 0;
    while(true){
        boolean f1 = false;
        boolean f2 = false;

        //acquire
        while(i < s.length()-1){
            f1 = true;
            i++;
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            if(hm.get(ch) == 2){
                break;
            }else{
                int length = i -j;
                if(length > answer){
                    answer = length;
                }
            }
        }

        //Release
        while(j < i){
            f2 = true;
            j++;
            char ch = s.charAt(j);
            hm.put(ch,hm.get(ch)-1);
            if(hm.get(ch) == 1){
                break;
            }
        }
        if(f1 == false && f2 == false){
            break;
        }
    }
    return answer;
}
}
