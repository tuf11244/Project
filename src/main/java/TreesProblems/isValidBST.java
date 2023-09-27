/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;
import java.util.Scanner;
/**
 *Date:09/26/2023
 * https://leetcode.com/problems/validate-binary-search-tree/solutions/
 * @author parth
 */
public class isValidBST {
    private Node root;
    public isValidBST(){
        
    }
    public void insert(Scanner scanner){
        System.out.println("Enter the root value: " );
        int value = scanner.nextInt();
        root = new Node(value);
        insert(root,scanner);
    }
    private void insert(Node node, Scanner scanner){
        System.out.println("Do you want to enter the value to the left of " + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value to the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            insert(node.left,scanner);
        }
        System.out.println("Do you want to enter the value to the  of right" + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value to the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            insert(node.right,scanner);
        }
    }
    public boolean isValidBST(){
        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isValidBST(Node node, int min, int max){
        if(node == null){
            return true; //an empty subtree is considered a BST
        }
        if(node.value <= min || max <= node.value){
            return false;
        }
        boolean left = isValidBST(node.left,min,node.value);
        boolean right = isValidBST(node.right,node.value,max);
        
        return left && right;
    }
    

    private class Node{
        int value; 
        Node left; 
        Node right;
        public Node(int value){
            this.value = value;
        }
        public Node(int value,Node left,Node right){
            this.value = value; 
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String args[]) {
        isValidBST tree = new isValidBST();
        Scanner scanner = new Scanner(System.in);
        tree.insert(scanner);
        System.out.println(tree.isValidBST());
        // TODO code application logic here
    }
}
