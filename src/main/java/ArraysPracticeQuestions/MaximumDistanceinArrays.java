/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;
import java.util.*;
/**
 *Date; 08/15/2024 - POTD
 *https://leetcode.com/problems/maximum-distance-in-arrays/
 * @author parth
 */
public class MaximumDistanceinArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int maxDistance(List<List<Integer>> arrays) {
        int smallestElement = arrays.get(0).get(0);
        int largestElement = arrays.get(0).get(arrays.get(0).size() - 1);
        int smallestElementIndex = 0;
        int largestElementIndex = 0;

        for (int i = 1; i < arrays.size(); i++) {
            int first = arrays.get(i).get(0);
            int last = arrays.get(i).get(arrays.get(i).size() - 1);

            if (first < smallestElement) {
                smallestElement = first;
                smallestElementIndex = i;
            }

            if (last > largestElement) {
                largestElement = last;
                largestElementIndex = i;
            }
        }

        if (smallestElementIndex != largestElementIndex) {
            return largestElement - smallestElement;
        }

        int maxDistance1 = Integer.MIN_VALUE;
        int maxDistance2 = Integer.MIN_VALUE;

        for (int i = 0; i < arrays.size(); i++) {
            if (i != smallestElementIndex) {
                maxDistance1 = Math.max(maxDistance1, largestElement - arrays.get(i).get(0));
                maxDistance2 = Math.max(maxDistance2, arrays.get(i).get(arrays.get(i).size() - 1) - smallestElement);
            }
        }

        return Math.max(maxDistance1, maxDistance2);
    }
}
