/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 10/18/2024
 *https://leetcode.com/problems/frog-jump/
 * @author parth
 */
public class FrogJump {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>> hm = new HashMap<>();

        for(int i = 0; i < stones.length;i++){
            hm.put(stones[i],new HashSet<>());
        }

        hm.get(0).add(1); // Because the frog is on the first stone and assumes the first jump must 
                            // be 1 unit;

        for(int i = 0; i < stones.length;i++){
            int currentStone = stones[i];

             HashSet<Integer> jumps = hm.get(currentStone);

             for(int jump : jumps){
                    int position = currentStone + jump;

                    if(position == stones[stones.length - 1]){
                        return true; //we have reached our destination
                    }

                    if(hm.containsKey(position)){
                        if(jump - 1 > 0){
                            hm.get(position).add(jump- 1); //we dont add 0 jumps or negative value jumps
                        }
                        hm.get(position).add(jump);
                        hm.get(position).add(jump +1);
                    }
             }
        }
        return false;
    }
}
