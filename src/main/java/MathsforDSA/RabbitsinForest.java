/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MathsforDSA;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/rabbits-in-forest/
 *  Date :03/16/2024
 * Based on piegon hole principle 
 * @author parth
 */
public class RabbitsinForest {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int numRabbits(int[] answers) {
        int count = 0;
        //Create a HashMap of Frequencies 
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < answers.length;i++){
            hm.put(answers[i], hm.getOrDefault(answers[i], 0)+1);
        }
        
        for(int group : hm.keySet()){
            int size = group+1;
            count = count + (size * (Math.ceilDiv(hm.get(group),size)));
        }
        return count;
    }
}
