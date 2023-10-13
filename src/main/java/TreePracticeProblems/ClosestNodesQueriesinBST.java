/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *Date: 10/12/2023
 * https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/
 * @author parth
 */
public class ClosestNodesQueriesinBST {

   
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Solution4 tree = new Solution4();
        tree.insert(scanner);
        
        List<Integer> queries = new ArrayList<>();
        queries.add(2);
        queries.add(5);
        queries.add(16);
        List<List<Integer>> answer = tree.closestNodes(queries);
        for(List<Integer> element : answer){
            System.out.println(element);
        }
        
        // TODO code application logic here
    }
}
class Solution4{
    private Node root;
    public Solution4(){
        
    }
    public void insert(Scanner scanner){
        System.out.println("Enter the root value ");
        int value = scanner.nextInt();
        root = new Node(value);
        insert(root,scanner);
    }
    private void insert(Node node, Scanner scanner){
        System.out.println("Do you want to enter value to the left of " + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value to the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            insert(node.left,scanner);
        }
        System.out.println("Do you want to enter value to the right of " + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value to the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            insert(node.right,scanner);
        }
    }
    public List<List<Integer>> closestNodes(List<Integer> queries) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int query : queries) {
            Node currentNode = root;
            List<Integer> closestNodes = new ArrayList<>();
            int max = - 1;
            int min = -1;
              while(currentNode!=null){
                if(currentNode.value == query){
                    min = query;
                    max = query;
                    break;
                }
                else if(currentNode.value > query){ // changing the max until we get the root value equal to queries value if root value does not exist it will result in closest bigger value to queries value
                    max= currentNode.value;
                    currentNode = currentNode.left;
                }
                 else{   // changing the min until we get the root value equal to queries value if root value does not exist it will result in closest smaller value to queries value
                    min = currentNode.value;
                    currentNode = currentNode.right;
                }
           
        }
            closestNodes.add(min);
            closestNodes.add(max);
          answer.add(new ArrayList<>(closestNodes)); 
    }

        return answer;

    }
    private class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
}
