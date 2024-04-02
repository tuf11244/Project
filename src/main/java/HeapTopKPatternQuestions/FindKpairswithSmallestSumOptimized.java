/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapTopKPatternQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Date: 04/01/2024
 *https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * @author parth
 */
public class FindKpairswithSmallestSumOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        List<List<Integer>> answer = kpairs(nums1,nums2,2);
        for(List<Integer> element : answer){
           System.out.println(element);
       }
    }
    
    public static List<List<Integer>> kpairs(int[] nums1, int[] nums2, int k){
        int m = nums1.length;
        int n = nums2.length;
        PriorityQueue<Pairs<Integer, Pairs<Integer, Integer>>> pq = new PriorityQueue<>();
        Set<Pairs<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pairs<>(0, 0));
        int sum = nums1[0] + nums2[0];
        pq.add(new Pairs<>(sum, new Pairs<>(0, 0)));
        List<List<Integer>> result = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            Pairs<Integer, Pairs<Integer, Integer>> temp = pq.poll();
            int i = temp.getValue().getKey();
            int j = temp.getValue().getValue();
            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < n && !visited.contains(new Pairs<>(i, j + 1))) {
                pq.add(new Pairs<>(nums1[i] + nums2[j + 1], new Pairs<>(i, j + 1)));
                visited.add(new Pairs<>(i, j + 1));
            }

            if (i + 1 < m && !visited.contains(new Pairs<>(i + 1, j))) {
                pq.add(new Pairs<>(nums1[i + 1] + nums2[j], new Pairs<>(i + 1, j)));
                visited.add(new Pairs<>(i + 1, j));
            }
        }
        return result;
    }
}

class Pairs<K extends Comparable<K>, V> implements Comparable<Pairs<K, V>> {
    private final K key;
    private final V value;

    public Pairs(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public int compareTo(Pairs<K, V> other) {
        return this.key.compareTo(other.getKey());
    }
}

