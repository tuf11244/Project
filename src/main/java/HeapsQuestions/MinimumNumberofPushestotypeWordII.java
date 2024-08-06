/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;
import java.util.*;
/**
 *Date: 08/052024
 * https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/
 * @author parth
 */
public class MinimumNumberofPushestotypeWordII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int minimumPushes(String word) {
        
        int[] map = new int[26];

        for(int i = 0; i < word.length();i++){
            map[word.charAt(i) - 'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < map.length;i++){
             pq.add(map[i]);
        }
        int answer = 0;
        int count = 0;
        while(!pq.isEmpty()){
            int rem = pq.poll();
            count++;
            if(count <= 8){
              answer = answer + rem * 1;
            }else if(count > 8 && count <= 16){
              answer = answer + rem * 2;
            }else if(count > 16 && count <= 24){
                answer = answer + rem * 3;
            }else{
                answer = answer + rem * 4;
            }
        }
        return answer;
    }
}
