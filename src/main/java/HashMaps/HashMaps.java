/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMaps;
import java.util.HashMap;
import java.util.*;
/**
 *
 * @author parth
 */
public class HashMaps {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here\
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Parth",94);
        map.put("Rohan",87);
        map.put("Harsh",97);
        
      //  System.out.println(map.get("Parth"));
      //  System.out.println(map.getOrDefault("Arsh",-1));
       // System.out.println(map.containsKey("Parth"));
       
       //TreeSet stores values in sorted order 
       
       HashSet<Character> set = new HashSet<>();
       String duplicates = "aaaaaaaaaaaaab";
       for(int i = 0; i < duplicates.length();i++){
           set.add(duplicates.charAt(i));
       }
        System.out.println(set);
        
    }
}
