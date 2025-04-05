/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TreePracticeProblemsPart3;
import java.util.*;
/**
 *Date: 04/04/2025
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 * @author parth
 */
public class LowestCommonAncestorofDeepestLeaves extends TreeNodes {
    public static void main(String[] args) {
        
    }
    public TreeNode LCA;
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        List<TreeNode> list = bfs(root); // Function to get the lowest leaves of the node
        LCA = null;

        if (list.size() == 1) {
            return list.get(0);
        }
        
        getLCA(root, list.get(0), list.get(list.size() - 1));

        return LCA;
    }

    public boolean getLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean self = (root == p) || (root == q);
        boolean left = getLCA(root.left, p, q);
        boolean right = getLCA(root.right, p, q);

        if ((left && right) || (self && left) || (self && right)) {
            LCA = root;
        }

        return self || left || right;
    }

    public List<TreeNode> bfs(TreeNode root) {
        Queue<NodeDepthPair> queue = new LinkedList<>();
        queue.add(new NodeDepthPair(root, 0));

        HashMap<Integer, List<TreeNode>> hm = new HashMap<>();
        int maxDepth = 0;

        while (!queue.isEmpty()) {
            NodeDepthPair rem = queue.poll();

            // It's a leaf node
            if (rem.root.left == null && rem.root.right == null) {
                if (rem.depth > maxDepth) {
                    maxDepth = rem.depth;
                    hm.put(maxDepth, new ArrayList<>(List.of(rem.root)));
                } else if (rem.depth == maxDepth) {
                    hm.computeIfAbsent(maxDepth, k -> new ArrayList<>()).add(rem.root);
                }
            }

            if (rem.root.left != null) {
                queue.add(new NodeDepthPair(rem.root.left, rem.depth + 1));
            }

            if (rem.root.right != null) {
                queue.add(new NodeDepthPair(rem.root.right, rem.depth + 1));
            }
        }

        return hm.get(maxDepth);
    }
}

class NodeDepthPair {
    TreeNode root;
    int depth;

    public NodeDepthPair(TreeNode root, int depth) {
        this.root = root;
        this.depth = depth;
    }
}
