/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 06/11/2024
 * https://leetcode.com/problems/largest-component-size-by-common-factor/
 * @author parth
 */
public class LargestComponentSizeByCommonFactor {

    /**
     * @param args the command line arguments
     */
    public static int[] parent;
    public static int[] rank;
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int largestComponentSize(int[] nums){
        //Find the max number in the nums array
        int max = -1;
        for(int i = 0; i < nums.length;i++){
            max = Math.max(nums[i],max);
        }
        
        //Intialize the parent and the rank arrays 
        parent = new int[max+1]; //due to zero based indexing
        rank = new int[max+1];
        for(int i =0; i <= max;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        //Find the factors larger than 1
        for(int i=0; i < nums.length;i++){
            for(int k = 2; k <= Math.sqrt(nums[i]);k++){
                if(nums[i] % k == 0){
                    union(nums[i],k);
                    union(nums[i],nums[i]/k);
                }
            }
        }
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i =0; i < nums.length;i++){
            int p = find(nums[i]);
            hm.put(p,hm.getOrDefault(p,0)+1);
        }
        int count = 0;
        for(int value : hm.values()){
            count = Math.max(value,count);
        }
        return count;
    }
    
    public static void union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx;
            }else if(rank[lx] < rank[ly]){
                parent[lx] = ly;
            }else{
                parent[lx] = ly;
                rank[ly]++;
            }
        }
    }
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
}
