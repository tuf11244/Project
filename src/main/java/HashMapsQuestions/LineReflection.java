/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 *https://leetcode.com/problems/line-reflection/
 * Date: 03/23/2024
 * @author parth
 */
public class LineReflection {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] points = {
            {1,1},
            {-1,1}
        };
        
        System.out.println(isReflected(points));
    }
    
    public static boolean isReflected(int[][] points){
        //Create a HashMap;
        HashMap<Long,Long> hm = new HashMap<>();
        
        //Get the maximum x coordinate 
        //Get the minimum y coordinate
        long xMax = Integer.MIN_VALUE;
        long xMin = Integer.MAX_VALUE;
        
        for(int[] point : points){
            long x = point[0];
            long y = point[1];
            
            xMax =  Math.max(xMax,x);
            xMin =  Math.min(xMin, x);
            
            //Create a key so we can put that in our hash Map 
            long key = x  * 100000000 + y;
            hm.put(key, 1L);
        }
        
        //Now find the mirror i.e. if a line at x distance than the reflected line would at -x distance 
        long mirror = xMax + xMin;
        
        for(int[] point : points){
            long x = point[0];
            long y = point[1];
            
            long xImage = mirror - x;
            long yImage = y; //Since we have to find it parrallel to y axis 
            
            //Create a key for our image axis 
            long keyImage = xImage * 100000000 + y;
            //If our hashMap doesnt contain the keyImage return false
            if(!hm.containsKey(keyImage)){
                return false;
            }
        }
        return true;
        
    }
}
