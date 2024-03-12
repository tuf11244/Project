/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *Date: 03/12/2024
 * https://leetcode.com/problems/group-shifted-strings/
 * @author parth
 */
public class GroupShiftedStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String[] arr = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> answer = shiftedStrings(arr);
        
        for(List<String> x: answer){
            System.out.println(x);
        }
    }
    public static List<List<String>> shiftedStrings(String[] arr){
        //Create HashMap of String,ArrayList
        HashMap<String,List<String>> hm = new HashMap<>();
        
        for(String s : arr){
            String key = getKey(s);
            if(hm.containsKey(key)){
                List<String> list = hm.get(key);
                list.add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                hm.put(key,list);
            }
        }
        
        List<List<String>> answer = new ArrayList<>();
        
        for(List<String> element : hm.values()){
            answer.add(element);
        }
        return answer;
    }
    
    public static String getKey(String s){
        String key = "";
        for(int i = 1; i < s.length();i++){
            char current = s.charAt(i);
            char previous = s.charAt(i-1);
            int diff = current - previous;
            
            if(diff < 0){
                diff = diff + 26;
            }
            key = key +  diff + "#";
        }
        key = key + ".";
        
        return key;
    }
}
