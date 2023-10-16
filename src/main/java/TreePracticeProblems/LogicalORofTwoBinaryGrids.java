/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

/**
 *
 * @author parth
 */
//https://leetcode.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/
public class LogicalORofTwoBinaryGrids {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

class Solution {
    private Node root;

    public Solution(Node root) {
        this.root = root;
    }

    public Node intersect(Node quadTree1, Node quadTree2) {
        return intersectHelper(quadTree1, quadTree2);
    }

    private Node intersectHelper(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) {
            return quadTree1.val ? quadTree1 : quadTree2;
        }
        if (quadTree2.isLeaf) {
            return quadTree2.val ? quadTree2 : quadTree1;
        }

        Node topLeft = intersectHelper(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersectHelper(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersectHelper(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersectHelper(quadTree1.bottomRight, quadTree2.bottomRight);

        // If all children are leaves and have the same value, merge them into a single leaf node
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        }

        // Otherwise, create a non-leaf node with merged children
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public static class Node {
        boolean val;
        boolean isLeaf;
        Node topLeft;
        Node topRight;
        Node bottomLeft;
        Node bottomRight;

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
