/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Date: 03/25/2024
 *https://leetcode.com/problems/avoid-flood-in-the-city/
 * @author parth
 */
public class AvoidFloodintheCity {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int[] avoidFloods(int[] rains){
        //Create a HashMap of integer and the day it rained
        HashMap<Integer,Integer> hm = new HashMap<>();
        TreeSet<Integer> dry = new TreeSet<>();
        int[] answer = new int[rains.length];
        for(int i = 0; i < rains.length;i++){
            
            //If rains[i] == 0; we can add it in our treeset, that means we can use that day to dry other lakes if any 
            if(rains[i] == 0){
                dry.add(i); //Adding the index i.e. the day it didn't rain
                answer[i] = 1 ;//Default value
            }else{
                
                Integer id = hm.get(rains[i]);
                //That means its hasn;t rain before on the current lake
                if(id == null){
                    hm.put(rains[i],i);
                }else{ //That means it has rained before 
                    
                    //It gets the higher day than the current day i.e. id
                    Integer dryThisday = dry.higher(id);
                    
                    //if dryThisday is null that means higher day than the current day wasn't found
                    //if drythisday is null that means flood
                    if(dryThisday == null){
                        return new int[]{};
                    }else{
                        answer[dryThisday] = rains[i];
                        
                        //We have to remove dryThisday from our treeSet
                        dry.remove(dryThisday);
                        
                        //Update the hashmap with latest day it rained on the current Lake
                        hm.put(rains[i],i);
                        
                    }
                }
                //Default value
                answer[i] = -1;
            }
        }
        return answer;
        
    }

}
