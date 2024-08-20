/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;

/**
 *Date: 08/16/2024
 * https://www.geeksforgeeks.org/boolean-parenthesization-problem-dp-37/
 * @author parth
 */
public class BooleanParenthesization {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        
        System.out.println(booleanParenthesization("TFT", "^&"));
    }
    
    public static int booleanParenthesization(String s1, String s2){
        // s1 = Contains True and False
        // s2 = Contains Symbols like &, |, ^
        
        int n = s1.length();
        
        int[][] dpt = new int[n][n]; // DP for all true expression counts
        int[][] dpf = new int[n][n]; // DP for all false expression counts
        
        for(int g = 0; g < n; g++){
            for(int i = 0, j = g; j < n; j++, i++){
                if(g == 0){
                   char ch = s1.charAt(i);
                   
                   if(ch == 'T'){
                      dpt[i][j] = 1;
                      dpf[i][j] = 0;
                   }else{ // ch == 'F'
                      dpt[i][j] = 0;
                      dpf[i][j] = 1;
                   }   
                }else{
                    for(int k = i; k < j; k++){
                        char operator = s2.charAt(k);
                        int ltc = dpt[i][k];  // Left true count
                        int rtc = dpt[k+1][j]; // Right true count
                        
                        int lfc = dpf[i][k]; // Left false count 
                        int rfc = dpf[k+1][j]; // Right false count;
                        
                        if(operator == '&'){
                            dpt[i][j] += ltc * rtc;
                            dpf[i][j] += (ltc * rfc) + (lfc * rtc) + (lfc * rfc);   
                        }else if(operator == '|'){
                            dpt[i][j] += (ltc * rfc) + (lfc * rtc) + (ltc * rtc);  
                            dpf[i][j] += lfc * rfc;
                        }else{  // XOR
                            dpt[i][j] += (ltc * rfc) + (lfc * rtc);
                            dpf[i][j] += (ltc * rtc) + (lfc * rfc);
                        }
                    }
                }
            }
        }
        return dpt[0][n-1];
    }
}
