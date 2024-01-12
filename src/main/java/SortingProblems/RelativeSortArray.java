/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *Date : 01/11/2024
 * https://leetcode.com/problems/relative-sort-array/
 * @author parth
 */
public class RelativeSortArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> remaining = new ArrayList<>();

        for(int i = 0; i < arr2.length;i++){
            for(int j = 0; j < arr1.length;j++){
                if(arr1[j] == arr2[i]){
                    list.add(arr1[j]);
                }
            }
        }
        for(int l = 0; l < arr1.length;l++){
            if(!list.contains(arr1[l])){
                remaining.add(arr1[l]);
            }
        }
        Collections.sort(remaining);
        list.addAll(remaining);
        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
