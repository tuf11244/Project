/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/18/2024
 *https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/
 * @author parth
 */
public class MinimizeHammingDistanceAfterSwapOperation {
    
    public static int[] parent;
    public static int[] rank;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] source = {5,1,2,4,3};
        int[] target = {1,5,4,2,3};
        int[][] allowedSwaps = {
            {0,4},
            {4,2},
            {1,3},
            {1,4}
        };
        
        System.out.println(minHammingDistance(source,target,allowedSwaps));
    }
    
    public static int minHammingDistance(int[] source, int[] target, int[][] allowedSwaps){
        
        parent = new int[source.length];
        rank = new int[source.length];
        
        //Intialize our parent and rank arrays 
        for(int i = 0; i < source.length;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int[] edge : allowedSwaps){
            union(edge[0],edge[1]);
        }
        
       // Create a HashMap of root vs frequency map
    HashMap<Integer, HashMap<Integer, Integer>> hm = new HashMap<>();
    for (int i = 0; i < source.length; i++) {
        int p = find(i);
        // Get the frequency map for the root
        HashMap<Integer, Integer> fmap = hm.getOrDefault(p, new HashMap<>());
        // Update the frequency of source[i] in the frequency map
        fmap.put(source[i], fmap.getOrDefault(source[i], 0) + 1);
        hm.put(p, fmap);
    }
       // System.out.println(hm);
    int hammingD = 0;
    // Iterate over the target array
    for (int i = 0; i < target.length; i++) {
        int p = find(i);
        // Get the frequency map corresponding to the root
        HashMap<Integer, Integer> fmap = hm.get(p);
        // If target[i] exists in fmap and its frequency is greater than 0, decrement its count
        if (fmap.containsKey(target[i]) && fmap.get(target[i]) > 0) {
            fmap.put(target[i], fmap.get(target[i]) - 1);
        } else {
            // If target[i] doesn't exist in fmap or its count is 0, increment the hamming distance
            hammingD++;
        }
    }

    return hammingD;
        
        
    }
    public static void union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(lx!=ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx;
            }else if(rank[lx] < rank[ly]){
                parent[lx] = ly;
            }else{
                parent[lx] = ly;
                rank[ly]++;
            }
        }
    }
    
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
}
