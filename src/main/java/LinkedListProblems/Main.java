/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListProblems;

/**
 *
 * @author parth
 */
public class Main {

    /**
     * Date : 09/01/2023
     * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
     * https://leetcode.com/problems/merge-two-sorted-lists/
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SingleLinkedList list = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();
        
        SingleLinkedList object = new SingleLinkedList();
        
//Removing Duplicates from a Sorted LinkedList
//        list.insertFirst(3);
//        list.insertFirst(2);
//        list.insertFirst(2);
//        list.insertFirst(1);
//        list.insertFirst(1);
//        list.display();
//        list.removeDuplicates();
//        System.out.println("");
//        list.display();

        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list2.insertFirst(4);
        list2.insertFirst(3);
        list2.insertFirst(1);
        list.display();
        System.out.println("");
        list2.display();
        System.out.println("");
        SingleLinkedList answer = object.MergeSortedList(list, list2);
        answer.display();
        
        // TODO code application logic here
    }
}
