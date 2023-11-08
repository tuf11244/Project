/*Date: 11/07/2023
    https://leetcode.com/problems/merge-in-between-linked-lists/
 */
package LinkedListPracticeProblems;


public class MergeInBetweenLL {
   private Node head;
   private Node head2;
   private int size;
   
   public MergeInBetweenLL(){
       this.head = null;
       this.head2 = null;
       size = 0;
   }
   public void insertFirst1(int val){
       Node node = new Node(val);
       node.next = head;
       head = node;
       size = size + 1;
   }
   public void insertFirst2(int val){
       Node node = new Node(val);
       node.next = head2;
       head2 = node;
   }
   public void display(){
       Node temp = head;
       while(temp!=null){
           System.out.print(temp.value + " ");
           temp = temp.next;
       }
   }
   public void display2(){
       Node temp = head2;
       while(temp!=null){
           System.out.print(temp.value + " ");
           temp = temp.next;
       }
   }
   public void mergeInBetween(int a, int b){
       if(a == b){
         mergeInBetween1(head,a,b,head2); 
       }
        mergeInBetween2(head,a,b,head2);
   }
   private void mergeInBetween1(Node node, int a, int b, Node node2){
      int index = 0;
      Node previous = null;
      Node nextCurrent = null;
      
      
       index = getIndex(node,a);
       previous = getNode(index-1);
       nextCurrent = getNode(index+1);
       
       previous.next = node2;
       Node temp2 = node2;
        while(temp2.next!=null){
          temp2 = temp2.next;
        }
         
        temp2.next = nextCurrent;
       
   }
   private void mergeInBetween2(Node node, int a, int b, Node node2){
       int indexa = 0;
       int indexb = 0;
       Node previous = null;
       Node nextCurrent = null;
       
       indexa = getIndex(node,a);
       previous = getNode(indexa-1);
       
       indexb = getIndex(node,b);
       nextCurrent = getNode(indexb+1);
       
       
        previous.next = node2;
        Node temp2 = node2;
        while(temp2.next!=null){
          temp2 = temp2.next;
        }
         
        temp2.next = nextCurrent;    
   }
   private int getIndex(Node node, int a){
       Node temp = node;
       int index = 0;
       while(temp!=null){
           index = index + 1;
           temp = temp.next;
           if(index == a){
               return index;
           }
       }
       return -1;
   }
   private Node getNode(int index){
       Node node = head;
       for(int i = 0; i < index; i++){
           node = node.next;
       }
       return node;
   }

    private class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    public static void main(String args[]) {
        MergeInBetweenLL LL = new MergeInBetweenLL();
        
        //LL.insertFirst1(80);
        LL.insertFirst1(70);
        LL.insertFirst1(60);
        LL.insertFirst1(50);
        LL.insertFirst1(40);
        LL.insertFirst1(30);
        LL.insertFirst1(20);
        LL.insertFirst1(10);
        
        LL.insertFirst2(101);
        LL.insertFirst2(201);
        LL.insertFirst2(301);
        LL.insertFirst2(401);
        LL.insertFirst2(501);
        
        LL.display();
        
        System.out.println("");
        LL.display2();
        LL.mergeInBetween(2, 5);
        System.out.println("");
        LL.display();
    }
}
