package HashMapsSlidingWindow;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *Date: 01/18/2024
 * https://leetcode.com/problems/group-anagrams/
 * PepCoding help
 * @author parth
 */
public class GroupAnagrams {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
        
        for(List<String> element : result){
            System.out.print(element + " ");
        }
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        
        HashMap<HashMap<Character,Integer>, List<String>> bigMap = new HashMap();
        
        for(String str : strs){
            HashMap<Character,Integer> frequencyMap = new HashMap<>();
            for(int i = 0; i < str.length();i++){
                char ch = str.charAt(i);
                frequencyMap.put(ch,frequencyMap.getOrDefault(ch, 0)+1);
            }
            
            if(!bigMap.containsKey(frequencyMap)){
                List<String> sub= new ArrayList<>();
                sub.add(str);
                bigMap.put(frequencyMap,sub);                
            }else{
                List<String> sub = bigMap.get(frequencyMap);
                sub.add(str);               
            }
        }
        
        for(List<String> element : bigMap.values()){
            list.add(element);
        }
        return list;
    }
}
