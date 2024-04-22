package TreePracticeProblems;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Solution {
    Node root;
    private int k;

    public Solution() {
        this.k = 3;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        populateParentMap(root, null, parentMap);
        
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        findNodesAtDistanceK(target, k, parentMap, result, visited);
        
        return result;
    }
    
    private void populateParentMap(TreeNode node, TreeNode parent, HashMap<TreeNode, TreeNode> parentMap) {
        if (node == null) return;
        
        parentMap.put(node, parent);
        populateParentMap(node.left, node, parentMap);
        populateParentMap(node.right, node, parentMap);
    }
    
    private void findNodesAtDistanceK(TreeNode node, int k, HashMap<TreeNode, TreeNode> parentMap, List<Integer> result, Set<TreeNode> visited) {
        if (node == null || visited.contains(node)) return;
        
        visited.add(node);
        if (k == 0) {
            result.add(node.val);
            return;
        }
        
        // Explore left, right, and parent nodes
        findNodesAtDistanceK(node.left, k - 1, parentMap, result, visited);
        findNodesAtDistanceK(node.right, k - 1, parentMap, result, visited);
        TreeNode parentNode = parentMap.get(node);
        findNodesAtDistanceK(parentNode, k - 1, parentMap, result, visited);
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
