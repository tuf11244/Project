/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart3;
import java.util.*;
/**
 *
 * @author parth
 */
public class ReverseOddLevelsofBinaryTree extends TreeNodes {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    
    //BFS 
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));

        while(!queue.isEmpty()){
           
            int level = queue.size();
            List<TreeNode> oddLevel = new ArrayList<>();
            //Process the chidren first;
            for(int i =0; i < level;i++){
                Pair rem = queue.poll();
                
                if(rem.level % 2 == 0){
                    continue;

                }else{
                    oddLevel.add(rem.node);                   

                }

                if(rem.node.left != null){
                        queue.add(new Pair(rem.node.left,rem.level+1));
                    }
                    if(rem.node.right != null){
                        queue.add(new Pair(rem.node.right,rem.level+1));
                    }

            }

            //Swap;
                if(oddLevel.size() != 0){
                    int left = 0;
                int right = oddLevel.size() - 1;
                
                while (left < right) {
                    // Swap the values of nodes at the current odd level
                    int temp = oddLevel.get(left).val;
                    oddLevel.get(left).val = oddLevel.get(right).val;
                    oddLevel.get(right).val = temp;

                    // Move pointers towards the center
                    left++;
                    right--;
                }
                }
        
        
        }

        

        return root;
    }
    
    
    public TreeNode reverseOddLevelsDFS(TreeNode root){
        dfs(root.left,root.right,1);
        
        return root;
    }
    public void dfs(TreeNode left, TreeNode right, int level){
        
        if(left == null || right == null){
            return;
        }
        
        if(level % 2 != 0){
            int temp = right.val;
            right.val = left.val;
            left.val = temp;  
        }
        
        dfs(left.left,right.right,level+1);
        dfs(left.right,right.left,level+1);
    }
}
class Pair{
    TreeNode node;
    int level;

    public Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}

