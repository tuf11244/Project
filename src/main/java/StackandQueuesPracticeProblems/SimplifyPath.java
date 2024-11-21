/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;
import java.util.*;
/**
 *Date: 11/21/2024
 * https://leetcode.com/problems/simplify-path/
 * @author parth
 */
public class SimplifyPath {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public String simplifyPath(String path) {
        int i = 0;
        Stack<String> st = new Stack<>();

        // Split path by "/"
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("..")) {
                // Parent directory: Pop the stack if it's not empty
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (!component.equals("") && !component.equals(".")) {
                // Non-empty, non-dot directory: Push onto the stack
                st.push(component);
            }
        }

        // If the stack is empty, return "/"
        if (st.isEmpty()) {
            return "/";
        }

        // Build the simplified path from the stack
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, "/" + st.pop());
        }

        return sb.toString();
    }
}
