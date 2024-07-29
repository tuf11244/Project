package GraphProblemsPartII;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.*;
/**
 *Date: 07/26/2024
 * https://leetcode.com/problems/minimum-cost-to-convert-string-i/
 * @author parth
 */
public class MinimumCosttoConvertStringI {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
         char[] original = {'a','b','c','c','e','d'};
         char[] changed = {'b','c','b','e','b','e'};
         int[] cost = {2,5,5,1,2,20};
         
         long answer = minimumCost("abcd","acbe",original,changed,cost);
         System.out.println(answer);
         
    }
    
     public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        
        HashMap<Character,List<Y>> graph = new HashMap<>();
        
        for(int i = 0; i < original.length;i++){
            if(graph.containsKey(original[i]) == true){
                List<Y> list = graph.get(original[i]);
                list.add(new Y(original[i],changed[i],cost[i]));
                
            }else{
                List<Y> list = new ArrayList<>();
                list.add(new Y(original[i],changed[i],cost[i]));
                graph.put(original[i], list);
            }
        }
         long totalCost = 0;
         HashMap<Character,List<X>> hm = new HashMap<>();
         for(int i = 0; i < source.length();i++){
             
             if(source.charAt(i)!= target.charAt(i)){
                 long c = djikstras(source.charAt(i),target.charAt(i),hm,graph);
                 
                 if(c == -1){
                     return -1;
                 }
                 totalCost = totalCost + c;
             }
         }
         
         
         return totalCost;
    }
     
    public static long djikstras(char src, char target, HashMap<Character,List<X>> hm,HashMap<Character,List<Y>> graph){
        HashSet<Character> visited = new HashSet<>();
        
        long cost = 0;
        
        if(hm.containsKey(src)){
            for(X p : hm.get(src)){
                if(p.c == target){
                    return p.cost;
                }
            }
        }
        
        PriorityQueue<X> pq = new PriorityQueue<>();
        pq.add(new X(src,0));
        
        while(!pq.isEmpty()){
            X rem = pq.poll();
            System.out.println(rem);
            
            if(rem.c == target){
                //First add it to our hashmap to avoid re-calculations 
                List<X> list = hm.getOrDefault(src,new ArrayList<>());
                list.add(new X(rem.c,rem.cost));
                hm.put(src,list);
                
                return rem.cost;
            }
            
            if(visited.contains(rem.c) || graph.containsKey(rem.c) == false){
                continue;
            }
            visited.add(rem.c);
            
            for(Y e : graph.get(rem.c)){
                if(visited.contains(e.nbg) == false){
                    pq.add(new X(e.nbg,rem.cost + e.cost));
                }
            }
            
        }
        
        return -1;
        
    }
}

class X implements Comparable<X>{
    char c;
    long cost;
    
    public X(char c, long cost){
        this.c = c;
        this.cost = cost;
    }

    @Override
    public int compareTo(X o) {
        return (int) (this.cost - o.cost);
    }

    @Override
    public String toString() {
        return "Pair{" + "c=" + c + ", cost=" + cost + '}';
    }
    
}




class Y{
    char src;
    char nbg;
    long cost;
     
    public Y(char src, char nbg, long cost){
        this.src = src;
        this.nbg = nbg;
        this.cost = cost;
    }
}
