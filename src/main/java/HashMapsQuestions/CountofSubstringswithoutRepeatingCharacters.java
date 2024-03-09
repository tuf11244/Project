/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 * Date: 03/08/2024
 *https://www.geeksforgeeks.org/count-of-all-unique-substrings-with-non-repeating-characters/
 * @author parth
 */
public class CountofSubstringswithoutRepeatingCharacters {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String s = "abba";
        System.out.println(countofSubstrings(s));
    }
    public static int countofSubstrings(String s){
        int count = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int i = -1;
        int j = -1;
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            //acquire 
            while(i < s.length()-1){
                f1 = true;
                i++;
                char ch = s.charAt(i);
                hm.put(ch,hm.getOrDefault(ch, 0) + 1);
                if(hm.get(ch) == 2){
                    break;
                }else{
                    int length = i - j;
                    count = count + length;
                }
            }
            
            //release
            while(j < i){
                f2 = true;
                j++;
                char ch = s.charAt(j);
                
                hm.put(ch,hm.get(ch)-1);
                //Below statement means string is valid so we have to collect the answer
                if(hm.get(ch) == 1){
                    int length = i - j;
                    count = count + length;
                    break;
                }
                
            }
            if(f1 == false && f2 == false){
                break;
            }
        }
               
        return count;
    }
}
