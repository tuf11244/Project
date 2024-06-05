/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;
import java.util.*;
/**
 *Date: 06/04/2024
 *https://leetcode.com/problems/find-common-characters
 * @author parth
 */
public class FindCommonCharacters {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public List<String> commonChars(String[] words) {
        //We need to create a frequency Hashmap 
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i < words[0].length();i++){
            hm.put(words[0].charAt(i),hm.getOrDefault(words[0].charAt(i),0)+1);
        }

        for(int i = 1; i < words.length;i++){
            String s = words[i];
             HashMap<Character,Integer> temp = new HashMap<>();
            for(int j = 0; j < s.length();j++){
                temp.put(s.charAt(j),temp.getOrDefault(s.charAt(j),0)+1);
               
            }
            for (char c : hm.keySet()) {
                if (temp.containsKey(c)) {
                    hm.put(c, Math.min(hm.get(c), temp.get(c)));
                } else {
                    hm.put(c, 0);
                }
            }
        }

        // Create the result list from the frequency map
        List<String> result = new ArrayList<>();
        for (char c : hm.keySet()) {
            int count = hm.get(c);
            for (int i = 0; i < count; i++) {
                result.add(String.valueOf(c));
            }
        }

        return result;
      

    }
}
