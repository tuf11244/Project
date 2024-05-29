/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;

/**
 *Date: 05/28/2024
 * https://leetcode.com/problems/find-the-town-judge/
 * @author parth
 */
public class Findthetownjudge {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int findJudge(int n, int[][] trust) {
       int[] indegree = new int[n+1];
       int[] outdegree = new int[n+1];

       //Fill the indegree Arrays
       for(int[] t : trust){
         int src = t[0];
         int nbg = t[1];
         indegree[nbg]++;
         outdegree[src]++;
       }

       int judge = -1;
       for(int i = 1; i < indegree.length;i++){
         if(indegree[i] == n-1){
            judge = i; //potential judge
         }
       }
       if(judge == -1){
        return -1;
       }

       if(outdegree[judge] == 0){
        return judge;
       }

       return -1;
    }
}
