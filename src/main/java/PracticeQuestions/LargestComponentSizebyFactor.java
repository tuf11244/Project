/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PracticeQuestions;
import java.util.*;
/**
 *Date: 06/01/2024
 *https://leetcode.com/problems/largest-component-size-by-common-factor/
 * @author parth
 */
public class LargestComponentSizebyFactor {

    /**
     * @param args the command line arguments
     */
    public static int[] parent;
    public static int[] rank;
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public  static int largestComponentSize(int[] nums) {
        int maxVal = Arrays.stream(nums).max().getAsInt(); //gets the maxvalue in nums
        parent = new int[maxVal + 1];
        rank = new int[maxVal + 1];
        
        for (int i = 0; i <= maxVal; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int num : nums) {
            List<Integer> factors = getPrimeFactors(num);
            for (int factor : factors) {
                union(num, factor);
            }
        }

        Map<Integer, Integer> componentSize = new HashMap<>();
        int maxSize = 0;

        for (int num : nums) {
            int root = find(num);
            componentSize.put(root, componentSize.getOrDefault(root, 0) + 1);
            maxSize = Math.max(maxSize, componentSize.get(root));
        }

        return maxSize;
        
    }
    
    public static List<Integer> getPrimeFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        int factor = 2;
        while (factor * factor <= num) {
            if (num % factor == 0) {
                factors.add(factor);
                while (num % factor == 0) {
                    num /= factor;
                }
            }
            factor++;
        }
        if (num > 1) {
            factors.add(num);
        }
        return factors;
    }
   
    
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
    
    public static void union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if (lx != ly) {
            if (rank[lx] > rank[ly]) {
                parent[ly] = lx;
            } else if (rank[lx] < rank[ly]) {
                parent[lx] = ly;
            } else {
                parent[ly] = lx;
                rank[lx]++;
            }
        }
    }
}