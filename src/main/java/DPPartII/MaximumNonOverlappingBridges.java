/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 08/07/2024
 * https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
 * @author parth
 */
public class MaximumNonOverlappingBridges {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int maxBridges(int[][] bridges){
         Bridges[] bridge = new Bridges[bridges.length];
         
         for(int i = 0; i < bridges.length;i++){
             bridge[i] = new Bridges(bridges[i][0], bridges[i][1]);
         }
         int answer = 0;
         Arrays.sort(bridge);
         
         int[] dp = new int[bridges.length];
         
         for(int i = 0; i < bridges.length;i++){
             int max = 0;
             
             for(int j = 0; j < i; j++){
                 if(bridge[j].s <= bridge[i].s){
                     max = Math.max(dp[j],max);
                 }
             }
             dp[i] = max + 1;
             answer = Math.max(answer,dp[i]);
         }
         return answer;
    }
}

class Bridges implements Comparable<Bridges>{
    int n;
    int s;
    
    public Bridges(int n, int s){
        this.n = n;
        this.s = s;
    }

    @Override
    public int compareTo(Bridges o) {
        if(this.n != o.n){
            return this.n - o.n;
        }
        return this.s - o.s;
    }
}
