/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

import java.util.LinkedList;

/**
 *Date: 11/09/2023
 * https://leetcode.com/problems/design-browser-history/
 * @author parth
 */
public class DesignBrowserHistory {

    public static void main(String args[]) {
        BrowserHistory BH = new BrowserHistory("LeetCode.com");
        BH.visit("google.com");
        BH.visit("facebook.com");
        BH.visit("youtube.com");
        
        System.out.println(BH.back(1));
        System.out.println(BH.back(1));
        System.out.println(BH.forward(1));
        
        BH.visit("Linkedin.com");
        System.out.println(BH.forward(2));
        System.out.println(BH.back(2));
        
    }
}

class BrowserHistory{
    Node currentPage;
    public BrowserHistory(String homepage){
        currentPage = new Node(homepage);
    }
    public void visit(String url){
        Node visitPage = new Node(url);
        currentPage.next = visitPage;
        visitPage.previous = currentPage;
        currentPage = currentPage.next;
    }
    public String back(int steps) {
        while(currentPage.previous!=null && steps > 0){
            currentPage = currentPage.previous;
            steps = steps - 1;
        }
        return currentPage.value;
    }

    public String forward(int steps) {
    while(currentPage.next!=null && steps > 0){
            currentPage = currentPage.next;
            steps = steps - 1;
        }
        return currentPage.value;
}
class Node{
    String value;
    Node next;
    Node previous;
    public Node(String value){
        this.value = value;
        this.next = null;
    }
}

}
