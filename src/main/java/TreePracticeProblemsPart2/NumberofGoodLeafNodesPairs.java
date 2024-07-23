package TreePracticeProblemsPart2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

import java.util.*;
/**
 *Date: 07/18/2024
 *https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
 * @author parth
 */
public class NumberofGoodLeafNodesPairs {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}

class treeNode {
    int val;
    treeNode left;
    treeNode right;
    treeNode() {}
    treeNode(int val) { this.val = val; }
    treeNode(int val, treeNode left, treeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class GoodLeafNodes {
    public int countPairs(treeNode root, int distance) {
        // Create an undirected graph from the binary tree
        HashMap<treeNode, List<treeNode>> graph = new HashMap<>();
        Set<treeNode> leafNodes = new HashSet<>();

        makeGraph(graph, root, null, leafNodes);
        int pairs = 0;

        for (treeNode leaf : leafNodes) {
            Queue<pair> queue = new LinkedList<>();
            queue.add(new pair(leaf, 0));
            Set<treeNode> visited = new HashSet<>();

            while (!queue.isEmpty()) {
                pair current = queue.poll();

                if (current.level > distance) {
                    break;
                }

                if (current.level > 0 && current.level <= distance && leafNodes.contains(current.node)) {
                    pairs++;
                }

                if (visited.contains(current.node)) {
                    continue;
                }

                visited.add(current.node);

                for (treeNode neighbor : graph.getOrDefault(current.node, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        queue.add(new pair(neighbor, current.level + 1));
                    }
                }
            }
        }

        return pairs / 2;
    }

    public void makeGraph(HashMap<treeNode, List<treeNode>> graph, treeNode root, treeNode prev, Set<treeNode> leafNodes) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leafNodes.add(root); // Add the leaf nodes
        }

        if (prev != null) {
            // For the previous node
        if (!graph.containsKey(prev)) {
            graph.put(prev, new ArrayList<>());
        }
        graph.get(prev).add(root);

        // For the current node
        if (!graph.containsKey(root)) {
            graph.put(root, new ArrayList<>());
        }
        graph.get(root).add(prev);
        }

        makeGraph(graph, root.left, root, leafNodes);
        makeGraph(graph, root.right, root, leafNodes);
    }
}

class pair {
    treeNode node;
    int level;

    public pair(treeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

