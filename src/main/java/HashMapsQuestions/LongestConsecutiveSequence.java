/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *Date: 03/01/2024
 * @author parth
 */
public class LongestConsecutiveSequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int longestConsecutive(int[] arr){
        HashMap<Integer,Boolean> hm = new HashMap<>();
        
        //Iterate the array and mark true for every element in the hashmap
        for(int i = 0; i < arr.length;i++){
            hm.put(arr[i],true);
        }
        
        //
        for(int i = 0; i < arr.length;i++){
            if(hm.containsKey(arr[i]-1)){
                hm.put(arr[i],false);
            }
        }
        
        int maxStartPoint = 0; //Starting point of our maximum Sequence
        int maxLength = 0; //Max Lenght of our sequency 
        
        for(int i = 0; i < arr.length;i++){
            if(hm.get((arr[i])) == true){
                int temporaryLength = 1;
                int temporaryStartPoint = arr[i];
                
                while(hm.containsKey(temporaryStartPoint + temporaryLength)){
                    temporaryLength++;
                }
                
                if(temporaryLength > maxLength){
                    maxLength = temporaryLength;
                    maxStartPoint = temporaryStartPoint;
                }
            }
        }
        return maxLength;
    }
}
