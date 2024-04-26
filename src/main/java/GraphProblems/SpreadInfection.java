/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
/**
 *
 * @author parth
 */
public class SpreadInfection {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of vertices ");
        int vertices = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the number of edges ");
        int edges = scanner.nextInt();
        String[] paths = new String[edges];
        System.out.println("Please enter the information ");
        for(int i =0; i < edges;i++){
            paths[i] = scanner.nextLine();
        }
        
        //build the graph or adjaceny list
         buildInfection(edges,vertices,paths);
    }
    
    public static void buildInfection(int edges, int vertices, String[] paths){
        List<Lines> [] graph = new ArrayList[vertices];
        
        for(int i =0; i < vertices;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges;i++){
            String[] part = paths[i].split(" ");
            int src = Integer.parseInt(part[0]);
            int nbg = Integer.parseInt(part[1]);
            
            graph[src].add(new Lines(src, nbg));
            graph[nbg].add(new Lines(nbg,src));
            
        }
        
        int[] visited = new int[vertices];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the source vertex");
        int src = scanner.nextInt();
        System.out.println("Please enter the time ");
        int time = scanner.nextInt();
        
        int count = countInfectedPeople(graph,visited,src,time);
        
    }
    
    public static int countInfectedPeople(List<Lines>[] graph, int[] visited, int src, int time){
        Queue<Infections> queue = new LinkedList<>();
        queue.add(new Infections(src,1));
        int count = 0;
        while(!queue.isEmpty() ){
            Infections rem = queue.poll();
            
            if(visited[rem.v] > 0){
                continue; //means the person has already fallen sick before
            }
            visited[rem.v] = rem.time;
            if(rem.time > time){
                break;
            }
            count++;
            
            for(Lines l : graph[rem.v]){
                if(visited[l.nbg] == 0){
                    queue.add(new Infections(l.nbg,rem.time+1));
                }
            }
        }
        return count;
        
    }
}
class Infections{
    int v;
    int time;
    
    public Infections(int v,int time){
        this.v = v;
        this.time = time;
    }
   
}

class Lines{
    int src;
    int nbg;
    
    public Lines(int src, int nbg){
        this.src = src;
        this.nbg = nbg;
    }
}
