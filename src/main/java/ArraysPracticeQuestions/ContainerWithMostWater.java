/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 01/19/2025
 * https://leetcode.com/problems/container-with-most-water/
 * @author parth
 */
public class ContainerWithMostWater {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int maxArea(int[] height) {
        int maxWater = 0;

        int left = 0;
        int right = height.length -1;

        while(left < right){
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;

            maxWater = Math.max(maxWater,currentHeight * currentWidth);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxWater;
    }
}
