/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *Date: 04/09/2024
 * https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/
 * @author parth
 */
public class FirstNegativeElementinEveryWindowofSizeK {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        long[] A = {12,-1,-7,8,-15,30,16,28};
        long[] ans = printFirstNegativeInteger(A,A.length,1);
        System.out.println(Arrays.toString(ans));
    }
    
    public static long[] printFirstNegativeInteger(long A[], int N, int K){
     
        List<Long> list = new ArrayList<>();
        Queue<Long> queue = new LinkedList<>();
       
        int i = 0; 
        int j = 0; 
        
        while(i < A.length){
            if(A[i] < 0){
                queue.add(A[i]);
            }
            if(i-j+1 < K){
                i++;
            }
            else if(i-j+1 == K){
                
                if(queue.isEmpty()){
                    list.add((long)0);
                }else{
                    list.add(queue.peek());
                    if(A[j] == queue.peek()){
                        queue.poll();
                    }
                }
                i++;
                j++;
            }
        }
        
        long[] result = new long[list.size()];
        
        for(int t = 0; t < list.size();t++){
            result[t] = list.get(t);
        }
        return result;
    }
    
    
}
