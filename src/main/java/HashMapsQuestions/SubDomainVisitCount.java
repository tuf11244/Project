/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Date: 03/21/2024
 *https://leetcode.com/problems/subdomain-visit-count/
 * @author parth
 */
public class SubDomainVisitCount {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String[] cpDomains = {"9001 discuss.leetcode.com"};
        System.out.println(subDomainVisits(cpDomains));
    }
    public static List<String> subDomainVisits(String[] cpDomains) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();

        for (String cpdomain : cpDomains) {
            // Split the input into count and domain
            String[] parts = cpdomain.split(" ");
            int rep = Integer.parseInt(parts[0]);
            String domain = parts[1];

            // Update visit count for each subdomain
            while (true) {
                hm.put(domain, hm.getOrDefault(domain, 0) + rep);
                int dotIndex = domain.indexOf('.');
                System.out.println(dotIndex);
                if (dotIndex == -1) break; // No more subdomains
                domain = domain.substring(dotIndex + 1); // Move to next subdomain
            }
        }

        // Convert map to list of strings
        for (HashMap.Entry<String, Integer> entry : hm.entrySet()) {
            answer.add(entry.getValue() + " " + entry.getKey());
        }

        return answer;
    }
}
