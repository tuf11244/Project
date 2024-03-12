/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Date: 03/12/2024
 *https://leetcode.com/problems/find-anagram-mappings/
 * @author parth
 */
public class FindAllAnagramsMapping {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr1 = {2,7,9,2,8,1,1,3,9};
        int[] arr2 = {3,1,2,9,8,1,7,9,2};
        int[] answer = mapping(arr1,arr2);
        System.out.println(Arrays.toString(answer));
    }
    
    public static int[] mapping(int[] arr1, int[] arr2){
        HashMap<Integer,Pair> hm = new HashMap<>();
        for(int i = 0; i < arr2.length ;i++){
            if(hm.containsKey(arr2[i])){
                Pair p = hm.get(arr2[i]);
                p.list.add(i);
            }else{
                Pair p = new Pair();
                p.list.add(i);
                hm.put(arr2[i],p);
            }
        }
        int[] answer = new int[arr1.length];
        for(int i =0; i < arr1.length;i++){
            Pair p = hm.get(arr1[i]);
            answer[i] = p.list.get(p.index);
            p.index++;
            
        }
        return answer;
    }
}

class Pair{
    int index = 0;
    List<Integer> list = new ArrayList<>();
    
}
