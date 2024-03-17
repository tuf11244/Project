/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 *Date: 03/17/2024
 *https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 * @author parth
 */
public class XofaKindinaDeck {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        //Frequency Map
        for(int i = 0; i < deck.length;i++){
            hm.put(deck[i],hm.getOrDefault(deck[i],0)+1);
        }

        int answer = 0;
        for(int key : hm.keySet()){
            answer = gcd(answer,hm.get(key));
        }
        if(answer >= 2){
            return true;
        }
        return false;
    }

    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);
    }
}
