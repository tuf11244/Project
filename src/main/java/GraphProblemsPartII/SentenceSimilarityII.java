/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/24/2024
 * https://leetcode.com/problems/sentence-similarity-ii/
 * @author parth
 */
public class SentenceSimilarityII {
    
    public static int[] parent;
    public static int[] rank;
    /**
     * My Method : We are just iterating over the pairs array and storing the indices of the word, O(N^2)
     *             After that we iterate over the pairs array again and merge them two words based up on their indices 
     *             Lastly we iterate over our words array and find the parents of the words if they are not same we return false
     * 
     * Alternate Method : Since my first part gives O(N^2) we can reduce it to O(N) by just put an 
     *                    index in our hash map instead of the indices. Rest of the logic is same
     * 
     * PepCoding Method : Use 2 HashMap<String,String> as our parent and HasMap<String,Integer> as our rank
     *              
     * 
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
       String[] word1 = {"great", "acting"};
        String[] word2 = {"fine", "skills"};
        String[][] pairs = {
    {"great", "good"},
    {"fine", "good"},
    {"acting", "drama"}
};
// Expected output: false

// Expected output: true

        
        if(sentenceSimilarityII(word1,word2,pairs)){
            System.out.println("The sentences are similar ");
        }else{
            System.out.println("The sentences are not similar ");
        }
    }
    
    public static boolean sentenceSimilarityII(String[] word1, String[] word2, String[][] pairs){
        if(word1.length!=word2.length){
            return false;
        }
        
        if(pairs.length == 0){
            for(int i = 0; i < word1.length;i++){
                if(!word1[i].equals(word2[i])){
                    return false;
                }
            }
            return true;
        }
        
        HashMap<String,List<Index>> hm = new HashMap<>();
        
        //Intialize the parent and rank arrays
        parent = new int[pairs.length * pairs[0].length];
        rank = new int[pairs.length * pairs[0].length];
        
        for(int i = 0; i < parent.length;i++){
            parent[i]= i;
            rank[i] = 1;
        }
        
        for(int i = 0; i < pairs.length;i++){
            for(int j = 0; j < pairs[0].length;j++){
                if(hm.containsKey(pairs[i][j])){
                    List<Index> list = hm.get(pairs[i][j]);
                    list.add(new Index(i,j));                  
                }else{
                    List<Index> list = new ArrayList<>();
                    Index idx = new Index(i,j);
                    list.add(idx);
                    hm.put(pairs[i][j],list);
                }
            }
        }
        
       for(String[] pair : pairs){
           String w1 = pair[0];
           String w2 = pair[1];
           
           //Get the coordinate for w1 and w2
           List<Index> lw1 = hm.get(w1);
           List<Index> lw2 = hm.get(w2);
           
           int x = lw1.get(0).i * pairs[0].length + lw1.get(0).j;
           int y = lw2.get(0).i * pairs[0].length + lw2.get(0).j;
           
           merge(x,y);
           
        }
       
       for(int k = 0; k < word1.length;k++){
           if(word1[k].equals(word2[k])){
               continue;
           }
           if(!hm.containsKey(word1[k]) || !hm.containsKey(word2[k])){
               return false;
           }
           
           List<Index> lw1 = hm.get(word1[k]);
           List<Index> lw2 = hm.get(word2[k]);
           
           int x = lw1.get(0).i * pairs[0].length + lw1.get(0).j;
           int y = lw2.get(0).i * pairs[0].length + lw2.get(0).j;
           
           int p1 = find(x);
           int p2 = find(y);
           
           if(p1 != p2){
               return false;
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

class Index{
    int i;
    int j;
    
    public Index(int i,int  j){
        this.i = i;
        this.j = j;
    }
}
