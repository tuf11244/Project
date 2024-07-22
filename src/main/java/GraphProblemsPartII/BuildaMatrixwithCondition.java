/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 07/21/2024
 *https://leetcode.com/problems/build-a-matrix-with-conditions/
 * @author parth
 */
public class BuildaMatrixwithCondition {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
    
    int[] rowOrder = bfs(k,rowConditions);
    int[] colOrder = bfs(k,colConditions);

    for(int i = 1; i < rowOrder.length;i++){
        if(rowOrder[i] ==0 || colOrder[i] ==0){
            return new int[0][0];
        }
    }

     // Place elements in the matrix using HashMap to keep the sorted order
        int[][] answer = new int[k][k];
        Map<Integer, Integer> rowPosition = new HashMap<>();
        Map<Integer, Integer> colPosition = new HashMap<>();

        for (int i = 1; i <= k; i++) {
            rowPosition.put(rowOrder[i], i - 1);
            colPosition.put(colOrder[i], i - 1);
        }

        for (int i = 1; i <= k; i++) {
            answer[rowPosition.get(i)][colPosition.get(i)] = i;
        }

        return answer;
    }


    public static int[] bfs(int k, int[][] arr){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0; i <=k;i++){
            adj.add(new ArrayList<>());
        }


        int[] indegree = new int[k+1];

        for(int[] row : arr){
            int src = row[0];
            int nbg = row[1];
            indegree[nbg]++;
            adj.get(src).add(nbg);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < indegree.length;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int[] result = new int[k+1];
        int idx = 1;

        while(!queue.isEmpty()){
            int rem = queue.poll();
            result[idx] = rem;
            idx++;

            for(int nbrs : adj.get(rem)){
                indegree[nbrs]--;
                if(indegree[nbrs] == 0){
                    queue.add(nbrs);
                }
            }
        }
        return result;
    }
}
