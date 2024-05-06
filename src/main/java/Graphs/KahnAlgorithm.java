/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *Date: 05/05/2024
 * @author parth
 */
public class KahnAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Please enter the number of vertices ");
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the number of edges ");
        int edges = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the information ");
        String[] paths = new String[edges];
        for(int i = 0; i < edges;i++){
            paths[i] = scanner.nextLine();
        }
        
        buildtheGraph(vertices,edges,paths);
        
    }
    public static void buildtheGraph(int vertices, int edges, String[] paths){
        List<vPair> [] graph = new ArrayList[vertices];
        for(int i = 0; i < vertices;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges;i++){
            String[] path = paths[i].split(" ");
            int src = Integer.parseInt(path[0]);
            int nbg = Integer.parseInt(path[1]);
            
            graph[src].add(new vPair(src, nbg));
        }
        System.out.println(Arrays.toString(graph));
        
        List<Integer> answer = KahnsAlgo(vertices,graph);
        System.out.println(answer);
    }
    
    public static List<Integer> KahnsAlgo(int vertices, List<vPair> [] graph){
        int[] indegree = new int[vertices];
        
        //traveling on all vertices to fill our indegree array
        for(int i =0; i < vertices;i++){
            List<vPair> list = graph[i];
             for(vPair rem : list){
                 indegree[rem.nbg]++;
             }
        }
        //System.out.println(Arrays.toString(indegree));
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        //Add the vertices with 0 incoming degrees in our queue
        for(int i = 0; i < vertices;i++){
            //WE ONLY ADD OUR VERTICES IN QUEUE IS THERE INDEGREE IS 0
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int rem = queue.poll();
            
            //add it in out answer
            answer.add(rem);
            
            List<vPair> list = graph[rem];
            //Decrease the indegree of the neigbours of the source that we just removed
            for(vPair p : list){
                indegree[p.nbg]--;
                if(indegree[p.nbg] == 0){
                    //add it in out queue 
                    queue.add(p.nbg);
                }
            }           
           
        }
        if(answer.size() == vertices){
            return answer;
        }
       
        return null;
    }
}


class vPair{
    int src;
    int nbg;
    
    public vPair(int src, int nbg){
        this.src = src;
        this.nbg = nbg;
    }

    @Override
    public String toString() {
        return "Pair{" + "src=" + src + ", nbg=" + nbg + '}';
    }
    
}
