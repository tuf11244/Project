/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *https://leetcode.com/problems/rearrange-string-k-distance-apart/
 * Question : 
 * Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
 *  All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
 * @author parth
 */
public class RearrangeStringKDistanceApart {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(reArrangeString("aaadbbcc",2));
    }
    public static String reArrangeString(String s, int k){
        if(s.length() <= 1 || k <= 1){
            return s;
        }
        int[] map = new int[26];
        for(int i = 0; i < s.length();i++){
            map[s.charAt(i)-'a']++;
        }
        System.out.println(Arrays.toString(map));
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i = 0; i < map.length;i++){
            if(map[i] == 0){
                continue;
            }
            pq.add(new Node((char)(i+'a'),map[i]));
        }
        
        StringBuilder sb = new StringBuilder();
        while(pq.size() >= k){
            Node[] arr = new Node[k];
            for(int i = 0; i < k ;i++){
                arr[i] = pq.poll();
            }
            for(int i = 0; i < k;i++){
                sb.append(arr[i].ch);
                arr[i].frequency--;
                if(arr[i].frequency > 0){
                    pq.add(arr[i]);
                }
            }
        }
        
        while(!pq.isEmpty()){
            Node remove = pq.poll();
            sb.append(remove.ch);
            remove.frequency--;
            if(remove.frequency > 0){
                return "";
            }
        }
        return sb.toString();       
    }
}

class Node implements Comparable<Node>{
    char ch;
    int frequency;
    
    public Node(char ch, int frequency){
        this.ch = ch;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Node o) {
        if(this.frequency!=o.frequency){
            return o.frequency - this.frequency;
        }
        return this.ch - o.ch;
    }
    
}
