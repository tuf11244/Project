/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;
import java.util.*;
/**
 *Date: 02/06/2025
 * https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/
 * @author parth
 */
public class FindTheNumberofDistinctColorsAmongtheBalls {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int[] queryResults(int limit, int[][] queries) {

       // Below Hashmap would store the colors as the keys and the value would the houses painted with that color
       HashMap<Integer,HashSet<Integer>> hm = new HashMap<>();
       
       //Below HashMap would store the houseNumber vs colorNumber
       HashMap<Integer,Integer> colorMap = new HashMap<>();
        
        int[] result = new int[queries.length];

       for(int i = 0; i < queries.length;i++){
          int houseNumber = queries[i][0];
          int color = queries[i][1];
         
         //Not yet painted before
          if(colorMap.containsKey(houseNumber) == false){
                colorMap.put(houseNumber,color);
                
                if(hm.containsKey(color) ==true){
                        HashSet<Integer> temp = hm.get(color);
                        temp.add(houseNumber);
                        hm.put(color,temp);
                }else{
                     HashSet<Integer> temp = new HashSet<>();
                     temp.add(houseNumber);
                     hm.put(color,temp);
                }
          
          
          }else{
                if(color != colorMap.get(houseNumber)){
                     int oldColor = colorMap.get(houseNumber);

                     colorMap.put(houseNumber,color);
                     //Make Changes in our HashMap;

                     helper(hm,color,oldColor,houseNumber);
                }


          }
         result[i] = hm.size();
       
       }
       return result;  
    }

    public void helper(HashMap<Integer,HashSet<Integer>> hm, int color, int oldColor, int houseNumber){

        //Changes for the newColor;
        if(hm.containsKey(color) ==true){
            HashSet<Integer> temp = hm.get(color);
            temp.add(houseNumber);
            hm.put(color,temp);
            }else{
            HashSet<Integer> temp = new HashSet<>();
            temp.add(houseNumber);
            hm.put(color,temp);
        }


        //Changes for the OldColor 
          HashSet<Integer> temp = hm.get(oldColor);
          if(temp.size() == 1){
              hm.remove(oldColor);
          }else{
              temp.remove(houseNumber);
          }

    }
}
