/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

/**
 *
 * @author parth
 */
//https://leetcode.com/problems/operations-on-tree/
class LockingTree{
    private Node root;
    private int[] parent;
    public LockingTree(int[] parent){
        this.parent = parent;
        this.root = buildTree(parent);
    }
    public Node buildTree(int[] parent){
       Node[] nodes = new Node[parent.length];
       for(int i = 0; i < parent.length;i++){
           nodes[i] = new Node(i);
       }
       for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                Node parentNode = nodes[parent[i]];
                if (parentNode.left == null) {
                    parentNode.left = nodes[i];
                } else {
                    parentNode.right = nodes[i];
                }
            }
        }
        return nodes[0];
    }
    public boolean lock(int num, int user){
        Node node = findNode(root,num);
        if(node != null && !node.locked){
            node.locked = true;
            node.lockedby = user;
            return true;
        }
        return false;
    }
    public boolean unlock(int num, int user){
        Node node = findNode(root,num);
        if(node!= null && node.locked && node.lockedby == user){
            node.locked = false;
            node.lockedby = -1;
            return true;
        }
        return false;
    }
    public boolean upgrade(int num, int user){
        //Condition 1 : node is unlocked
        //Condition 2 : Any descentdants locked by any user 
        //Condition 3 : it doesnt have any locked ancestors
        Node node = findNode(root,num);
        if(node!= null && !node.locked && hasLockedDescendant(node) && !hasLockedAncestors(node)){
            unlockDescendant(node);
            node.locked = true;
            node.lockedby = user;
            return true;
        }
        return false;
    }
    private boolean hasLockedDescendant(Node node){
        if(node == null){
            return false;
        }
        return node.locked || hasLockedDescendant(node.left) || hasLockedDescendant(node.right) ;
    }
    private boolean hasLockedAncestors(Node node){
        if(node == null){
            return false;
        }
        if(node.locked){
            return true;
        }
        return hasLockedAncestors(findNode(root,parent[node.value]));
    }
    private void unlockDescendant(Node node){
        if(node == null){
            return;
        }
        if(node.locked){
            node.locked = false;
            node.lockedby = - 1;
        }
        unlockDescendant(node.left);
        unlockDescendant(node.right);
    }
    private Node findNode(Node node, int num){
        if(node == null){
            return null;
        }
        if(node.value == num){
            return node;
        }
        Node left = findNode(node.left,num);
        if(left != null){
            return left;
        }
        return findNode(node.right,num);
    }

    public void display(){
       display(root,"Root value is :");
    }
    private void display(Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.value);
        display(node.left,"The left child of " + node.value + ":");
        display(node.right,"The right child of " + node.value + ":");
    }
    
    private class Node{
        int value;
        Node left;
        Node right;
        boolean locked;
        int lockedby;
        public Node(int value){
            this.value = value;
            this.locked = false;
            this.lockedby = -1;
        }
    }
}
public class OperationonTree{
	public static void main(String[] args) {
	System.out.println("Hello World");
		int[] parent = {-1, 0, 0, 1, 1, 2, 2};
		LockingTree tree = new LockingTree(parent);
		tree.display();
		System.out.println(tree.lock(2, 2)); // Output: true (node 2 is locked by user 2)
        System.out.println(tree.unlock(2, 2)); // Output: true (node 2 is unlocked by user 2)
        System.out.println(tree.upgrade(2, 2)); // Output: false (upgrade fails as per the conditions)
		
	}
}
