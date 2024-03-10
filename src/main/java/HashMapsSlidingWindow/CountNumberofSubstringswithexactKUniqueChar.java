/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.HashMap;

/**
 * Date: 03/10/2024
 *https://www.geeksforgeeks.org/count-number-of-substrings-with-exactly-k-distinct-characters/
 * @author parth
 */
public class CountNumberofSubstringswithexactKUniqueChar {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(substringswithKUnique("aabbbcca",1));
    }
    
    public static int substringswithKUnique(String s, int k){
        int count = 0;
        
        if(k == 1){
            return helper(s);
        }
        
        
        
        //Big HashMap to collect k unique Characters 
        HashMap<Character,Integer> mapb = new HashMap<>();
        
        //Small HashMap to collect k-1 unique characters 
        HashMap<Character,Integer> maps = new HashMap<>();
        
        //Pointer for bigHashmap 
        int ibig = -1;
        int ismall = -1;
        int j = -1;
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            boolean f3 = false;
            
            //Acquire elements in big HashMap 
            while(ibig < s.length()-1){
                f1 = true;
                
                ibig++;
                char ch = s.charAt(ibig);
                mapb.put(ch, mapb.getOrDefault(ch,0)+1);
                
                if(mapb.size() == k+1){
                    //Remove the extra element
                    removeInMap(mapb,ch);
                    //decrease the pointer by 1
                    ibig--;
                    break;
                }
            }
            
            //Acquire elements in small HashMap  
            while(ismall < ibig){
                f2 = true;
                
                ismall++;
                char ch = s.charAt(ismall);
                maps.put(ch, maps.getOrDefault(ch,0)+1);
                
                if(maps.size() == k){
                    removeInMap(maps,ch);
                    ismall--;
                    break;      
                }
            }
            
            //Release the elements
            while(j < ismall){
                f3 = true;
                
                //Collect the answer 
                if(mapb.size() == k && maps.size() == k-1){
                    count = count + (ibig - ismall);
                }
                
                j++;
                char ch = s.charAt(j);
                removeInMap(mapb,ch);
                removeInMap(maps,ch);
                
                if(mapb.size() < k || maps.size() < k -1){
                    break;
                }
            }
             
            if(f1 == false && f2 == false && f3 == false){
                break;
            }
                    
        } 
        
        return count;
    }
    
    public static int helper(String s){
        int count = 0;
        int i = -1;
        int j = -1;
        HashMap<Character,Integer> hm = new HashMap<>();
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            //Acquire
            while(i < s.length()-1){
                f1 = true;
                i++;
                char ch = s.charAt(i);
                hm.put(ch,hm.getOrDefault(ch,0)+1);
                
                if(hm.size() == 2){
                    removeInMap(hm,ch);
                    i--;
                    break;
                }
            }
            
            //Release
            while(j < i){
                f2 = true;
                
                if(hm.size() ==1){
                    count = count + (i-j);
                    
                    j++;
                    char ch = s.charAt(j);
                    removeInMap(hm,ch);
                    
                    if(hm.size() ==0){
                        break;
                    }
                }
            }
            
            if(f1 == false && f2 == false){
                break;
            }
        }
        
        
        return count;
    }
    
    public static void removeInMap(HashMap<Character,Integer> hm, char ch){
        if(hm.get(ch) == 1){
            hm.remove(ch);
        }else{
        hm.put(ch, hm.get(ch)-1);
    }
    }
}
