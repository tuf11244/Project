/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 * Date: 02/12/2024
 *https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
 * @author parth
 */
public class FindNthRootofM {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(nthRoot(2,1024));
    }
    public static int nthRoot(int N, int M){
        int low = 1;
        int end = M;
        while(low <= end){
            int mid = low + (end-low)/2;
            if(Math.pow(mid,N) == M){
                return mid;
            }else if(Math.pow(mid,N) < M){
                low = mid +1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }
}
