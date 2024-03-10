/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 03/09/2024
 *https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
 * @author parth
 */
public class SmallestWindowLength {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(smallestWindow("AABBBCBBAC"));
    }
    public static int smallestWindow(String s){
        int maxlength = Integer.MAX_VALUE;
        int i = -1;
        int j = -1;
        
        HashSet<Character> set = new HashSet<>();
        for(int k = 0; k < s.length();k++){
            set.add(s.charAt(k));
        }
           
        //Create a Frequency HashMap for comparison 
        HashMap<Character,Integer> hm = new HashMap<>();
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            //Acquire
            while(i < s.length()-1 && hm.size() < set.size()){
                f1 = true;
                i++;
                char ch = s.charAt(i);
                hm.put(ch, hm.getOrDefault(ch,0)+1);
                
            }
            
            //Collect and Release 
            while(j < i && hm.size() == set.size()){
                f2 = true;
                int length = i - j;
                if(length < maxlength){
                    maxlength = length;
                }
                
                j++;
                char ch = s.charAt(j);
                if(hm.get(ch) == 1){
                    hm.remove(ch);
                }else{
                    hm.put(ch,hm.get(ch)-1);
                }
               
            }
            
            if(f1 == false && f2== false){
                break;
            }
        }
        return maxlength;
    }
}
