 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;

/**
 *
 * @author parth
 */
public class MatrixChainMultiplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int matrixMultiplication(int[] arr){
        int[][] dp = new int[arr.length - 1][arr.length - 1];
        
        for(int g = 0; g < dp.length;g++){
            for(int i = 0, j = g;j < dp.length;i++,j++){
                if(g == 0){  // Single matrix, no multiplication
                    dp[i][j]= 0;
                }else if(g == 1){ // Two matrices
                    dp[i][j] = arr[i] * arr[j] * arr[j+1];
                }else{
                    int min = Integer.MAX_VALUE;
                    for(int k = i; k < j;k++){
                        //dp -- > Left half = i,k  and k+1,j is right half
                        //arr --> Left half = i,k+1 and k+1,j+1 is right half
                        int lc = dp[i][k];
                        int rc = dp[k+1][j];
                        int mc = arr[i] * arr[k+1] * arr[j+1];
                        int tc = lc + rc + mc;
                        min = Math.min(min, tc);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][dp.length - 1];
    }
}
