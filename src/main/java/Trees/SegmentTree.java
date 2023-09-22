/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Trees;

/**
 *Date: 09/21/2023
 * @author parth
 */
public class SegmentTree {
    public Node root;
    
    public SegmentTree(int[] arr){
        this.root = constructTree(arr,0,arr.length-1);
        
    }
    private Node constructTree(int[] arr,int start, int end){
        if(start == end){
           //Base Condition  : Create Leaf Node
        Node leaf = new Node(start,end);
        leaf.data = arr[start];
         return leaf;
        }
        
        Node node = new Node(start,end);
    
        int middle = (start + end)/2;
        node.left = this.constructTree(arr, start, middle);
        node.right = this.constructTree(arr,middle+1,end);
        node.data = node.left.data + node.right.data;
        return node;
    }
    public void display(){
        display(this.root);
    }
    private void display(Node node) {
    if (node != null) {
        String str = "Start Interval: " + node.startInterval + ", End Interval: " + node.endInterval + ", Data: " + node.data;
        System.out.println(str);
        
        display(node.left);
        display(node.right);
    }
}

    public int query(int queryStartIndex, int queryEndIndex){
        return query(root,queryStartIndex, queryEndIndex);
    }
    private int query(Node node, int queryStartIndex, int queryEndIndex){
        //Case 1 : Node Interval is inside query Interval
        //Node is completely lying inside query
        if(queryStartIndex <= node.startInterval && queryEndIndex >= node.endInterval){
            return node.data;
        }
        //Case 2 : query Interval is completely outside node Interval
        else if(queryStartIndex > node.endInterval || queryEndIndex < node.startInterval ){
            return 0;
        }
        //Case 3  : Overlapping Querries
       
            int leftResult = query(node.left,queryStartIndex,queryEndIndex);
            int rightResult = query(node.right,queryStartIndex,queryEndIndex);
            return leftResult + rightResult;
    }
    
    //update
    public void update(int index, int value){
        this.root.data = update(root,index,value);
    }
    private int update(Node node, int index, int value){
        if(index >= node.startInterval && index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval){
                node.data = value;
                return node.data;
            } else {
                int leftAnswer = update(node.left,index,value);
                int rightAnswer = update(node.right,index,value);
                
                node.data = leftAnswer + rightAnswer;
                return node.data;
            }
        }
        //When its completely outside 
        return node.data;
    }
    
    
    private class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;
        
        public Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }
    
    public static void main(String args[]) {
        int[] arr = {3,8,7,6,-2,-8,4,9};
        SegmentTree tree = new SegmentTree(arr);
        tree.display();
        System.out.println(tree.query(2, 2));
        tree.update(0, 8);
        tree.display();
        System.out.println(tree.query(1, 2));
        // TODO code application logic here
    }
}
