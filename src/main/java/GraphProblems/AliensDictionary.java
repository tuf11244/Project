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
        
        //Create a map of Character vs HashSet 
        //Charater is a vertice
        //HashSet is a set of neighbours 
        HashMap<Character,HashSet<Character>> graph = new HashMap<>();
        
        //Create a Hashmap of character vs Integer, this a frequency map which represents the 
        //indegree array used for kahn's algorithm
        HashMap<Character,Integer> indegree = new HashMap<>();
        
        for(String st : words){
            for(char ch : st.toCharArray()){
                indegree.put(ch, 0); 
            }
        }
        
        // Build the graph and decide the preference 
        for(int i = 0; i < words.length - 1; i++){
            String curr = words[i]; //current word 
            String next = words[i+1]; //next word
            
            
            //Find the min length
            int length = Math.min(curr.length(), next.length());
            boolean flag = false;
            for(int j = 0; j < length; j++){
                char ch1 = curr.charAt(j);
                char ch2  = next.charAt(j);
                
                //found the mismatch 
                //note that ch1 != ch2 
                //ch1 will always be preferred first because its in our current word
                if(ch1 != ch2){
                    HashSet<Character> set = graph.getOrDefault(ch1, new HashSet<>());
                    set.add(ch2);
                    graph.put(ch1, set);
                    //over in this case ch2 is neighbour and ch1 is source
                    //so for our indegree array we increase the frequency of our neighbours
                    indegree.put(ch2, indegree.getOrDefault(ch2, 0) + 1);
                    flag = true;
                    break;
                }
            }
            
            //below statement is for edge case 
            //lets say we are giving abcd, abc as 2 strings 
            //abcd = curr and abc = next
            //so the mismatch wouldn't be found as min length would be 3 
            //so in this case the input given to us in wrong so we have return " ";
            if(!flag && curr.length() > next.length()){
                return "";
            }
        }
        System.out.println(graph);
        System.out.println(indegree);
        
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        //we add character in our queue who's indegree is 0 
        //that is they are the source 
        for(char ch : indegree.keySet()){
            if(indegree.get(ch) == 0){
                queue.add(ch);
            }
        }
        
        while(!queue.isEmpty()){
            char rem = queue.poll();
            sb.append(rem);
            if(graph.containsKey(rem)){
                //get the neighbours for the character that was just removed
                for(char nbg : graph.get(rem)){
                    //and decrease each of thier frequencies by 1
                    indegree.put(nbg, indegree.get(nbg) - 1);
                    if(indegree.get(nbg) == 0){
                        //if any their frequency is 0 
                        //add it in our queue
                        queue.add(nbg);
                    }
                }
            }
        }
        //check if all the vertices are present in our sb.length()
        //sb.length() acts a count variable 
        if(sb.length() == indegree.size()){
            return sb.toString();
        }
        
        return "";
    }
}
