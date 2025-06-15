/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart3;
import java.util.*;
/**
 *
 * @author parth
 */
public class AreAllValuesEqual extends TreeNodes {

    /**
     * @param args the command line arguments
     */
    
    static TreeNode root;
    public static void main(String args[]) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        root = makeTree(scanner);
       // display(root);
        
        int answer = areAllValuesInTreeEqual(root);
        
        if(answer == -10){
            System.out.println("All values are not equals");
        }else{
            System.out.println("They are equal");
        }
        
    }
    
    
    public static TreeNode makeTree(Scanner scanner){
       System.out.print("Enter the node value: ");
        int value = scanner.nextInt();
        TreeNode node = new TreeNode(value);

        System.out.print("Do you want to add a left child to " + value + "? (Y/N): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("Y")) {
            node.left = makeTree(scanner);
        }

        System.out.print("Do you want to add a right child to " + value + "? (Y/N): ");
        response = scanner.next();
        if (response.equalsIgnoreCase("Y")) {
            node.right = makeTree(scanner);
        }

        return node;
        
    }
    public static void display(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        display(root.left);
        display(root.right);
    }
    
    public static int areAllValuesInTreeEqual(TreeNode root){
        if(root == null){
            return -1;
        }
        
        int left = areAllValuesInTreeEqual(root.left);
        int right = areAllValuesInTreeEqual(root.right);
        
        //Leaf Node;
        if(left == -1 && right == -1){
            return root.val;
        }
        if((left != -1 && root.val != left) || (right != -1 && root.val != right) || (left != root.val && right != root.val)){
            return -10;
        }
        
        return root.val;
    }
    
   
}
