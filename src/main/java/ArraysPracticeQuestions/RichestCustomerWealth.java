/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 * Date: 01/27/2024
 *https://leetcode.com/problems/richest-customer-wealth/
 * @author parth
 */
public class RichestCustomerWealth {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Hello World");
		int[][] accounts = {
		   {2,8,7},
		   {7,1,3},
		   {1,9,5}
		};
        System.out.println(maximumWealth(accounts));    // TODO code application logic here
    }
    public static int maximumWealth(int[][] accounts) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < accounts.length;i++){
            sum = 0;
            for(int j = 0; j < accounts[0].length;j++){
                sum = sum + accounts[i][j];
            }
            list.add(sum);
        }
        Collections.sort(list);
        System.out.println(list);
        return list.get(list.size()-1);
    }
}
