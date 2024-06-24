/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date; 06/23/2024
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 * @author parth
 */
public class MostStonesRemovedwithSameRoworColumn {

    /**
     * @param args the command line arguments
     */
    public static int[] parent;
    public static int[] rank;
    
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int removeStones(int[][] stones) {
        if(stones.length == 1){
            return 0;
        }

        parent = new int[stones.length];
        rank = new int[stones.length];

        for(int i = 0; i< stones.length;i++){
            parent[i] =i;
            rank[i] = 1;
        }
          
        for(int i =0; i < stones.length - 1;i++){
            for(int j = i+1; j < stones.length;j++){

                int[] stone1 = stones[i];
                int[] stone2 = stones[j];

                if((stone1[0] == stone2[0]) || (stone1[1] == stone2[1])){
                    int lx = find(i);
                    int ly = find(j);

                    if(lx != ly){
                        merge(lx,ly);
                    }
                }
            }
        }

        HashSet<Integer> cc = new HashSet<>();

        for(int i =0; i < parent.length;i++){
            int p = find(parent[i]);
            cc.add(p);
        }

        return stones.length - cc.size();
    }

    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }

    public void merge(int lx, int ly){
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
