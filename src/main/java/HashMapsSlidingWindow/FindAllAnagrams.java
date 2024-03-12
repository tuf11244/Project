/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *Date: 03/12/2024
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * https://www.geeksforgeeks.org/problems/check-if-two-strings-are-k-anagrams-or-not
 * @author parth
 */
public class FindAllAnagrams {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(findAllAnagrams("aaaaaaaaaaaaa","aaaaaaaaaa"));
      
    }
    
    public static List<Integer> findAllAnagrams(String s,String p){
        List<Integer> list = new ArrayList<>();
        //HashMap for String p 
        HashMap<Character,Integer> pmap = new HashMap<>();
        for(int i = 0 ; i < p.length();i++){
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch, 0)+1);
        }
        
        //Frequency Map for String s
        //You need to create a frequency map of s of only p.length()
        HashMap<Character,Integer> smap = new HashMap<>();
        for(int i = 0; i < p.length();i++){
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0)+1);
        }
        
        int i = p.length();
        while(i < s.length()){
            if(compare(smap,pmap)){
                list.add(i-p.length());
            }
            //Acquire
            char cha = s.charAt(i);
            smap.put(cha,smap.getOrDefault(cha, 0)+1);
            
            //Release
            char chr = s.charAt(i-p.length());
            if(smap.get(chr)==1){
                smap.remove(chr);
            }else{
                smap.put(chr,smap.get(chr)-1);
            }
            i++;
        }
        if(compare(smap,pmap)){
                list.add(i-p.length());
            }
          
        return list;
    }
    public static boolean compare(HashMap<Character,Integer> smap, HashMap<Character,Integer> pmap){
        return smap.equals(pmap);
        
    }
    
    
    //https://www.geeksforgeeks.org/problems/check-if-two-strings-are-k-anagrams-or-not
    public static boolean areKAnagrams(String s1, String s2, int k) {
        
        if(s1.length()!= s2.length()){
            return false;
        }
        HashMap<Character,Integer> s1Map = new HashMap<>();
       
        
        for(int i = 0; i < s1.length();i++){
            char ch = s1.charAt(i);
            s1Map.put(ch,s1Map.getOrDefault(ch,0)+1);
        }
        
         for(int i = 0; i < s2.length();i++){
            char ch = s2.charAt(i);
            if(s1Map.getOrDefault(ch,0) > 0){
                s1Map.put(ch,s1Map.get(ch)-1);
            }
        }
        
        int count= 0;
        for(char ch : s1Map.keySet()){
            count = count + s1Map.get(ch);
        }
        
        return count <= k;
    }
    
    
}
