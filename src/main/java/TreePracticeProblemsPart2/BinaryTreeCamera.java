/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;

/**
 *
 * @author parth
 */
public class BinaryTreeCamera {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Camera {
    private int camera; // Make it an instance variable

    public int minCameraCover(TreeNode root) {
        camera = 0; // Reset the camera count each time the method is called
        if (helper(root) == -1) {
            camera++;
        }
        return camera;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 1; // I am covered
        }

        int leftChild = helper(root.left);
        int rightChild = helper(root.right);

        if (leftChild == -1 || rightChild == -1) {
            camera++;
            return 0; // I have a camera
        }

        if (leftChild == 0 || rightChild == 0) {
            return 1; // I am covered
        }

        return -1; // I am not covered
    }
}

