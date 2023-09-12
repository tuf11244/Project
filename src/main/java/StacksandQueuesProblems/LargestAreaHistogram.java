/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueuesProblems;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 *Date: 09/11/2023
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * @author parth
 */
public class LargestAreaHistogram {

    public static void main(String args[]) {
        System.out.println("Hello World");
        int[] arr = {6,2,5,4,5,1,6};
        LinkedList<Integer> right = NearestSmallestElementToRight(arr);
        LinkedList<Integer> left = NearestSmallestElementToLeft(arr);
        LinkedList<Integer> width = widthofMaxHistogram(right,left);
        int[] area = areaofMaxHistogram(arr,width);
        System.out.println("Left Smallest Index " + left);
        System.out.println("Right Smallest Index " + right);
        System.out.println("Width of the Histogram " + width);
        System.out.println("Area of the Histogram " + Arrays.toString(area));
        System.out.println("Area of the maximum Histogram " + maxInArea(area));
        // TODO code application logic here
    }
    public static LinkedList<Integer> NearestSmallestElementToLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> queue = new LinkedList<>();
        Stack<Integer> indexStack = new Stack<>();
        int falseIndex = -1;
        for(int i = 0; i < arr.length;i++){
         while (!stack.isEmpty() && arr[i] <= stack.peek()) {
                stack.pop();
                indexStack.pop();
            }

            if (stack.isEmpty()) {
                queue.add(falseIndex);
            } else {
                queue.add(indexStack.peek());
            }

            stack.push(arr[i]);
            indexStack.push(i);
    }
        return queue;
}
public static LinkedList<Integer> NearestSmallestElementToRight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> queue = new LinkedList<>();
        Stack<Integer> indexStack = new Stack<>();
        int falseIndex = 7;
        for(int i = arr.length-1; i >= 0;i--){
         while (!stack.isEmpty() && arr[i] <= stack.peek()) {
                stack.pop();
                indexStack.pop();
            }

            if (stack.isEmpty()) {
                queue.add(falseIndex);
            } else {
                queue.add(indexStack.peek());
            }

            stack.push(arr[i]);
            indexStack.push(i);
    }
    // Reverse the queue to get the correct order
        LinkedList<Integer> reversedQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            reversedQueue.add(queue.removeLast());
        }
        return reversedQueue;

    }
public static LinkedList<Integer> widthofMaxHistogram(LinkedList<Integer> right, LinkedList<Integer> left){
    LinkedList<Integer> width = new LinkedList<>();
    for(int i = 0; i < right.size();i++){
        width.add(right.get(i)-left.get(i)-1);
    }
    return width;
    
}
public static int[] areaofMaxHistogram(int[] arr, LinkedList<Integer> width){
    int[] area = new int[arr.length];
    for(int i = 0; i < arr.length;i++){
        area[i] = arr[i] * width.get(i);
    }
    return area;
}
public static int maxInArea(int[] area){
    int max = 0;
    for(int i = 0; i < area.length;i++){
        if(area[i] > max){
            max = area[i];
        }
    }
    return max;
}
}
