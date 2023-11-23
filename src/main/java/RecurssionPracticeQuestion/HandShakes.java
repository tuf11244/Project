/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

import java.util.HashMap;

/**
 *https://practice.geeksforgeeks.org/problems/handshakes1303/1
 * @author parth
 */
public class HandShakes {

    public static HashMap<Integer,Integer> map = new HashMap<>();
    public static void main(String args[]) {
        System.out.println(countHandshakes(6));
    }
    public static int countHandshakes(int N){
        if(N%2 == 1){
            return 0;
        }
        if(N == 0){
            return 1;
        }
        if(map.containsKey(N)){
            return map.get(N);
        }
        int sum = 0;
        for(int i = 0; i < N;i = i+2){
            sum = sum + countHandshakes(i)*countHandshakes(N-2-i);
        }
        map.put(N, sum);
        return sum;
    }
}
