/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 10/26/2024
 *https://leetcode.com/problems/minimum-cost-for-tickets/
 * @author parth
 */
public class MinimumCostForTickets {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int mincostTickets(int[] days, int[] costs) {
        
        Set<Integer> travelDays = new HashSet<>();

        for(int day : days){
            travelDays.add(day);
        }

        int[] dp = new int[days[days.length - 1] + 1]; //for 0 based indexing;
        dp[0] = 0; //no cost for travelling on the 0th day

        for(int i = 1; i < dp.length;i++){
            if(travelDays.contains(i)){

            int oneDayPass = costs[0] + dp[i-1];
            int sevenDayPass = costs[1] + (i >= 7 ? dp[i-7] : 0);
            int thirtyDayPass= costs[2] + (i >= 30 ? dp[i-30] : 0);                

                dp[i] = Math.min(oneDayPass,Math.min(sevenDayPass,thirtyDayPass));

            }else{
                dp[i] = dp[i-1];
            }
        }

        return dp[dp.length -1];
    }
}
