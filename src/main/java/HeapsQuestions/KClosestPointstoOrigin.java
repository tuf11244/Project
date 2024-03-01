/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *Date: 02/29/2024
 * https://leetcode.com/problems/k-closest-points-to-origin/description/
 * @author parth
 */
public class KClosestPointstoOrigin {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] points = {
            {1,3},
            {-2,2}
        };
        int[][] answer = kClosest(points,1);
        
        for(int[] arr : answer){
            System.out.println(Arrays.toString(arr));
        }
    }
    
    public static int[][] kClosest(int[][] points, int k){
        PriorityQueue<Element> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < points.length;i++){
            int x = points[i][0];
            int y = points[i][1];
            pq.add(new Element(x,y));
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int[][] answer = new int[pq.size()][2];
        int index = 0;
        while(!pq.isEmpty()){
            Element remove = pq.poll();
            answer[index][0] = remove.x;
            answer[index][1] = remove.y;
            index++;
        }
        return answer;
    }
}
class Element implements Comparable<Element> {
    int x;
    int y;
    double distance;

    Element(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = Math.sqrt((x * x) + (y * y));
    }

    @Override
    public int compareTo(Element o) {
        return Double.compare(this.distance, o.distance);
    }
}

