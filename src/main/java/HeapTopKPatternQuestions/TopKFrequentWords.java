/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapTopKPatternQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 *https://leetcode.com/problems/top-k-frequent-words/
 * Date: 02/28/2024
 * @author parth
 */
public class TopKFrequentWords {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }

public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm = new HashMap<>();
        
        //Create a Frequency Map
        for(int i = 0; i < words.length;i++){
            if(hm.containsKey(words[i])){
                int oldFrequency = hm.get(words[i]);
                int newFrequency = oldFrequency + 1;
                hm.put(words[i],newFrequency);
            }else{
                hm.put(words[i], 1);
            }
        }
        
        PriorityQueue<Pair3> pq = new PriorityQueue<>();
        //Iterate over our hashMap
        for(String element : hm.keySet()){
            pq.add(new Pair3(element,hm.get(element)));
        }
       
        List<String> list = new ArrayList<>();
        for(int i = 0; i < k;i++){
            list.add(pq.poll().value);
        }
        //Collections.reverse(list);
        return list;
    }
            
}
class Pair3 implements Comparable<Pair3>{
    String value;
    int frequency;
    
    Pair3(String value, int frequency){
        this.value = value;
        this.frequency = frequency;
    }
    @Override
    public int compareTo(Pair3 o) {
        if(this.frequency == o.frequency){
            return this.value.compareTo(o.value);
        }
        return Integer.compare(o.frequency, this.frequency);
    }
   
}
