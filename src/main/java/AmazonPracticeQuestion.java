/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.*;
/**
 *
 * @author parth
 */
public class AmazonPracticeQuestion {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] arr = {6, 1, 2, 3, 6};
        System.out.println(balancedServers(arr));
    }
    /*
    Amazon Web Services has n servers lined up in a row. 
    The th server has the capacity of capacity[i]. 
    Any application can be deployed on a balanced contiguous subsegment of 3 or more servers.
    A contiguous segment [l, r] of servers is said to be balanced if capacity[l] = capacity[r] = sum(capacity[l+1]... capacity[r-1]] i.e. the capacity of the servers at the endpoints of the segment should be equal to the sum of the capacity of all the interior servers.
    Given the capacity of each server in a row, find the number of balanced subsegments in it.

    Constraints:
    1<=n<=10^5
    1<= capacity[i] <= 10^9
    */
    public static int balancedServers(int[] arr){
        int[] prefix = new int[arr.length];
        
        prefix[0] = arr[0];
        
        for(int i = 1; i < arr.length;i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        
       
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        int count = 0;
        for(int i = 0; i < arr.length;i++){
              
            if(hm.containsKey(arr[i])){
                List<Integer> temp = hm.get(arr[i]);
                temp.add(i);
                hm.put(arr[i],temp);
                //System.out.println(arr[i] + "" + temp);
                for(int k = 0; k < temp.size();k++){
                    
                    if(i - temp.get(k) + 1 >= 3){
                        if(prefix[i] - prefix[temp.get(k)] - arr[i]== arr[i]){
                               count++;
                        }
                          
                    }else{
                        break;
                    }
                    
                }
                
                
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hm.put(arr[i],list);
            }
        }
        return count;
    }
}
