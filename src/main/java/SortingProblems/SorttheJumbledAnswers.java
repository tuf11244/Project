/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;
import java.util.*;
/**
 *Date: 07/23/2024
 * https://leetcode.com/problems/sort-the-jumbled-numbers/
 * @author parth
 */
public class SorttheJumbledAnswers {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Pair> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int sum = 0;
            if(num == 0){
                Pair p = new Pair(num, mapping[num]);
                list.add(p);
            }else{
                String s = String.valueOf(num);
                for(int j = 0; j < s.length(); j++){
                    int map = s.charAt(j) - '0';
                    sum = sum * 10 + mapping[map];
                }
                Pair p = new Pair(num, sum);
                list.add(p);
            }
        }

        Collections.sort(list);

        int[] answer = new int[nums.length];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).val;
        }
        return answer;
    }
}
class Pair implements Comparable<Pair>{
    int val;
    int mappedValue;

    public Pair(int val, int mappedValue){
        this.val = val;
        this.mappedValue = mappedValue;
    }

    @Override
    public int compareTo(Pair o){
        return this.mappedValue - o.mappedValue;
    }
}