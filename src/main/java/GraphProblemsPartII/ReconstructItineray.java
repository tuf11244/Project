/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *
 * @author parth
 */
public class ReconstructItineray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        List<String> l1 = new ArrayList<>();
        l1.add("JFK");
        l1.add("SFO");
        
        List<String> l2 = new ArrayList<>();
        l2.add("JFK");
        l2.add("ATL");
        
        List<String> l3 = new ArrayList<>();
        l3.add("SFO");
        l3.add("ATL");
        
        List<String> l4 = new ArrayList<>();
        l4.add("ATL");
        l4.add("JFK");
        
        List<String> l5 = new ArrayList<>();
        l5.add("ATL");
        l5.add("SFO");
        
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(l1);
        tickets.add(l2);
        tickets.add(l3);
        tickets.add(l4);
        tickets.add(l5);
        
       List<String> answer = findItinerary(tickets);
        
        System.out.println(answer);
    }
    public static List<String> findItinerary(List<List<String>> tickets) {
        //We create a Graph based of on our tickets string 
        //Key is the source airport 
        //PriorityQueue because we new sort the destination lexicographically
        HashMap<String,PriorityQueue<String>> hm = new HashMap<>();
        
        //Build the graph
        for(List<String> list : tickets){
            String src = list.get(0);
            String dest = list.get(1);
            if(hm.containsKey(src)){
                PriorityQueue<String> pq = hm.get(src);
                pq.add(dest);
            }else{
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(dest);
                hm.put(src, pq);
            }
        }
        
        List<String> answer = new ArrayList<>(); //our final answer
        
        dfs(hm,answer,"JFK");
        
        Collections.reverse(answer);
        
        return answer;
        
    }
    public static void dfs(HashMap<String,PriorityQueue<String>> hm, List<String> answer, String src){
          PriorityQueue<String> pq = hm.get(src);
          
          while(pq != null && !pq.isEmpty()){
              String nbg = pq.poll();
              dfs(hm,answer,nbg);
          }
          
          answer.add(src); //Its necessary that we add src during our backtracking phase
          //Because the first one that would be added in our answer list would be the last destination 
          //hence we reverse the array 
       }
        
   
}


