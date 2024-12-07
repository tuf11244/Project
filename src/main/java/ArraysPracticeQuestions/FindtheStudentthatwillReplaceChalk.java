/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/
 * Date: 09/01/2024
 * @author parth
 */
public class FindtheStudentthatwillReplaceChalk {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    //Time Complexity : O(N);
    public int chalkReplacer(int[] chalk, int k) {
        int i =0;
        while(i < chalk.length){
            k = k - chalk[i];
            if(k < 0){
                return i;
            }

             if(k > 0 && i == chalk.length - 1){
                //Reset i
                i = 0;
                continue;
            }else if(k ==0){
                return (i + 1) % chalk.length;
            }
            i++;
        }
        return -1;
    }
    
    
    //Time Complexity : O(LogN) using Binary Search
    public int chalkReplacerBS(int[] chalk, int k) {
         int n = chalk.length;
        
        // Step 1: Calculate prefix sums
        long[] prefixSums = new long[n];
        prefixSums[0] = chalk[0];
        for (int i = 1; i < n; i++) {
            prefixSums[i] = prefixSums[i - 1] + chalk[i];
        }

        // Step 2: Reduce k using the total sum of chalk
        long totalSum = prefixSums[n - 1];
        k %= totalSum;

        // Step 3: Binary search to find the first student who cannot finish the chalk
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 'left' will be the index of the student who will replace the chalk
        return left;
    }
}
