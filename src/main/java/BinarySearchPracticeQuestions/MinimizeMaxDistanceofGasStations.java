/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;

/**
 * Date: 02/18/2024
 *https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/
 * @author parth
 */
public class MinimizeMaxDistanceofGasStations {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(findSmallestMaxDist(arr,9));
    }
    public static double findSmallestMaxDist(int stations[],int K) {
    // code here
        int n = stations.length; // size of the array
        double low = 0;
        double high = 0;

        //Find the maximum distance:
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double)(stations[i + 1] - stations[i]));
        }

        //Apply Binary search:
        double diff = 1e-6 ;
        while (high - low > diff) {
            double mid = (low + high) / (2.0);
            int cnt = numberOfGasStationsRequired(mid, stations);
            if (cnt > K) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;

  }
   public static int numberOfGasStationsRequired(double dist, int[] stations) {
        int n = stations.length; // size of the array
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int)((stations[i] - stations[i - 1]) / dist);
            if ((stations[i] - stations[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }
}
