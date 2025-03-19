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
public class MaximalRectangle {

    public int maximalRectangle(char[][] arr) {

        //We need to decompose the arr into a 1-D array 
        int maxRectangle = 0;
        int[] heights = new int[arr[0].length];
       for(int i = 0; i < arr.length;i++){

            char [] array = arr[i];

            for(int j  = 0; j < array.length;j++){
                if(array[j] - '0' == 0){
                    heights[j] = 0;
                }else{
                    heights[j] = heights[j] + 1;
                }
            }

            int maxArea = largestRectangleArea(heights);
            maxRectangle = Math.max(maxRectangle,maxArea);

       }


        return maxRectangle;
    }

    public int largestRectangleArea(int[] heights) {
        
        int[] nearestSmallerIdxOnLeft = function1(heights);
        int[] nearestSmallerIdxonRight = function2(heights);

        int maxHeight = 0; //our return answer;

        for(int i = 0; i < heights.length;i++){
            int width = nearestSmallerIdxonRight[i] - nearestSmallerIdxOnLeft[i] - 1;
            int heightOfHistogram = heights[i];

            maxHeight = Math.max(maxHeight, heightOfHistogram * width);
        }

        return maxHeight;
    }

    public int[] function1(int[] heights){
        int[] arr = new int[heights.length];

        arr[0] = -1; //as the nearest smaller on the first building is -1; 
        //remember we are storing the idx

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i = 1; i < heights.length;i++){

            while(!st.isEmpty() && heights[st.peek()]  >= heights[i]){
                 st.pop();
            }

            if(st.isEmpty()){
                arr[i] = -1;
            }else{
                arr[i] = st.peek();
            }

            st.push(i);
        }

        return arr;
    }

    public int[] function2(int[] heights){
        int[] arr = new int[heights.length];

        arr[arr.length -1] = arr.length; //as the nearest smaller building for the last element 
        //would be the next building which is arr.length

        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        for(int i = heights.length -2; i >= 0;i--){

                while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                     st.pop();
                }

                if(st.isEmpty()){
                    arr[i] = heights.length;
                }else{
                    arr[i] = st.peek();
                }

            st.push(i); //add the current Index;
        }

        return arr;
    }
}
