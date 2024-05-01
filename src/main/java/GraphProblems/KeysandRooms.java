/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.ArrayList;
import java.util.List;

/**
 *https://leetcode.com/problems/keys-and-rooms/
 * @author parth
 */
public class KeysandRooms {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean visited[] = new boolean[rooms.size()];
        for(int v = 0; v < rooms.size();v++){
            if(visited[v] == false){
                List<Integer> temp = new ArrayList<>();
                dfs(temp,rooms,visited,v);
                answer.add(temp);
            }
        }
        for(List<Integer> x : answer){
            System.out.println(x);
        }
        return answer.size() == 1;


    }
    public static void dfs(List<Integer> temp,List<List<Integer>> rooms,boolean[] visited, int v){
        visited[v] = true;
        temp.add(v);
         for(Integer room : rooms.get(v)){
            if(visited[room] == false){
                 dfs(temp, rooms, visited, room);
            }
        }
    }
}
