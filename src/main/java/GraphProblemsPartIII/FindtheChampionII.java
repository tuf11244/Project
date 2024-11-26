/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;

 /*
 *Date: 11/25/2024
 * https://leetcode.com/problems/find-champion-ii/
 * @author parth
 */
public class FindtheChampionII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int findChampion(int n, int[][] edges) {

        int[] indegree = new int[n];
        
        for(int[] edge : edges){
            int src = edge[0];
            int nbg = edge[1];

            indegree[nbg]++;
        }
        List<Integer> strongest = new ArrayList<>();
        for(int i = 0; i < indegree.length;i++){
            if(indegree[i] == 0){
                strongest.add(i);
            }
        }

        return strongest.size() > 1 ? -1 : strongest.get(0);
}
}
