/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PracticeQuestions;
import java.util.Arrays;
/**
 *Date: 09/18/2023
 * @author parth
 */
public class MajorityElement {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {2,3,2};
        System.out.println(majorityElement(arr));
        // TODO code application logic here
    }
    //O(NLogN) time complexity
    public static int majorityElement(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length/2];
    }
}
