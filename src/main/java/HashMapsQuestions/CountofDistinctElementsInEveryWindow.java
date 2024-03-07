/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
/**
 *Date: 03/04/2024
 * https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/
 * @author parth
 */
public class CountofDistinctElementsInEveryWindow {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static List<Integer> countDistict(int[] arr, int k){
	    List<Integer> list = new ArrayList<>();
	    HashMap<Integer,Integer> hm = new HashMap<>();
	    
	    //Acquire K element and create hashMap of frequencies
	    int i = 0;
	    while(i < k -1){
	        if(hm.containsKey(arr[i])){
	            int oldFrequency = hm.get(arr[i]);
	            hm.put(arr[i],oldFrequency+1);
	        }else{
	            hm.put(arr[i],1);
	        }
	        i++;
	    }
	    
	     i = i - 1; //Since i is at k-1;
	    int j = -1;
	    while(i < arr.length - 1){
	        i++;
	        //Acquire the element 
	        hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
	        
	        //Right the now our hashMap has k frequency//
	        list.add(hm.size());
	        
	        //Release 
	        j++;
	        int frequency = hm.get(arr[j]);
	        if(frequency == 1){
	            //Remove the element all together
	            hm.remove(arr[j]);
	        }else{
	            //Reduce the frequency by 1
	            hm.put(arr[j],frequency-1);
	        }
	    }
	    return list;
	}
}
