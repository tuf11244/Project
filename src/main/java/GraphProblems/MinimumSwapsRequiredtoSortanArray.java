/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.Arrays;

/**
 *Date: 05/02/2024
 * https://www.geeksforgeeks.org/problems/minimum-swaps/1
 * @author parth
 */
public class MinimumSwapsRequiredtoSortanArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       int[] arr = {10,19,6,3,5};
        System.out.println(minimumSwaps(arr));
    }
    
    public static int minimumSwaps(int[] arr){
        tpair[] copyArr = new tpair[arr.length];
        
        for(int i = 0; i < arr.length;i++){
            copyArr[i] = new tpair(arr[i],i); //copyArr will be made up of arr[i] and i;
        }
        
        //now sort our copyArr;
        Arrays.sort(copyArr);
        //Logic
        //We have to find cycles length and add that length - 1 to our answer 
        //Note that there could be multiple cycles 
        int answer = 0;
        boolean[] visited = new boolean[arr.length];
        for(int i = 0; i < arr.length;i++){
            if(visited[i] == true || copyArr[i].index == i){
                //the above state means if the visited[i] is true that means its was already a part of other cycle 
                //the second statement copyArr[i].index == i means that in original array given to us and in the sorted array 
                //the index of the element is same so we unessarily don't need to waste our swap 
                continue;               
            }
            int clength = 0; //cycle length 
            int j = i;
            
            while(visited[j] == false){
                visited[j] = true;  //mark it as visited 
                clength++; //increase the length of cycle 
                j = copyArr[j].index; // jump j to next element connected in the cycle;
            }
            answer = answer + (clength - 1);
            
        }        
        
        return answer;
    }
}


class tpair implements Comparable<tpair> {
    int val;
    int index;
    
    public tpair(int val, int index){
        this.val = val;
        this.index = index;
    }

    @Override
    public int compareTo(tpair o) {
       return this.val - o.val;
    }
}
