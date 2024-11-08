/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP.KnapSack;

/**
 *
 * @author parth
 */
public class KnapSackRecursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] values = {15,14,10,45,30};
        int[] weight = {2,5,1,3,4};
        
        int answer = knapSack(values,weight,7,0);
        System.out.println(answer);
    }
    
    public static int knapSack(int[] values, int[] weight, int capacity, int index){
        if(index == weight.length){
            return 0;
        }
        int pick = 0;
        int skip = 0;
        
        if(weight[index] <= capacity){
            pick = values[index] + knapSack(values,weight,capacity - weight[index],index+1);
        }
        skip = knapSack(values,weight,capacity,index);
        
        return Math.max(pick, skip);
    }
    
    
}
