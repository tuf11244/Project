/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;

import java.util.Arrays;

/**
 * Date: 01/10/2024
 *https://leetcode.com/problems/assign-cookies/
 * @author parth
 */
public class AssignCookies {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        
        System.out.println(findContentChildren(g,s));
    }
    public static int findContentChildren(int[]g, int[]s){
        if(s.length == 0){
            return 0;
        }
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        int pointer1 = 0; 
        int pointer2 = 0;
        int count = 0;
        while(pointer1 < g.length && pointer2 < s.length){
            if(s[pointer2] >= g[pointer1]){
                pointer1++;
                pointer2++;
                count++;
            }else{
                pointer2++;
            }
        }
//        int product = 1;
//        for(int i = pointer1 - 1; i>= 0;i--){
//            product = product * g[i];
//        }
        return count;
    }
}
