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
     //   System.out.println(kthSymbol(4,4));
     
      System.out.println(findkthBit(4));
      String answer = findkthBit(4);
      for(int i = 0; i < answer.length();i++){
          if(i == 11-1){
              System.out.println(answer.charAt(i));
          }
      }
    //    System.out.println(invert("0110"));;
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
    public static String findkthBit(int n){
        if(n == 1){
            return "0";
        }
        return findkthBit(n-1) + "1" + reverse(invert(findkthBit(n-1)));
    }
    public static String reverse(String S){
        String reverse = "";
        for(int i = S.length()-1; i >= 0;i--){
            reverse = reverse + S.charAt(i);
        }
        return reverse;
    }
    private static String invert(String binaryString) {
        StringBuilder invertedStringBuilder = new StringBuilder();

        for (int i = 0; i < binaryString.length(); i++) {
            char currentChar = binaryString.charAt(i);
            char invertedChar;

            if (currentChar == '0') {
                invertedChar = '1';
            } else {
                invertedChar = '0';
            }

            invertedStringBuilder.append(invertedChar);
        }

        return invertedStringBuilder.toString();
    }
}
