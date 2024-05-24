/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;

/**
 *Date: 05/23/2024
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 * @author parth
 */
public class SatisfiabilityofEqualityEquations {
    
    public static int parent[];
    public static int rank[];

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        String[] equations = {"b==a", "a==b"};
        System.out.println(equationsPossible(equations));
    }
    
    public static boolean equationsPossible(String[] equations){
        //Intialize the parent and rank arrays
       parent = new int[26];
       rank = new int[26];
       
       for(int i = 0; i < parent.length;i++){
           parent[i] = i;
           rank[i] = 1;
       }
        
       for(String equation : equations){
           
           int x = equation.charAt(0) - 'a';
           int y = equation.charAt(3) - 'a';
           
           char ch1 = equation.charAt(1);
           char ch2 = equation.charAt(2);
           
           if(ch1 == ch2){ //this is the case where ==
               //Process the == cases first 
               merge(x,y);
           }
           
        
       }
       return helper(equations);
    }
    
    public static boolean helper(String[] equations){
        
        for(String equation : equations){
            
           int x = equation.charAt(0) - 'a';
           int y = equation.charAt(3) - 'a';
           
           char ch1 = equation.charAt(1);
           char ch2 = equation.charAt(2);
           
           if(ch1 != ch2){
               
               int p1 = find(x);
               int p2 = find(y);
               
               if(p1 == p2){
                   return false;
               }
           }
        }
        return true;
    }
    
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
    
    public static void merge(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(rank[lx] > rank[ly]){
            parent[ly] = lx;
        }
        else if(rank[lx] < rank[ly]){
            parent[lx] = ly;
        }else{
            parent[lx] = ly;
            rank[ly]++;
        }
    }
}
