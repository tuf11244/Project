/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * Date: 03/28/2024
 *https://leetcode.com/problems/random-pick-with-blacklist/
 * @author parth
 */
public class RandomPickwithBlackList {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}

class Solution {
    HashMap<Integer,Integer> hm;
    Random rand;
    int mappingRange;
    public Solution(int n, int[] blacklist) {
        hm = new HashMap<>();
        rand = new Random();
        mappingRange = n - blacklist.length;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < blacklist.length;i++){
                set.add(blacklist[i]);
        }
        //Decrease n by 1 
        n = n - 1;
        //begin mapping the elements 
        for(int i = 0; i < blacklist.length;i++){
            //Below statement means blacklist[i] is less than mappingRange
            if(blacklist[i] < mappingRange){
                while(set.contains(n)){
                    //Decrease n by 1 
                    n = n - 1;
                }
                hm.put(blacklist[i],n);
                //Decrease n by 1 again because the current n is taken 
                n = n-1;
            }
        }       
    }
    
    public int pick() {
        int randomIdx = rand.nextInt(mappingRange);

        //Means the randomIdx is blackListed so we get the mapped value 
        if(hm.containsKey(randomIdx)){
            return hm.get(randomIdx);
        }
        return randomIdx;
    }
}

