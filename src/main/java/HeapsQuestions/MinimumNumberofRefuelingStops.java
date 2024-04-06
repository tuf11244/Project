/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *Date: 04/05/2024
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/
 * @author parth
 */
public class MinimumNumberofRefuelingStops {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        //Create a list of list 
        List<List<Integer>> list = new ArrayList<>();
        //Copy the stations 2D array to list
        for(int i = 0; i < stations.length;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(stations[i][0]);
            temp.add(stations[i][1]);
            list.add(temp);
        }
        
        List<Integer> temp = new ArrayList<>();
        //Add the target and fuel availaible in our temp list
        temp.add(target);
        temp.add(0);
        //Add the temp list to our main list
        list.add(temp);
        //Create a Priority Queue Max heap for fuel availaible
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for(List<Integer> element : list){          
            if(element.get(0) > startFuel){
                while(startFuel < element.get(0) && !pq.isEmpty()){
                 int fuel = pq.poll();
                 startFuel = startFuel + fuel;
                 answer++;               
                }                
                if(element.get(0) > startFuel){
                    return -1;
                }
            }
            pq.add(element.get(1));
        }
        return answer;       
    }
}
