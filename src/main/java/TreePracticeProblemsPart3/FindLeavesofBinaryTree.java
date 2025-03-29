/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TreePracticeProblemsPart3;
import java.util.*;
/**
 *Date:03/29/2025
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 * @author parth
 */
public class FindLeavesofBinaryTree extends TreeNodes {
    public static HashMap<Integer,List<Integer>> hm;
    
    public static void main(String[] args) {
        hm = new HashMap<>();

    }
    
    public static int getLeaves(TreeNode root){
            if(root == null){
                return 0;
            }
            
            int leftHeight = getLeaves(root.left);
            int rightHeight = getLeaves(root.right);
            
            int totalHeight = 1 + Math.max(leftHeight,rightHeight);
            
            if(hm.containsKey(totalHeight)){
                List<Integer> list = hm.get(totalHeight);
                list.add(root.val);
                hm.put(totalHeight, list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                hm.put(totalHeight,list);
            }
            
            return totalHeight;
    }
}
