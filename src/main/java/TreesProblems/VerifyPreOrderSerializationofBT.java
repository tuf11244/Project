/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreesProblems;
import java.util.Scanner;
/*
Date: 03/25/2025
https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
*/


public class VerifyPreOrderSerializationofBT{
     public static void main(String[] args) {
        
    }
     public boolean isValidSerialization(String preorder) {
       String[] nodes = preorder.split(",");
        int slots = 1; // Root needs one slot

        for (String node : nodes) {
            slots--; // One node consumes a slot
            if (slots < 0) {
                return false; // More nodes than available slots
            }
            if (!node.equals("#")) {
                slots += 2; // Non-null nodes add two child slots
            }
        }
        return slots == 0; // All slots should be exactly used up

        
    }
    
}


