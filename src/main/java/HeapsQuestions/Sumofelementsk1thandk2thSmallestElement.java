/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Date: 03/01/2024
 *https://www.geeksforgeeks.org/sum-elements-k1th-k2th-smallest-elements/
 * @author parth
 */
public class Sumofelementsk1thandk2thSmallestElement {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {10, 2, 50, 12, 48, 13};
        System.out.println(sum(arr,2,6));
    }
    public static int sum(int[] arr, int K1, int K2){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : arr){
            pq.add(x);
        }
        int sumUntilK1 = 0;
        List<Integer> list = new ArrayList<>();
        while(K1>0){
          sumUntilK1 = sumUntilK1 + pq.peek();
          list.add(pq.poll());
            K1--;
        }
        System.out.println(sumUntilK1);
        for(int y : list){
            pq.add(y);
        }
        System.out.println(pq);
        int sum = 0;
       while(K2-1 > 0){
            sum = sum + pq.peek();
            pq.poll();
            K2--;
        }
        System.out.println(pq);
        return sum - sumUntilK1;
    }
}
