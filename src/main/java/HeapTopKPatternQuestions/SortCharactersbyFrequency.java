/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapTopKPatternQuestions;
import HeapTopKPatternQuestions.Pair;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Collections;
/**
 *Date:02/28/2024
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * @author parth
 */
public class SortCharactersbyFrequency {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(frequencySort("tree"));
    }
    public static String frequencySort(String s) {
        HashMap<Character,Integer>  hm = new HashMap<>();
        //Creater a Frequecy Map;
        
        for(int i = 0; i < s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                int oldFrequency = hm.get(s.charAt(i));
                int newFrequency = oldFrequency + 1;
                hm.put(s.charAt(i), newFrequency);
            }else{
                hm.put(s.charAt(i),1);
            }            
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        //Iterate over our Hash Map 
        for(Character c : hm.keySet()){
            pq.add(new Pair(c,hm.get(c)));
        }
        System.out.println(pq);
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair remove = pq.poll();
            int frequency = remove.frequency;
            while(frequency!=0){
                sb.append(remove.c);
                frequency--;
            }
        }
        return sb.toString();
        
    }
}

class Pair implements Comparable<Pair>{
  char c;
  int frequency;
  
  Pair(Character c, int frequency){
      this.c = c;
      this.frequency = frequency;
  }

    @Override
    public int compareTo(Pair o) {
        return this.frequency - o.frequency;
    }

    @Override
    public String toString() {
        return "Pair{" + "c=" + c + ", frequency=" + frequency + '}';
    }
    
  
  
}
