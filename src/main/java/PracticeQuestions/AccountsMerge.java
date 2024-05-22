/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PracticeQuestions;
import java.util.*;
/**
 *Date: 05/21/2024
 * https://leetcode.com/problems/accounts-merge/
 * @author parth
 */
public class AccountsMerge {

    /**
     * @param args the command line arguments
     */
    public static int[] parent;
    public static int[] rank;
    public static void main(String args[]) {
        
        List<String> list1 = new ArrayList<>();
        list1.add("John");
        list1.add("johnsmith@mail.com");
        list1.add("john_newyork@mail.com");
        
        List<String> list2 = new ArrayList<>();
        list2.add("John");
        list2.add("johnsmith@mail.com");
        list2.add("john00@mail.com");
        
        List<String> list3 = new ArrayList<>();
        list3.add("Mary");
        list3.add("mary@mail.com");
        
        List<String> list4 = new ArrayList<>();
        list4.add("John");
        list4.add("johnnybravo@mail.com");
        
        List<String> list5 = new ArrayList<>();
        list5.add("John");
        list5.add("johnsmith@mail.com");
        
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(list1);
        accounts.add(list2);
        accounts.add(list3);
        accounts.add(list4);
        accounts.add(list5);
        
       List<List<String>> answer =  accountsMerge(accounts);
       
       for(List<String> a : answer){
           System.out.println(a);
       }
    }
    public static List<List<String>>  accountsMerge(List<List<String>> accounts) {
        //Create a HashMap of String vs List<Integer> 
        //String would the key it would have the emails 
        //List<Integer> would be the cell numbers that need to be merged 
        HashMap<String, List<Integer>> hm = new HashMap<>();
        
        int index = 0; //denotes cell number 
        
        for(List<String> account : accounts){
            for(int i = 1; i < account.size();i++){
                if(hm.containsKey(account.get(i))){
                    List<Integer> list = hm.get(account.get(i));
                    list.add(index);
                    
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(index);
                    hm.put(account.get(i),list);
                }
            }
            index++;
        }
        
        //Initialize the parent and rank arrays
        parent = new int[accounts.size()];
        rank = new int[accounts.size()];
        
        for(int i = 0; i < parent.length;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(List<Integer> list : hm.values()){
            if(list.size() > 1){
               //merge the accounts 
               int x = list.get(0);
               for(int i = 1; i < list.size();i++){
                   union(x,list.get(i));
               }
            }
        }
        
        
        //Now merging would happen 
        HashMap<Integer,List<Integer>> merge = new HashMap<>();
        //Key is the parent
        //Value is the childrens 
        for(int i = 0; i < parent.length;i++){
            if(merge.containsKey(parent[i])){
                List<Integer> list = merge.get(parent[i]);
                list.add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                merge.put(parent[i], list);
            }
        }
        
        System.out.println(merge);
        List<List<String>> answer = new ArrayList<>();
        
        for(int element : merge.keySet()){
            List<String> temp = new ArrayList<>();
           // temp.add(accounts.get(element).get(0));  // this is the name;
             
            List<Integer> list = merge.get(element);
            
            if(list.size() > 1){
                for(int i = 0; i < list.size();i++){
                
                List<String> acc = accounts.get(i);
                
                for(int j = 1; j < acc.size();j++){
                    if(!temp.contains(acc.get(j))){
                       temp.add(acc.get(j));
                }
                    
            } 
            }
            Collections.sort(temp);
            temp.add(0,accounts.get(element).get(0));
            answer.add(temp);
            }
            else{
                List<String> acc = accounts.get(list.get(0));
                
                for(int j = 1; j < acc.size();j++){
                      if(!temp.contains(acc.get(j))){
                       temp.add(acc.get(j));
                }
                }
               
                
            Collections.sort(temp);
            temp.add(0,accounts.get(element).get(0));
            answer.add(temp); 
                
            }
       
    }
        return answer;
    }
    
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
    
    public static void union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx;
            }else if(rank[lx] < rank[ly]){
                parent[lx] = ly;
            }else{
                parent[lx] = ly;
                rank[ly]++;
            }
        }
    }
}
