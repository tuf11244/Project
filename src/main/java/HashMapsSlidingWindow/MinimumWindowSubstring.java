/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.HashMap;

/**
 *Date: 03/07/2024
 * https://leetcode.com/problems/minimum-window-substring/
 * @author parth
 */
public class MinimumWindowSubstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(minimumWindowSubstring("ADOBECODEBANC","ABC"));
    }
    public static String minimumWindowSubstring(String t, String s){
        String answer = "";
        //Create a Frequency map for String s;
        HashMap<Character,Integer> hm2 = new HashMap<>();
        for(int i = 0; i < s.length();i++){
            if(hm2.containsKey(s.charAt(i))){
                int oldFrequency = hm2.get(s.charAt(i));
                hm2.put(s.charAt(i),oldFrequency+1);
            }else{
                hm2.put(s.charAt(i),1);
            }
        }
        
        int matchCount = 0;
        int desiredmatchCount = s.length();
        
        //Frequency map for String t
        HashMap<Character,Integer> hm1 = new HashMap<>();
        int i = -1;
        int j = -1;
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            //acquire the elements
            while(i < t.length()-1 && matchCount < desiredmatchCount){
                 i++;
                char ch = t.charAt(i);
                hm1.put(ch, hm1.getOrDefault(ch,0)+1);
                
                if(hm1.getOrDefault(ch,0) <= hm2.getOrDefault(ch,0)){
                    matchCount++;
                }
                
                f1 = true;
            }
            
            //Collect and release the elements 
            while(j < i && matchCount == desiredmatchCount){
                String panswer = t.substring(j+1, i+1);
                if(answer.length() == 0 || panswer.length() < answer.length()){
                    answer = panswer;
                }
                j++;
                char ch = t.charAt(j);
                if(hm1.get(ch) == 1){
                    hm1.remove(ch);
                }else{
                    hm1.put(ch,hm1.get(ch)-1);
                }
                
                 if(hm1.getOrDefault(ch,0) < hm2.getOrDefault(ch,0)){
                    matchCount--;
                }
                 f2 = true;
            }
            
            if(f1 == false && f2 == false){
                break;
            }
        } 
        return answer;
    }
}
