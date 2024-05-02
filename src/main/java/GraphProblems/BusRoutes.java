/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *Date: 05/01/2024
 * https://leetcode.com/problems/bus-routes/
 * @author parth
 */
public class BusRoutes {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] routes = {
            {1,2,3},
            {1,4,5},
            {5,8,7},
            {3,6,7}
        };
        numBusesToDestination(routes,1,7);
    }
    public static int numBusesToDestination(int[][] routes, int source, int target){
        //Create a HashMap of Bustop vs list of bus numbers that caters that bus Stop
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        
        for(int i = 0; i < routes.length;i++){
            for(int j = 0; j < routes[i].length;j++){
                if(hm.containsKey(routes[i][j])){
                    List<Integer> list = hm.get(routes[i][j]);
                    list.add(i);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    hm.put(routes[i][j], list);
                }
            }
        }
        System.out.println(hm);
        
        //Our queue will of bus Stops 
        Queue<Integer> queue = new LinkedList<>();
        
        //The below two HashSets act has visited 
        HashSet<Integer> busStopVisited = new HashSet<>();
        HashSet<Integer> busVisited = new HashSet<>();
        
        int level = 0;
        
        //Add the source to our queue and busStopVisited 
        queue.add(source);
        busStopVisited.add(source);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size > 0){
                int rem = queue.poll();
                
                if(rem == target){
                   // System.out.println("This the minimum number of buses " + level);
                   return level;
                }
                
                List<Integer> buses = hm.get(rem); //get the list fo buses from our bus Stop
                
                for(int bus : buses){
                    if(busVisited.contains(bus)){
                        continue;
                    }
                    int[] arr = routes[bus]; //gets you the array of the bus stops 
                    
                    for(int busStop  : arr){
                        if(busStopVisited.contains(busStop)){
                            continue;
                        }
                        queue.add(busStop);
                        busStopVisited.add(busStop);
                    }
                    
                    busVisited.add(bus);
                }
                size--;
            }
            level++;
        }
        return -1;
        
    }
}
