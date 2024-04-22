package TreePracticeProblems;


//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
//Date: 04/21/2024
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
    KNode root;
    private int k;

    public Solution() {
        this.k = 3;
    }

    public List<Integer> distanceK(KNode root, KNode target, int k) {
        HashMap<KNode, KNode> parentMap = new HashMap<>();
        populateParentMap(root, null, parentMap);
        
        List<Integer> result = new ArrayList<>();
        Set<KNode> visited = new HashSet<>();
        findNodesAtDistanceK(target, k, parentMap, result, visited);
        
        return result;
    }
    
    private void populateParentMap(KNode node, KNode parent, HashMap<KNode, KNode> parentMap) {
        if (node == null) return;
        
        parentMap.put(node, parent);
        populateParentMap(node.left, node, parentMap);
        populateParentMap(node.right, node, parentMap);
    }
    
    private void findNodesAtDistanceK(KNode node, int k, HashMap<KNode, KNode> parentMap, List<Integer> result, Set<KNode> visited) {
        if (node == null || visited.contains(node)) return;
        
        visited.add(node);
        if (k == 0) {
            result.add(node.value);
            return;
        }
        
        // Explore left, right, and parent nodes
        findNodesAtDistanceK(node.left, k - 1, parentMap, result, visited);
        findNodesAtDistanceK(node.right, k - 1, parentMap, result, visited);
        KNode parentNode = parentMap.get(node);
        findNodesAtDistanceK(parentNode, k - 1, parentMap, result, visited);
    }
    public void insert(Scanner scanner) {
        System.out.println("Enter the root value ");
        int value = scanner.nextInt();
        root = new KNode(value);
        insert(root, scanner);
    }

    private void insert(KNode node, Scanner scanner) {
        System.out.println("Do you want to enter value to the left of " + node.value);
        int leftValue = scanner.nextInt();
        if (leftValue != -1) {
            node.left = new KNode(leftValue);
            insert(node.left, scanner);
        }

        System.out.println("Do you want to enter value to the right of " + node.value);
        int rightValue = scanner.nextInt();
        if (rightValue != -1) {
            node.right = new KNode(rightValue);
            insert(node.right, scanner);
        }
    }

    public class KNode {
        int value;
        KNode left;
        KNode right;

        public KNode(int value) {
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
        
    }
}
