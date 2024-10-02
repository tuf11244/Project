/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblemsPart2;
import java.util.*;
/**
 *Date: 10/02/2024
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
 * @author parth
 */
public class LowestCommonAncestorIII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public Ancestor lowestCommonAncestor(Ancestor p, Ancestor q){
        Set<Ancestor> set = new HashSet<>();
        
        Ancestor temp = p;
        
        while(temp != null){
            set.add(temp);
            temp = temp.parent;
        }
        
        temp = q;
        while(temp != null){
            if(set.contains(temp)){
                return temp;
            }
            temp = temp.parent;
        }
        return null;
    }
}

class Ancestor{
    int val;
    Ancestor left;
    Ancestor right;
    Ancestor parent;
    
    public Ancestor(int val, Ancestor left, Ancestor right, Ancestor parent){
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
    
}
