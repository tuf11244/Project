/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 *Date: 10/20/2023
 *https://leetcode.com/problems/number-of-recent-calls/
 * @author parth
 */
public class NumberofRecentCalls {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        RecentCalls object = new RecentCalls();
        
        System.out.println(object.ping(200));
        System.out.println(object.ping(300));
        System.out.println(object.ping(400));
        
    }
}
class RecentCalls {
    Queue<Integer> queue;

    public RecentCalls() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty() && t - queue.peek() > 3000) {
            queue.poll();
        }
        return queue.size();
    }
}

