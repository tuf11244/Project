package TreePracticeProblems;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    Node root;
    private int k;

    public Solution() {
        this.k = 3;
    }

    public List<Integer> distance(Node target, int k) {
        List<Integer> result = new ArrayList<>();
        findNodesAtDistanceK(root, target, k, result);
        return result;
    }

    private int findNodesAtDistanceK(Node node, Node target, int k, List<Integer> result) {
    // Base case: If the current node is null, return -1
    if (node == null) {
        return -1;
    }

    // If the current node is the target node, collect nodes at distance K from it
    if (node == target) {
        collectNodesAtKDistance(node, k, result);
        return 0;
    }

    // Recursive DFS on the left subtree to find the target node
    int left = findNodesAtDistanceK(node.left, target, k, result);

    // If the target node is found in the left subtree
    if (left >= 0) {
        // If the current node is at distance K from the target, add its value to the result list
        if (left + 1 == k) {
            result.add(node.value);
        }
        // Explore the right subtree to find nodes at distance K - left - 2
        collectNodesAtKDistance(node.right, k - left - 2, result);
        // Return the depth of the target node in the left subtree + 1
        return left + 1;
    }
    
    // If the target node is not found in the left subtree, explore the right subtree
    int right = findNodesAtDistanceK(node.right, target, k, result);

    // If the target node is found in the right subtree
    if (right >= 0) {
        // If the current node is at distance K from the target, add its value to the result list
        if (right + 1 == k) {
            result.add(node.value);
        }
        // Explore the left subtree to find nodes at distance K - right - 2
        collectNodesAtKDistance(node.left, k - right - 2, result);
        // Return the depth of the target node in the right subtree + 1
        return right + 1;
    }

    // If the target node is not found in the current subtree, return -1
    return -1;
}


    private void collectNodesAtKDistance(Node node, int k, List<Integer> result) {
        if (node == null || k < 0) {
            return;
        }
        if (k == 0) {
            result.add(node.value);
            return;
        }

        collectNodesAtKDistance(node.left, k - 1, result);
        collectNodesAtKDistance(node.right, k - 1, result);
    }

    public void insert(Scanner scanner) {
        System.out.println("Enter the root value ");
        int value = scanner.nextInt();
        root = new Node(value);
        insert(root, scanner);
    }

    private void insert(Node node, Scanner scanner) {
        System.out.println("Do you want to enter value to the left of " + node.value);
        int leftValue = scanner.nextInt();
        if (leftValue != -1) {
            node.left = new Node(leftValue);
            insert(node.left, scanner);
        }

        System.out.println("Do you want to enter value to the right of " + node.value);
        int rightValue = scanner.nextInt();
        if (rightValue != -1) {
            node.right = new Node(rightValue);
            insert(node.right, scanner);
        }
    }

    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}

public class AllNodesDistanceKinBinaryTree {
    public static void main(String args[]) {
        Solution tree = new Solution();
        Scanner scanner = new Scanner(System.in);

        tree.insert(scanner);
        // Set the target node (you need to implement this logic)
        Solution.Node targetNode = tree.root.left;
        List<Integer> answer = tree.distance(targetNode, 4);

        System.out.println(answer);
    }
}
