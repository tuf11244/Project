/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart3;
import java.util.*;
/**
 *Date: 12/24/2024
 * //https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/
 * @author parth
 */
public class MinimumNumberofOperationstoSortaBinaryTreebyLevel extends TreeNodes {
    public int count;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int minimumOperations(TreeNode root) {
        count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
          int level = queue.size();
          int[] arr = new int[level];
          for(int i = 0;  i < level;i++){
                TreeNode rem = queue.poll();

                arr[i] = rem.val;

                if(rem.left != null){
                    queue.add(rem.left);
                }

                if(rem.right != null){
                    queue.add(rem.right);
                }
           }

           swaps(arr);
        }

        return count;

    }

    public void swaps(int[] arr) {
    int n = arr.length;
    int[] sortedArray = Arrays.copyOf(arr, n);
    Arrays.sort(sortedArray);

    // Map original indices of the sorted array
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
        indexMap.put(sortedArray[i], i);
    }

    boolean[] visited = new boolean[n]; // Keep track of visited indices

    for (int i = 0; i < n; i++) {
        if (visited[i] || indexMap.get(arr[i]) == i) {
            continue; // Already in the correct position or visited
        }

        // Cycle detection
        int cycleSize = 0;
        int current = i;
        while (!visited[current]) {
            visited[current] = true;
            current = indexMap.get(arr[current]);
            cycleSize++;
        }

        // For a cycle of size k, we need k-1 swaps
        if (cycleSize > 1) {
            count += cycleSize - 1;
        }
    }
  }
}   
