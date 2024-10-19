/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 * Date: 11/21/2023
 *https://leetcode.com/problems/k-th-symbol-in-grammar/
 * https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
 * @author parth
 */
public class KthSymbolinGrammar {

    public static void main(String args[]) {
    
    }
    public static int kthSymbol(int n,int k){
       if(n == 1 && k == 1){
           return 0;
       }
      int middle = (int) (Math.pow(2, n-1)/2);
      if(k <= middle){
          return kthSymbol(n-1,k);
      }
        return kthSymbol(n-1,k-middle)^ 1;
    }
    public static char findkthBit(int n, int k){
         if (n == 1 && k == 1) {
            return '0'; // Base case: S(1) is "0"
        }
        
        int middle = (int) (Math.pow(2, n-1));
        
        if (k == middle) {
            return '1'; // The middle element is always '1'
        } else if (k < middle) {
            return findkthBit(n - 1, k); // First half, same as S(n-1)
        } else {
            // Second half, mirrored and inverted
            char mirroredChar = findkthBit(n - 1, middle * 2 - k); // k-mapped to the first half
            return invert(mirroredChar); // Invert the mirrored character
        }
    }
    
    
    private static char invert(char bit) {
        return bit == '0' ? '1' : '0'; // Invert '0' to '1' and '1' to '0'
    }
   
}
