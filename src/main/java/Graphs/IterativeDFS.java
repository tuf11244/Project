/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Graphs;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
/**
 *Date: 04/27/2024
 * @author parth
 */
public class IterativeDFS {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of vertices ");
        int vertices = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the number of edges ");
        int edges = scanner.nextInt();
        scanner.nextLine();
        String[] paths = new String[edges];
        System.out.println("Please enter the information ");
        for(int i = 0; i < edges; i++){
            paths[i] = scanner.nextLine();
           // System.out.println(paths[i]);
        }
        
        build(vertices, edges, paths);
    }
    public static void build(int vertices, int edges, String[] paths){
        List<st> [] graph = new ArrayList[vertices];
        for(int i = 0; i < vertices;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges;i++){
            String[] path = paths[i].split(" ");
            int src = Integer.parseInt(path[0]);
            int nbg = Integer.parseInt(path[1]);
            
            graph[src].add(new st(src,nbg));
            graph[nbg].add(new st(nbg,src));
        }
        
        Scanner scanner = new Scanner(System.in);
        boolean[] visited = new boolean[vertices];
        System.out.println("Enter the soure ");
        int source = scanner.nextInt();
        Stack<stpair> stack = new Stack<>();
        stack.push(new stpair(source,source + ""));
        
        while(!stack.empty()){
            stpair rem = stack.pop();
            
            if(visited[rem.v] == true){
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem.v +  " @ " + rem.psf);
            
            for(st s : graph[rem.v]){
                if(visited[s.nbg] == false){
                    stack.push(new stpair(s.nbg,rem.psf + s.nbg));
                }
                
            }
        }
        
    }
}
class stpair{
    int v;
    String psf;
    
    public stpair(int v, String psf){
        this.v = v;
        this.psf = psf;
    }
    
}
class st{
    int src;
    int nbg;
    
    public st(int src, int nbg){
        this.src = src;
        this.nbg = nbg;
    }
}
