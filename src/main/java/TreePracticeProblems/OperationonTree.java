/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;
import java.util.*;
/**
 *Date: 04/02/2025
 * @author parth
 */
//https://leetcode.com/problems/operations-on-tree/
class LockingTree {
    HashMap<Integer, Integer> locked;
    int[] parents;
    HashMap<Integer, List<Integer>> parentMap;

    public LockingTree(int[] parent) {
        locked = new HashMap<>();
        parents = parent;
        parentMap = new HashMap<>();

        // Build parent-child mapping once
        for (int i = 0; i < parent.length; i++) {
            parentMap.putIfAbsent(parent[i], new ArrayList<>());
            parentMap.get(parent[i]).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (locked.containsKey(num)) {
            return false;
        }
        locked.put(num, user);
        return true;
    }

    public boolean unlock(int num, int user) {
        if (!locked.containsKey(num) || locked.get(num) != user) {
            return false;
        }
        locked.remove(num);
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (locked.containsKey(num)) return false; // Node must be unlocked
        if (getLockedAncestors(num) > 0) return false; // No locked ancestor condition
        if (getLockedDescendants(num) == 0) return false; // At least one locked descendant

        // Unlock all locked descendants
        List<Integer> lockedNodes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (locked.containsKey(node)) {
                lockedNodes.add(node);
            }
            if (parentMap.containsKey(node)) {
                queue.addAll(parentMap.get(node));
            }
        }

        // Remove locked descendants
        for (int node : lockedNodes) {
            locked.remove(node);
        }

        // Lock the current node
        locked.put(num, user);
        return true;
    }

    private int getLockedDescendants(int num) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (locked.containsKey(node)) count++;
            if (parentMap.containsKey(node)) {
                queue.addAll(parentMap.get(node));
            }
        }
        return count;
    }

    private int getLockedAncestors(int num) {
        int count = 0;
        int ancestor = parents[num];

        while (ancestor != -1) {
            if (locked.containsKey(ancestor)) count++;
            ancestor = parents[ancestor];
        }
        return count;
    }
}

public class OperationonTree{
	public static void main(String[] args) {
	System.out.println("Hello World");
		int[] parent = {-1, 0, 0, 1, 1, 2, 2};
		LockingTree tree = new LockingTree(parent);
		System.out.println(tree.lock(2, 2)); // Output: true (node 2 is locked by user 2)
        System.out.println(tree.unlock(2, 2)); // Output: true (node 2 is unlocked by user 2)
        System.out.println(tree.upgrade(2, 2)); // Output: false (upgrade fails as per the conditions)
		
	}
}
