/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PracticeQuestions;
import java.util.*;
/**
 *Date: 05/21/2024
 * https://leetcode.com/problems/accounts-merge/
 * @author parth
 */
public class AccountsMerge {

    /**
     * @param args the command line arguments
     */
    public static int[] parent;
    public static int[] rank;
    public static void main(String args[]) {
        
       List<String> list1 = Arrays.asList("Hanzo","Hanzo2@m.co","Hanzo3@m.co");
       List<String> list2 = Arrays.asList("Hanzo","Hanzo4@m.co","Hanzo5@m.co");
       List<String> list3 = Arrays.asList("Hanzo","Hanzo0@m.co","Hanzo1@m.co");
       List<String> list4 = Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo4@m.co");
       List<String> list5 = Arrays.asList("Hanzo","Hanzo7@m.co","Hanzo8@m.co");
       List<String> list6 = Arrays.asList("Hanzo","Hanzo1@m.co","Hanzo2@m.co");
       List<String> list7 = Arrays.asList("Hanzo","Hanzo6@m.co","Hanzo7@m.co");
       List<String> list8 = Arrays.asList("Hanzo","Hanzo5@m.co","Hanzo6@m.co");
        
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(list1);
        accounts.add(list2);
        accounts.add(list3);
        accounts.add(list4);
        accounts.add(list5);
        accounts.add(list6);
        accounts.add(list7);
        accounts.add(list8);
        
        
       List<List<String>> answer =  accountsMerge(accounts);
       
       for(List<String> a : answer){
           System.out.println(a);
       }
    }
    public static List<List<String>>  accountsMerge(List<List<String>> accounts) {
        // Create a HashMap to map each email to the index of the account it belongs to
        HashMap<String, Integer> emailToIndex = new HashMap<>();
        int index = 0;

        // Initialize the parent and rank arrays for union-find operations
        parent = new int[accounts.size()];
        rank = new int[accounts.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // Iterate through each account
        for (List<String> account : accounts) {
            // Get the account name (the first element in the list)
            String name = account.get(0);
            // Iterate through each email in the account
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                // If the email is not already in the map, add it with the current index
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, index);
                } else {
                    // If the email is already in the map, union the current index with the index in the map
                    union(emailToIndex.get(email), index);
                }
            }
            index++;
        }
//        System.out.println(emailToIndex);
//        System.out.println(Arrays.toString(parent));
        
        // Create a map to associate each root parent index with a set of emails
        HashMap<Integer, Set<String>> indexToEmails = new HashMap<>();
        // Iterate through each email and its index in the map
        for (Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {
            String email = entry.getKey();
            int rootIndex = find(entry.getValue()); // Find the root parent index for the current email
            // If the root parent index is not in the map, add it with a new HashSet
            if (!indexToEmails.containsKey(rootIndex)) {
                indexToEmails.put(rootIndex, new HashSet<>());
            }
            // Add the email to the set associated with the root parent index
            indexToEmails.get(rootIndex).add(email);
        }

        // Create a list to store the merged accounts
        List<List<String>> mergedAccounts = new ArrayList<>();
        // Iterate through each entry in the indexToEmails map
        for (Map.Entry<Integer, Set<String>> entry : indexToEmails.entrySet()) {
            int rootIndex = entry.getKey();
            Set<String> emails = entry.getValue();
            // Convert the set of emails to a list and sort it
            List<String> mergedAccount = new ArrayList<>(emails);
            Collections.sort(mergedAccount);
            // Add the account name at the front of the list
            mergedAccount.add(0, accounts.get(rootIndex).get(0));
            // Add the merged account to the final list
            mergedAccounts.add(mergedAccount);
        }

        return mergedAccounts;
    }
    
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
    
    public static void union(int x, int y){
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
