/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;
import java.util.*;
/**
 *Date: 01/10/2025
 * https://leetcode.com/problems/construct-k-palindrome-strings
 * @author parth
 */
public class ConstructKPalindromeStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public boolean canConstruct(String s, int k) {

        if(k > s.length()){
            return false;
        }
        
        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i = 0; i < s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        int count = 0;
        for(char ch : hm.keySet()){
            if(hm.get(ch) % 2 != 0){
                count++;
            }
        }

        return count <= k;
    }
}
