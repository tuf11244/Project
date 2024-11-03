 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *07/05/2024
 * https://leetcode.com/problems/paint-fence/
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 * @author parth
 */
public class PaintFence {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static long paintFence(int n, int k){
        
        if (n == 0) return 0;
        if (n == 1) return k;
        if(n == 2) return k*k;
        
        long same = k * 1; //the last 2 are same
        long diff = k * (k - 1); //the last 2 are different colors 
        long total = same + diff;
        
        for(int i = 3; i <= n;i++){
            same = diff * 1;
            diff = total * (k-1);
            total = same + diff;
        }
        
        return total;
    }
}
