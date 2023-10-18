/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

/**
 *
 * @author parth
 */
import java.util.Scanner;
//https://leetcode.com/problems/minimum-absolute-difference-in-bst/
public class MinimumAbsoluteDifferenceInBST{
    private Node root;
    private Integer prev;
    private int MIN_VALUE;
    public MinimumAbsoluteDifferenceInBST(){
        MIN_VALUE = Integer.MAX_VALUE;
    }
    public void insert(Scanner scanner){
        System.out.println("Enter the root value : ");
        int value = scanner.nextInt();
        root = new Node(value);
        insert(root,scanner);
    }
    public void insert(Node node, Scanner scanner){
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
    public int getMinimumAbsoluteDifference(){
         getMinimumAbsoluteDifference(root);
         return MIN_VALUE;
    }
    private void getMinimumAbsoluteDifference(Node node){
        if (node == null) {
        return;
        }
    getMinimumAbsoluteDifference(node.left);
    
    if (prev != null) {
        MIN_VALUE = Math.min(MIN_VALUE, Math.abs(node.value - prev));
        }
    prev = node.value;
    
    getMinimumAbsoluteDifference(node.right);
    }
    private class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		MinimumAbsoluteDifferenceInBST tree = new MinimumAbsoluteDifferenceInBST();
		Scanner scanner = new Scanner(System.in);
		tree.insert(scanner);
		int answer = tree.getMinimumAbsoluteDifference();
		System.out.println(answer);
	}
}
