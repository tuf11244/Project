/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author parth
 */
public class KClosestElements {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {12,6,22,30,35,39,42,45,48,50,53,55,56};
        KClosestElements(arr,4,35);
    }
    public static void KClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(b-x) - Math.abs(a -x)); //max-heap
        for (int i : arr) {
            pq.add(i);
            //System.out.println(pq);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (pq.size() > 0) {
            System.out.print(pq.poll() + " ");
        }
    }
}
