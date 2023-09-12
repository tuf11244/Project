/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueuesProblems;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
/**
 * Date: 09/11/2023
 *https://leetcode.com/problems/maximal-rectangle/
 * @author parth
 */
public class LargestAreaHistogramInBinaryArray {

    public static void main(String args[]) {
        System.out.println("Hello World");
        int[][] arr = {
            {0,1,1,0},
            {1,1,1,1},
            {1,1,1,1},
            {1,1,0,0},
        };
         int row = arr.length;
        int column = arr[0].length;
        int[] answer = new int[column];
        for(int j = 0; j < column;j++){
            answer[j] = arr[0][j];
          
        }
        int MaxHistogram = MaximumAreaOfTheHistogram(answer);
        for(int i = 1; i < row;i++){
            for(int j = 0; j < column;j++){
                if(arr[i][j] == 0){
                    answer[j] = 0;
                }else{
                    answer[j] = answer[j] + arr[i][j];
                }
            }
            MaxHistogram = Math.max(MaxHistogram,MaximumAreaOfTheHistogram(answer));
        }
         System.out.println(MaxHistogram);
        
    }
    public static int MaximumAreaOfTheHistogram(int[] arr){
        LinkedList<Integer> right = NearestSmallestElementToRight(arr);
        LinkedList<Integer> left = NearestSmallestElementToLeft(arr);
        LinkedList<Integer> width = widthofMaxHistogram(right,left);
        int[] area = areaofMaxHistogram(arr,width);
        
        return maxInArea(area);
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
        int falseIndex = arr.length;
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
