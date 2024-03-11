/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *Length of Longest SubstringwiththatMostKUniqueCharacter
 * count of longest substringwithatMostKUniqueCharacter
 * @author parth
 */
public class LongestSubstringswithatMostKUniqueChar {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       // System.out.println(longestSubstringwithatMostK("ddacbbaccdedaacebba",3));
       count("aabcbcdbca",2);
    }
    
    public static int longestSubstringwithatMostK(String s, int k){
        int maxLength = 0;
        int i = -1;
        int j = -1;
        HashMap<Character,Integer> hm = new HashMap<>();
        List<String> list = new ArrayList<>();
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            //Acquire
            while(i < s.length()-1){
                f1 = true;
                i++;
                char ch = s.charAt(i);
                hm.put(ch, hm.getOrDefault(ch,0)+1);
                
                if(hm.size() > k){
                    break;
                }else{
                int length = i - j;
                if(length > maxLength){
                    maxLength = length;
                    list.add(s.substring(j+1,i+1));
                }
            }
            }
            
            //Release
            while(j < i){
                f2 = true;
                j++;
                char ch = s.charAt(j);
                if(hm.get(ch)==1){
                    hm.remove(ch);
                }else{
                    hm.put(ch, hm.get(ch)-1);
                }
                
                if(hm.size() == k){
                    break;
                }
            }
           if(f1 == false && f2 == false){
            break;
            }
        }
        System.out.println(list);
        return maxLength;
    }
    
    
    //Count 
    public static void count(String s, int k){
        int i = -1;
        int j = -1;
        int count = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        //List<String> list = new ArrayList<>();
        while(true){          
            //Acquire
            while(i < s.length()-1){
                i++;
                char ch = s.charAt(i);
                hm.put(ch, hm.getOrDefault(ch,0)+1);
                
                if(hm.size() > k){
                    break;
                }else{
                    count = count + (i-j);
                }
            }          
            //Release
            while(j < i){
                j++;
                char ch = s.charAt(j);
                if(hm.get(ch)==1){
                    hm.remove(ch);
                }else{
                    hm.put(ch, hm.get(ch)-1);
                }
                
                if(hm.size() <= k){
                    count = count + (i-j);
                    break;
                }else{
                  continue;
                }
                
            }
           if(i == s.length()-1 && hm.size() <= k){
            break;
            }
        }
        System.out.println(count);
    }
}
