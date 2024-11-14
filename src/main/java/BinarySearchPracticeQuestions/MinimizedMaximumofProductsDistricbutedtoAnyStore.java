/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 *Date: 11/13/2024
 * https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
 * @author parth
 */
public class MinimizedMaximumofProductsDistricbutedtoAnyStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int high = 0;
        for (int quantity : quantities) {
            high = Math.max(high, quantity);
        }
        
        int low = 1;
        int answer = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(mid, n, quantities)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    public boolean isValid(int maxProducts, int n, int[] quantities) {
        int requiredShops = 0;

        for (int quantity : quantities) {
            requiredShops += (quantity + maxProducts - 1) / maxProducts;  // Equivalent to ceiling division

            if (requiredShops > n) {
                return false;
            }
        }
        
        return requiredShops <= n;
    }
}
