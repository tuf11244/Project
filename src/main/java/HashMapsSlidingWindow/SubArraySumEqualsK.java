/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.HashMap;

/**
 *
 * @author parth
 */
public class SubArraySumEqualsK {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,2,3};
        subArraySum(arr,2);
    }
    public static int subArraySum(int[] arr, int k){
        int i = -1;
        int sum = 0;
        int count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        for(int j = 0; j < arr.length;j++){
           sum = sum + arr[j];
           hm.put(sum, j);
        }
        System.out.println(hm);
        return 0;
    }
}
