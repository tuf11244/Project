/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;
import java.util.List;

/**
 *Date: 03/21/2024
 *https://leetcode.com/problems/brick-wall/
 * @author parth
 */
public class BrickWall {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int leastBricks(List<List<Integer>> wall) {
    HashMap<Integer,Integer> hm = new HashMap<>();   
    int maxSplit = 0;
    for(List<Integer> element : wall){
        int prefixSum = 0;
        for(int i =0; i < element.size()-1;i++){
            prefixSum = prefixSum + element.get(i);
            hm.put(prefixSum,hm.getOrDefault(prefixSum,0)+1);
            maxSplit = Math.max(maxSplit,hm.get(prefixSum));
        }
    }
    
    return wall.size() - maxSplit;

    }
}
