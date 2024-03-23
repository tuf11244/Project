/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 * Date: 03/23/2024
 *https://www.geeksforgeeks.org/problems/pairs-of-non-coinciding-points4141/1
 * @author parth
 */
public class PairsofNonCoincidingPoints {

    /**
     * Note: Pair of 2 points(A,B) is considered different from  Pair of 2 points(B ,A).
    Manhattan Distance = |x2-x1|+|y2-y1|
    Euclidean Distance   = ((x2-x1)^2 + (y2-y1)^2)^0.5, where points are (x1,y1) and (x2,y2).
    * //Since its already given in question that MD and ED have to be equal 
    * 
    *  Step 1 : Compare them ---> |x2-x1|+|y2-y1| = ((x2-x1)^2 + (y2-y1)^2)^0.5
    * Step 2 :  Take square both sides
    * Step 3 : After solving them you will find out that for the above condition to hold true one of the following cases should be true
    *       Case 1 : x1 is equal to x2;
    *       Case 2 : y1 is equal to y2;
    *       Case 3 : x1 is equal to x2 && y1 is equal to y2
    *      
    * But Case 3 wouldn't be applicable as points can't coincide 
    * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[]X = {1,2,1};
        int[]Y = {2,3,3};
        System.out.println(numOfPairs(X,Y,3));
    }
    
    public static int numOfPairs(int[] X, int[] Y, int N) {
       //Create HashMap for x points 
       HashMap<Integer,Integer> xMap = new HashMap<>();
       
       //Create HashMap for y points 
       HashMap<Integer,Integer> yMap = new HashMap<>();
       
       //Create HashMap for x and y points 
       HashMap<String,Integer> xyMap = new HashMap<>();
       int answer = 0;
       for(int i = 0; i < X.length;i++){
           int x = X[i];
           int y = Y[i];
           
           String key = x + "#" +y;
           
           int xFreq = xMap.getOrDefault(x,0);
           int yFreq = yMap.getOrDefault(y,0);
           int xyFreq = xyMap.getOrDefault(key,0);
           
           answer = answer + xFreq + yFreq - (2 * xyFreq);
           
           xMap.put(x, xFreq+1);
           yMap.put(y, yFreq+1);
           xyMap.put(key, xyFreq+1);
       }
        return answer;      
    }
}
