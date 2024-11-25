/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;
import java.util.*;
/**
 *Date: 11/22/2024
 * https://leetcode.com/problems/number-of-orders-in-the-backlog/
 * @author parth
 */
public class NumberofOrdersinthebacklog {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    
}
//https://leetcode.com/problems/number-of-orders-in-the-backlog/
class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Pair> buy = new PriorityQueue<>(Collections.reverseOrder()); // Max heap for buys
        PriorityQueue<Pair> sell = new PriorityQueue<>(); // Min heap for sells
        long mod = 1000000007;

        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int orderType = order[2];

            if (orderType == 0) { // Buy order
                while (!sell.isEmpty() && sell.peek().price <= price && amount > 0) {
                    Pair p = sell.poll();
                    if (p.amount > amount) {
                        sell.add(new Pair(p.price, p.amount - amount));
                        amount = 0;
                    } else {
                        amount -= p.amount;
                    }
                }
                if (amount > 0) {
                    buy.add(new Pair(price, amount));
                }
            } else { // Sell order
                while (!buy.isEmpty() && buy.peek().price >= price && amount > 0) {
                    Pair p = buy.poll();
                    if (p.amount > amount) {
                        buy.add(new Pair(p.price, p.amount - amount));
                        amount = 0;
                    } else {
                        amount -= p.amount;
                    }
                }
                if (amount > 0) {
                    sell.add(new Pair(price, amount));
                }
            }
        }

        long result = 0;

        // Sum up remaining orders in the buy and sell queues
        while (!buy.isEmpty()) {
            result = (result + buy.poll().amount) % mod;
        }
        while (!sell.isEmpty()) {
            result = (result + sell.poll().amount) % mod;
        }

        return (int) result;
    }
}

class Pair implements Comparable<Pair> {
    long price;
    long amount;

    public Pair(long price, long amount) {
        this.price = price;
        this.amount = amount;
    }

    public int compareTo(Pair o) {
        return Long.compare(this.price, o.price);
    }
}
