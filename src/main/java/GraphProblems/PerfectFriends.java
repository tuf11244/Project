/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *Date: 04/24/2024
 * https://www.geeksforgeeks.org/number-groups-formed-graph-friends/
 * This question is based on the getConnectedComponets logic 
 * We just have to find the number of pairs we can form such that no 2 friends are from the same club;
 * @author parth
 */
public class PerfectFriends {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of the friends ");
        int vertex = scanner.nextInt(); //friends is nothing but vertex in this case
        scanner.nextLine();
        System.out.println("Please enter the number of connected information "); //this is nothing but edges in this case
        int edges = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the the information about the connections ");
        String[] parts = new String[edges];
        for(int i = 0; i < edges;i++){
            parts[i] = scanner.nextLine();
        }
        
        //Build our adjacencyList
        buildTheGraph(vertex,edges,parts);
    }
    public static void buildTheGraph(int vertex, int edges, String[] parts){
        List<Friends> graphs[] = new ArrayList[vertex];
        
        for(int i = 0; i < vertex;i++){
            graphs[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges;i++){
            String[] part = parts[i].split(" ");
            int vertex1 = Integer.parseInt(part[0]);
            int vertex2 = Integer.parseInt(part[1]);
            
            graphs[vertex1].add(new Friends(vertex1, vertex2));
            graphs[vertex2].add(new Friends(vertex2, vertex1));
        }
        
        List<List<Integer>> answer = new ArrayList<>(); //this will have out connected components list 
        boolean[] visited = new boolean[vertex];
        for(int i = 0; i < vertex;i++){
            if(visited[i] == false){
                List<Integer> comp = new ArrayList<>();
                function1(comp,visited,graphs,i);
                answer.add(comp);
            }
        }
        
        //Print the list of connected components 
        for(List<Integer> list : answer){
            System.out.println(list);
        }
        
        int pairs = 0;
        
        for(int i = 0; i < answer.size();i++){
            for(int j = i+1; j < answer.size();j++){
                int count = answer.get(i).size() * answer.get(j).size();
                pairs = pairs + count;
            }
        }
        
        System.out.println("The number of ways we can form pairs such that no two belong to the same group is " + pairs);
    }
    
    public static void function1(List<Integer> comp, boolean[] visited, List<Friends> graphs[], int src){
        visited[src] = true;
        comp.add(src);
        
        for(Friends frd : graphs[src]){
            if(visited[frd.vertex2] == false){
                function1(comp,visited,graphs,frd.vertex2);
            }
        }
    }
}

class Friends{
    int vertex1;
    int vertex2;
    
    public Friends(int vertex1, int vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }
}
