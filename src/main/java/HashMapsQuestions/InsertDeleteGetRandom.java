/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Date: 03/26/2024
 *https://leetcode.com/problems/insert-delete-getrandom-o1/
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * @author parth
 */
public class InsertDeleteGetRandom {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
class RandomizedSet {
    //Creating a Hashmap of element vs index 
    HashMap<Integer,Integer> hm;
    List<Integer> list;
    Random rand;
    public RandomizedSet() {
      hm = new HashMap<>();
      list = new ArrayList<>();
      rand = new Random();
    }
    
    public boolean insert(int val) {
       if(hm.containsKey(val)){
        return false;
       }
       hm.put(val,list.size());
       list.add(val);
       return true;
    }
    
    public boolean remove(int val) {
     if(!hm.containsKey(val)){
        return false;
     }
    
    //Get the Remove Index from the hashMap
     int removeIdx = hm.get(val);
     hm.remove(val);

     //No need to remove the last index 
     if(removeIdx == list.size()-1){
        list.remove(list.size()-1);
        return true;
     }

     //If its not the same as the last index than we need to swap it 
     list.set(removeIdx,list.get(list.size()-1));
     list.remove(list.size()-1);

     //Update the our HashMap
     hm.put(list.get(removeIdx),removeIdx);
    return true;
    }
    
    public int getRandom() {
      int randomIdx = rand.nextInt(list.size());
      return list.get(randomIdx);
    }
}

//With Duplicates 
class RandomizedCollection {
    HashMap<Integer,HashSet<Integer>> hm;
    List<Integer> list;
    Random rand;
    //HashSet<Integer> stores the list of indices using the list 
    public RandomizedCollection() {
        hm = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val)){
            HashSet<Integer> set = hm.get(val);
            set.add(list.size());
            list.add(val);
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(list.size());
        hm.put(val,set);
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val)){
            return false;
        }
        HashSet<Integer> set = hm.get(val);
        
        int removeIdx = - 1;
        for(int i : set){
            removeIdx = i;
            break;
        }
        
        set.remove(removeIdx);
        hm.put(val,set);
        
        if(hm.get(val).size() == 0){
            hm.remove(val);
        }
        
        //Remove from the arraylist 
        if(removeIdx == list.size()-1){
            list.remove(list.size()-1);
            return true;
        }
        list.set(removeIdx,list.get(list.size()-1));
        list.remove(list.size()-1);
        
        int newValue = list.get(removeIdx);
        //Now get the set for the new value 
        HashSet<Integer> temp = hm.get(newValue);
        
        //Now we have to remove the existing index in our HashMap for the new value 
        temp.remove(list.size());
        //Below, we are adding the index in the HashMap at which the newValue is present in our ArrayList 
        temp.add(removeIdx);
        //Put the new value and temp in our HashMap 
        hm.put(newValue, temp);
        return true;

    }
    
    public int getRandom() {
        int randomIdx = rand.nextInt(list.size());
        return list.get(randomIdx);
    }
}


