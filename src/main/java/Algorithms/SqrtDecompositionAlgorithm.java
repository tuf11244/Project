/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author parth
 */
public class SqrtDecompositionAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] st = br.readLine().split(" ");
        for(int i = 0; i < n;i++){
          arr[i] = Integer.parseInt(st[i]);
        }
        
        int q = Integer.parseInt(br.readLine());
        int length = (int)Math.ceil(Math.sqrt(arr.length));
        int[] sqrt = preprocess(arr,length);
        
        
        for(int i = 0; i < q;i++){
            String[] st1 = br.readLine().split(" ");
            int left = Integer.parseInt(st1[0]);
            int right = Integer.parseInt(st1[1]);
            
            int answer = Integer.MAX_VALUE;
            
            while(left  <= right){
                //left % length == 0 means starting of new box
                //if the box is complete 
                if(left % length == 0 && left + length - 1 <= right){
                    answer = Math.min(answer,sqrt[left/length]);
                    left = left + length;
                }else{
                    //if the box is partial
                    answer = Math.min(answer, arr[left]);
                    left++;
                }
            }
            System.out.println(answer);
        }
       
    }
    
    public static int[] preprocess(int[] arr, int length){
        int[] sqrt = new int[length];
        Arrays.fill(sqrt, Integer.MAX_VALUE);
        
        for(int i = 0; i < arr.length;i++){
            int sqrtIndex = i/length;
            sqrt[sqrtIndex] = Math.min(sqrt[sqrtIndex],arr[i]);
        }
        return sqrt;
        
    }
}
