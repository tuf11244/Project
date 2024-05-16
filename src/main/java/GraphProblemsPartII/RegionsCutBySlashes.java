/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;

/**
 *Date: 05/15/2024
 * https://leetcode.com/problems/regions-cut-by-slashes/
 * @author parth
 */
public class RegionsCutBySlashes {

    /**
     * @param args the command line arguments
     */
    public static int[] parent;
    public static int[] rank;
    public static int count;
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int dots = n+1;
        
        parent = new int[dots*dots];
        rank = new int[dots*dots];
        
        //Intialize our parent and rank arrays
        for(int i = 0; i < parent.length;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        //Intialize count variable with 1;
        count = 1;
        
        // Connect dots based on slashes
        for(int i = 0; i < dots;i++){
            for(int j = 0; j < dots; j++){
                //checking for the dots on the border
                if(i == 0 || i == dots - 1 || j  == 0 || j == dots -1){
                        int cellnumber = i * dots + j;
                        if(cellnumber != 0){
                            union(0,cellnumber); // we are merging 0 with the dots on the boundary
                        }       
                }
            }
        }
        
        for(int i = 0; i < grid.length;i++){
            char [] ch = grid[i].toCharArray();
            for(int j = 0; j < ch.length;j++){
                if(ch[j] == '/'){
                    int cellnumber1 = i * dots + (j+1);
                    int cellnumber2 = (i+1) * dots + j;
                    
                    union(cellnumber1,cellnumber2);
                }else if(ch[j] == '\\'){
                    int cellnumber1 = i * dots + j;
                    int cellnumber2 = (i+1)*dots + (j+1);
                    
                    union(cellnumber1,cellnumber2);
                }
            }
        }
        
        return count;
    }
    
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;  //Path Compression
        return temp;
    }
    
    public static void union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(lx!=ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx;
            }else if(rank[lx] < rank[ly]){
                parent[lx] = ly;
            }else{
                parent[lx] = ly;
                rank[ly]++;
            }
        }else{
            count++;  //// Increment count when we find a cycle indicating a new region
        }
    }
    
    
}
