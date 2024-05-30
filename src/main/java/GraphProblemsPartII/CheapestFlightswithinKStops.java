/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;

/**
 *Date: 05/29/2024
 *https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * @author parth
 */
public class CheapestFlightswithinKStops {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] flights = {
            {0,1,100},
            {1,2,100},
            {2,0,100},
            {1,3,600},
            {2,3,200}
        };
        
        System.out.println(findCheapestPrice(4,flights,0,3,1));
    }
    
    
     public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<flights> [] graph = new ArrayList[n];
        
        for(int i = 0; i< n;i++){
            graph[i] = new ArrayList<>();
        }
        //Build the graph
        for(int[] flight : flights){
            
            int s = flight[0];
            int nbg = flight[1];
            int wt =  flight[2];
            
            graph[s].add(new flights(s,nbg,wt));
            
        }
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        
        Queue<F> queue = new LinkedList<>();
        queue.add(new F(src,0,src+"",0)); //We can use normal heap also 
                                        //incase of priortity queue because the stops are in increasing order 
        distances[src] = 0;
        
        while(!queue.isEmpty()){
            F rem = queue.poll();
            
            if(rem.stops > k){
                continue;
            }
            for (flights flight : graph[rem.v]) {
                int newDist = rem.wsf + flight.wt;
                if (newDist < distances[flight.nbg] && rem.stops <= k) {
                    distances[flight.nbg] = newDist;
                    queue.add(new F(flight.nbg, rem.stops + 1,rem.psf+flight.nbg, newDist));
                }
            }
        }
         System.out.println(Arrays.toString(distances));
        if(distances[dst] == Integer.MAX_VALUE){
            return -1;
        }
        
        return distances[dst];
    }
}

class F {
    int v;
    int stops;
    int wsf;
    String psf;
    public F(int v,int stops,String psf, int wsf){
        this.v = v;
        this.psf = psf;
        this.stops = stops;
        this.wsf = wsf;
    }

    @Override
    public String toString() {
        return "F{" + "v=" + v + ", stops=" + stops + ", psf=" + psf + '}';
    }
  
    
}

class flights{
    int src;
    int nbg;
    int wt;
    
    public flights(int src, int nbg, int wt){
        this.src = src;
        this.nbg = nbg;
        this.wt = wt;
    }
}
