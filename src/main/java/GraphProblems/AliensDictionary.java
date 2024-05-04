/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *Date: 05/04/2024
 * https://leetcode.com/problems/alien-dictionary/
 * @author parth
 */

public class AliensDictionary {

    public static void main(String args[]) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(dictionary(words));
    }
    
    public static String dictionary(String[] words){
        HashMap<Character,HashSet<Character>> graph = new HashMap<>();
        HashMap<Character,Integer> indegree = new HashMap<>();
        
        for(String st : words){
            for(char ch : st.toCharArray()){
                indegree.put(ch, 0); 
            }
        }
        
        // Build the graph
        for(int i = 0; i < words.length - 1; i++){
            String curr = words[i];
            String next = words[i+1];
            
            int length = Math.min(curr.length(), next.length());
            boolean flag = false;
            for(int j = 0; j < length; j++){
                char ch1 = curr.charAt(j);
                char ch2  = next.charAt(j);
                
                if(ch1 != ch2){
                    HashSet<Character> set = graph.getOrDefault(ch1, new HashSet<>());
                    set.add(ch2);
                    graph.put(ch1, set);
                    indegree.put(ch2, indegree.getOrDefault(ch2, 0) + 1);
                    flag = true;
                    break;
                }
            }
            if(!flag && curr.length() > next.length()){
                return "";
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for(char ch : indegree.keySet()){
            if(indegree.get(ch) == 0){
                queue.add(ch);
            }
        }
        
        while(!queue.isEmpty()){
            char rem = queue.poll();
            sb.append(rem);
            if(graph.containsKey(rem)){
                for(char nbg : graph.get(rem)){
                    indegree.put(nbg, indegree.get(nbg) - 1);
                    if(indegree.get(nbg) == 0){
                        queue.add(nbg);
                    }
                }
            }
        }
        
        if(sb.length() == indegree.size()){
            return sb.toString();
        }
        
        return "";
    }
}
