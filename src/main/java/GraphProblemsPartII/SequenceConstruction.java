/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 * https://leetcode.com/problems/sequence-reconstruction/
 *Date: 06/05/2024
 * @author parth
 */
public class SequenceConstruction {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] original = {1,2,3};
        int[][] sequences = {
            {1,2}
        };
        boolean answer = sequenceReconstruction(original,sequences);
        System.out.println(answer);
    }
    
    public static boolean sequenceReconstruction(int[] original, int[][] sequences){
        int[] indegree = new int[original.length+1]; //as the nodes start from 1
        
        
        List<Pair5> [] graph = new ArrayList[original.length+1];
        for(int i =0; i < graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        
        //Build the graph
        for(int[] sequence : sequences){
            for(int i =0; i < sequence.length-1;i++){
                 int src = sequence[i];
                 int nbg = sequence[i+1];
                 graph[src].add(new Pair5(src,nbg));
                 indegree[nbg]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        List<Integer> list = new ArrayList<>();
        for(int i =1; i < indegree.length;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
       // System.out.println(Arrays.toString(indegree));
        while(!queue.isEmpty()){
            
            if(queue.size() > 1){
                return false;  //// Multiple sources indicate non-unique ordering
            }
            
            int rem = queue.poll();
            list.add(rem);
            
            for(Pair5 p : graph[rem]){
                indegree[p.nbg]--;
                if(indegree[p.nbg] == 0){
                    queue.add(p.nbg);
                }
            }
            
        }
        
        //// Check if the topological order matches the original sequence
        if(list.size() != original.length){
            return false; //Incomplete Reconstruction
        }
        for(int i =0; i < original.length;i++){
            if(list.get(i)!= original[i]){
                return false; //Ordering different
            }
        }
        
       return  true; 
    }
}
class Pair5{
    int src;
    int nbg;
    
    public Pair5(int src, int nbg){
        this.src = src;
        this.nbg = nbg;
    }
}
