/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/30/2024
 *https://leetcode.com/problems/get-watched-videos-by-your-friends/
 * @author parth
 */
public class GetWatchedVideosByYourFriends {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
       List<Integer>[] graph = new ArrayList[friends.length];
        
        // Build the graph
        for (int i = 0; i < friends.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < friends.length; i++) {
            for (int friend : friends[i]) {
                graph[i].add(friend);
                graph[friend].add(i);
            }
        }

        boolean[] visited = new boolean[friends.length];
        Queue<Q> queue = new LinkedList<>();
        Map<String, Integer> videoCount = new HashMap<>();
        
        queue.add(new Q(id, 0));
        visited[id] = true;
        
        while (!queue.isEmpty()) {
            Q rem = queue.poll();

            if (rem.level == level) {
                for (String video : watchedVideos.get(rem.v)) {
                    videoCount.put(video, videoCount.getOrDefault(video, 0) + 1);
                }
            } else if (rem.level < level) {
                for (int neighbor : graph[rem.v]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(new Q(neighbor, rem.level + 1));
                    }
                }
            }
        }

        List<String> result = new ArrayList<>(videoCount.keySet());
        result.sort((a, b) -> {
            int countA = videoCount.get(a);
            int countB = videoCount.get(b);
            if (countA == countB) {
                return a.compareTo(b);
            }
            return Integer.compare(countA, countB);
        });

        return result;
    }
}
class Q{
    int v;
    int level;
    
    public Q(int v, int level){
        this.v = v;
        this.level = level;
    }
}


