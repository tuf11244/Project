/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *Date : 03/26/2024
 * https://leetcode.com/problems/maximum-frequency-stack/
 * @author parth
 */
public class MaxFrequencyStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
class FreqStack {
    HashMap<Integer,LinkedList<Integer>> hm;
    HashMap<Integer, Integer> fmap;
    int maxFrequency;
   
    public FreqStack() {
        hm = new HashMap<>();
        fmap = new HashMap<>();
        maxFrequency = 0;
    }
    
    public void push(int val) {
        int currentFrequency = fmap.getOrDefault(val,0);
        currentFrequency++;
        fmap.put(val,currentFrequency);

        //below line means if the linkedList doesnt exist for the current frequency 
        //Than create a new LinkedList for the current frequency;
        if(hm.containsKey(currentFrequency) == false){
            hm.put(currentFrequency,new LinkedList<Integer>());
        } 

        //Now we have to add our val to the Linkedlist created in the above line 
        hm.get(currentFrequency).addFirst(val);

        maxFrequency = Math.max(maxFrequency,currentFrequency);

    }
    
    public int pop() {
     int answer = hm.get(maxFrequency).removeFirst();
    
        //Now we need to update the our fmap and hm because we just poped our answer in the above line
        int currentFrequency = fmap.get(answer);
        currentFrequency--;
        fmap.put(answer,currentFrequency);

        //Below line means that the LinkedList for maxFrequeny is empty 
        //so we need to decrease the maxFrequency
        if(hm.get(maxFrequency).size() == 0){
            maxFrequency--;
        }
     return answer;
      
    }
        

    
}

   

   


/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
