/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart3;

/**
 *Date: 10/26/2024
 * https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/
 * @author parth
 */
public class HeightofBinaryTreeAfterSubtreeRemovalQueries extends TreeNodes {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    private int[] level; //level of each node
    private int[] height; //height of each node
    private int[] maxHeight; //This gives the maximum height at each level 
    private int[] secondMaxHeight; //This gives the second maximum height at each level
    
    public  int[] treeQueries(TreeNode root, int[] queries){
        level = new int[1000001];
        height = new int[1000001];
        maxHeight = new int[1000001];
        secondMaxHeight = new int[1000001];
        
        findHeight(root,0); //0 is the level
        
        int[] result = new int[queries.length];
        
        for(int i = 0; i < queries.length;i++){
            int node = queries[i];
            
            int L = level[node];
            
            //Calculate new height if subtree rooted at node is removed
            int tempResult = L + (maxHeight[L] == height[node] ? secondMaxHeight[L] : maxHeight[L]) - 1;
            
            result[i] = tempResult;
        }
        
        return result;
    }
    
    // Helper function to calculate heights and maintain max/second max heights at each level
    private int findHeight(TreeNode root, int l){
         if(root == null){
             return 0;
         }
         level[root.val] = l; // Assign level for the current node
         height[root.val] = 1 + Math.max(findHeight(root.left,l+1),findHeight(root.right,l+1));
         
         
         // Update max and second max heights for the current level
         if(maxHeight[l] < height[root.val]){
              secondMaxHeight[l] = maxHeight[l];
              maxHeight[l] = height[root.val];
              
         }else if(secondMaxHeight[l] < height[root.val]){
             secondMaxHeight[l] = height[root.val];
         }
        return height[root.val];
    }
}
