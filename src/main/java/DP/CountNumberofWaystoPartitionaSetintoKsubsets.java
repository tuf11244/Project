/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *
 * @author parth
 */
public class CountNumberofWaystoPartitionaSetintoKsubsets {

    /**
     * S(n,k)=k×S(n−1,k)+S(n−1,k−1)
    This counts the partitions based on adding the 𝑛
and n-th element to existing subsets or creating a new subset.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        
        System.out.println(countWays(5,3));
    }
    
    public static int countWays(int people, int teams){
        
        if(people == 0 || teams == 0){
            return 0;
        }
        
        if(people < teams){
            return 0;
        }
        
        long dp[][] = new long[teams+1][people+1];
        
        for(int t = 1; t <= teams;t++){
            for(int p = 1; p <= people;p++){
               
               if(p < t){  //Number of teams are more than number of people
                    dp[t][p] = 0;
                }
                else if(p == t){ //Number of teams are equal to the number of people 
                    dp[t][p] = 1;
                }else{
                    dp[t][p] = dp[t-1][p-1] + dp[t][p-1] * t; //Recurrence Relation
                }
            }
        }
        return (int) dp[teams][people];
    }
}
