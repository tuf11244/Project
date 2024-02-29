/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;
import java.util.HashSet;

/**
 *Date: 02/28/2024
 * https://www.geeksforgeeks.org/return-maximum-occurring-character-in-the-input-string/
 * @author parth
 */
public class FindMaximumOccuringCharacterinString {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String s = "geeksforgeeks";
//        HashSet<Character> set = new HashSet<>();
//        
//        for(int i = 0; i < s.length();i++){
//            set.add(s.charAt(i));
//        }
//        System.out.println(set);
//        int maxCount = 0;
//        int count = 0;
//        for(Character c : set){
//            count = helper(c,s);
//            if(count > maxCount){
//                maxCount = count;
//            }
//        }
//        System.out.println(maxCount);
        
        usingHashMaps(s);
    }
    public static int helper(Character c, String s){
        int count = 0;
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == c){
                count++;
            }
        }
        return count;
    }
    
    public static void usingHashMaps(String s){
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                int oldFrequency = hm.get(s.charAt(i));
                int newFrequency = oldFrequency + 1;
                hm.put(s.charAt(i), newFrequency);
            }else{
                hm.put(s.charAt(i),1);
            }
        }
        System.out.println(hm);
        
        
        char maxCharFrequency = s.charAt(0);
        
        for(Character c : hm.keySet()){
            if(hm.get(c) > hm.get(maxCharFrequency)){
                maxCharFrequency = c;
            }           
        }
        System.out.println(maxCharFrequency);
    }
    
}
