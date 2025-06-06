/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;
import java.util.Scanner;

/**
 *Date: 09/22/2023
 * @author parth
 */
public class DiameterofBinaryTree {
    private Node root;
    private int result;
    public DiameterofBinaryTree(){
        result = Integer.MIN_VALUE;
    }
    public void insert(Scanner scanner){
        System.out.println("Enter the root node value : ");
        int value = scanner.nextInt();
        root = new Node(value);
        insert(scanner,root);
    }
    private void insert(Scanner scanner, Node node){
        System.out.println("Do you want to enter left of :" + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of :" + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            insert(scanner,node.left);
        }
        System.out.println("Do you want to enter right of : " + node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of :" + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            insert(scanner, node.right); 
        }      
    }
    public void display(){
        display(root," ");
    }

    private void display(Node node, String indent) {
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");       
    }
    public int diameter(){
         diameter(root);
         return result;
    }
    private int diameter(Node node){
       //Base case
       if(node == null){
           return 0;
       }
       int left = diameter(node.left);
       int right = diameter(node.right);
       
       int temp = Math.max(left, right) + 1; //When the node doesn;t want to be the part of answer
       int answer = Math.max(temp,left+right+1); //When the node wants to be the part of answer
       result = Math.max(result,answer);
        
        return temp;
        
    }
    
    
     private class Node{
         int value; 
         Node left; 
         Node right;
         
         public Node(int value){
             this.value = value;
         }
     }
    
    public static void main(String args[]) {
        DiameterofBinaryTree tree = new DiameterofBinaryTree();
        Scanner scanner = new Scanner(System.in);
        tree.insert(scanner);
        tree.display();
        System.out.println(tree.diameter() + " is the diameter of the tree ");
        // TODO code application logic here
    }
}
/*
PepCoding Method
public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Pair p = helper(root);

        return p.dia;
        
    }
    public Pair helper(TreeNode root){
        if(root == null){
            Pair p = new Pair();
            p.ht = -1;
            p.dia = 0;
            return p;
        }

        Pair left = helper(root.left);
        Pair right = helper(root.right);

        Pair answer = new Pair();
        answer.ht = Math.max(left.ht,right.ht) + 1;
        int factor1 = left.ht + right.ht + 2; //when root wants to be a part 
        answer.dia = Math.max(factor1,Math.max(left.dia,right.dia));

        return answer;
    }
}

class Pair{
    int ht;
    int dia;
}
*/