/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 11/23/2023
 *https://www.hackerrank.com/challenges/password-cracker
 * @author parth
 */
public class PasswordCracker {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        List<String> passwords = List.of("abra","ka", "dabra");
        String attempt = "abrakadabra";
        String result = passwordCracker(passwords, attempt);
        System.out.println(result);
    }
    
    
    public static String passwordCracker(List<String> passwords, String attempt) {
        List<String> result = new ArrayList<>();
        if (backtrack(0, passwords, attempt, result)) {
            return String.join(" ", result);
        } else {
            return "WRONG PASSWORD";
        }
    }
    private static boolean backtrack(int start, List<String> passwords, String attempt, List<String> result) {
        if (start == attempt.length()) {
            return true;
        }

        for (String password : passwords) {
            if (attempt.startsWith(password, start)) {
                result.add(password);
                if (backtrack(start + password.length(), passwords, attempt, result)) {
                    return true;
                }
                result.remove(result.size() - 1); // Backtrack
            }
        }

        return false;
    }
}
