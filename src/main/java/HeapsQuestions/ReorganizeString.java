/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *Date: 02/29/2024
 * https://leetcode.com/problems/reorganize-string/
 * @author parth
 */
public class ReorganizeString {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(reorganizeString("aab"));
    }
    
    public static String reorganizeString(String s){
        //Create a map;
        int[] map = new int[26];
        for(int i = 0; i < s.length();i++){
            map[s.charAt(i)-'a']++;
        }
        System.out.println(Arrays.toString(map));
        //Create a Priority Queue max Heap of Element1 type 
        PriorityQueue<Element1> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        
        //Build our priorityQueue 
        for(int i = 0; i < 26;i++){
            if(map[i] > 0){
                pq.add(new Element1((char)('a' + i),map[i]));
            }
        }
        
        System.out.println(pq);
        while(pq.size() >= 2){
            Element1 arr[] = new Element1[2];
            for(int i =0; i < 2;i++){
                arr[i] = pq.poll();
            }
            for(int i = 0; i < 2;i++){
                sb.append(arr[i].ch);
                arr[i].frequency--;
                if(arr[i].frequency > 0){
                    pq.add(arr[i]);
                }
            }
        }

        while(!pq.isEmpty()){
            Element1 rem = pq.poll();
            sb.append(rem.ch);
            rem.frequency--;
            if(rem.frequency > 0){
                return "";
            }
        }
        return sb.toString();
    }
}

class Element1 implements Comparable<Element1>{
    char ch;
    int frequency;
    
    public Element1(char ch, int frequency){
        this.ch = ch;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Element1 o) {
        return this.frequency - o.frequency;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Element1{");
        sb.append("ch=").append(ch);
        sb.append(", frequency=").append(frequency);
        sb.append('}');
        return sb.toString();
    }
    
}
