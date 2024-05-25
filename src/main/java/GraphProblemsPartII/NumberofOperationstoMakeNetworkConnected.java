/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/24/2024
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 * @author parth
 */
public class NumberofOperationstoMakeNetworkConnected {

    /**
     * @param args the command line arguments
     */
    
    public static int[] parent;
    public static int[] rank;
    public static int extraCables;
    
    public static void main(String args[]) {
        int[][] connections = {
            {0,1},
            {0,2},
            {0,3},
            {1,2},
            {1,3}
        };
        
        System.out.println(makeConnections(6,connections));
    }
    public static int makeConnections(int n, int[][] connections){
        extraCables = 0;
        parent = new int[n];
        rank = new int[n];
        
        //Intialize the arrays;
        for(int i = 0; i < n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int[] connection : connections){
            int x = connection[0];
            int y = connection[1];
            
            merge(x,y);
        }
        
        //Find the number of disconnected Components 
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n;i++){
            int p = find(i);
            set.add(p);
        }
        int gaps = set.size() - 1; //these are the connection gaps
        
        if(gaps > extraCables){
            return -1;
        }
        
       
        return Math.min(gaps,extraCables);
        //can be also return gaps;
    }
    
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
    
    public static void merge(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx;
            }else if(rank[lx] < rank[ly]){
                parent[lx] = ly;
            }else{
                parent[lx] = ly;
                rank[ly]++;
            }
        }else{
            extraCables++;  //meaning a cycle is formed
        }
        
    }
}
