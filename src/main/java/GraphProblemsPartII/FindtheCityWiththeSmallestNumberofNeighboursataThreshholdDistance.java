/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/29/2024
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 * @author parth
 */
public class FindtheCityWiththeSmallestNumberofNeighboursataThreshholdDistance {

    /**
     * Can be done using Floyd Warshall Algorithm also 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] edges = {
            {0,1,3},
            {1,2,1},
            {1,3,4},
            {2,3,1}
        };
        System.out.println(findTheCity(4,edges,4));;
    }
    
    public static int findTheCity(int n, int[][] edges, int thresholdDistance){
        List<city> [] graph = new ArrayList[n];
        
        for(int i = 0; i < n;i++){
            graph[i] = new ArrayList<>();
        }
      
        //Build the graph 
        for(int[] edge : edges){
            int src = edge[0];
            int nbg = edge[1];
            int wt = edge[2];
            
            graph[src].add(new city(src,nbg,wt));
            graph[nbg].add(new city(nbg,src,wt));
        }
        int resultCity = -1; //our answer 
        int smallestNeighbourCities = n ;//how many cities are neighbours to current city
        
        for(int i =0; i < n;i++){
            int[] distances = djikstra(i,graph);
            int nbgCount = 0;
            
            for(int distance : distances){
                if(distance > 0 && distance <= thresholdDistance) {
                    nbgCount++;
                }
            }
            
            if(nbgCount < smallestNeighbourCities){
                smallestNeighbourCities = nbgCount;
                resultCity = i;
            }
             else if(nbgCount == smallestNeighbourCities && i > resultCity) {
                resultCity = i;
            }
        }
        
        return resultCity;
    }
    
    public static int[] djikstra(int src, List<city> [] graph){
        PriorityQueue<PQ> pq = new PriorityQueue<>();
        int[] distances = new int[graph.length];  //graph.length is the number of vertices 
        
        Arrays.fill(distances,Integer.MAX_VALUE); //Intialize distance arrays
        distances[src] = 0; //because we put the distance from city itself as 0;
        
        pq.add(new PQ(src,src+"",0));
        
        while(!pq.isEmpty()){
            PQ rem = pq.poll();
            
            for(city c : graph[rem.v]){
                int newDistance = rem.wsf + c.wt;
                if(newDistance < distances[c.nbg]){
                    distances[c.nbg] = newDistance;
                    
                    pq.add(new PQ(c.nbg,rem.psf+c.nbg,newDistance));
                }
            }
        }
        return distances;
        
    }

    
   
}
class PQ implements Comparable<PQ>{
    int v;
    String psf;
    int wsf;
    
    public PQ(int v,String psf,int wsf){
        this.v = v;
        this.psf = psf;
        this.wsf = wsf;
    }

    @Override
    public int compareTo(PQ o) {
        return this.wsf - o.wsf;
    }    
}

class city{
    int src;
    int nbg;
    int wt;
    
    public city(int src, int nbg, int wt){
        this.src = src;
        this.nbg  = nbg;
        this.wt = wt;
    }
}