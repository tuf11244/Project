/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

//https://leetcode.com/problems/beautiful-arrangement/
import java.util.Arrays;
import java.util.ArrayList;
public class BeautifulArrangement{
    public static void main(String[] args) {
		
    
    
    }
    
    public int countArrangement(int n) {
        return countBeautifulArrangements(n, 1, new boolean[n + 1]);
    }

    private int countBeautifulArrangements(int n, int index, boolean[] used) {
        if (index > n) {
            return 1; // Found a valid arrangement
        }
        
        int count = 0;
        for (int num = 1; num <= n; num++) {
            if (!used[num] && (num % index == 0 || index % num == 0)) {
                used[num] = true; // Mark as used
                count += countBeautifulArrangements(n, index + 1, used);
                used[num] = false; // Backtrack
            }
        }
        
        return count;
    }
	
}
