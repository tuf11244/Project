/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Algorithms;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author parth
 */
public class HuffmanCoder {
     HashMap<Character,String> encoder;
     HashMap<String,Character> decoder;
     
     public HuffmanCoder(String feeder) throws Exception {
         //Create a frequency Map
         HashMap<Character,Integer> fmap = new HashMap<>();
         for(int i = 0; i < feeder.length();i++){
             fmap.put(feeder.charAt(i), fmap.getOrDefault(feeder.charAt(i),0)+1);
         }
         
         PriorityQueue<Node> pq = new PriorityQueue<>();
         
         //Inser the key,value pair from our frequency map to our PriorityQueue
         for(char ch : fmap.keySet()){
             Node node = new Node(ch,fmap.get(ch));
             pq.add(node);
         }
         
         while(pq.size()!=1){
             Node first = pq.poll();
             Node second = pq.poll();
             
             //Create a new combine Node 
             Node newNode = new Node('/',first.frequency + second.frequency);
             newNode.left = first;
             newNode.right = second;
             
             pq.add(newNode);
         }
        
         Node root = pq.poll();
         this.encoder = new HashMap<>();
         this.decoder = new HashMap<>();
         
         //Below function will fill up our hashmap
         this.initEncoderDecoder(root,"");
     }
     
     private void initEncoderDecoder(Node root, String output){
         if(root == null){
             return;
         }
         //Below means its a child Node;
         if(root.left == null && root.right == null){
           this.encoder.put(root.ch, output);
           this.decoder.put(output,root.ch);
         }
         
         //Recursion calls 
         initEncoderDecoder(root.left,output+"0");
         initEncoderDecoder(root.right,output+"1");
     }
     
     public String encode(String source){
         String answer = "";
         for(int i = 0; i < source.length();i++){
             answer = answer + encoder.get(source.charAt(i));
         }
         return answer;
     }
     public String decode(String codedString){
         String answer = "";
         String key = "";
         
         for(int i = 0; i < codedString.length();i++){
             key = key + codedString.charAt(i);
             if(decoder.containsKey(key)){
                 answer = answer + decoder.get(key);
                 //Reset the key variable
                 key = "";
             }
         }
         return answer;
         
     }
     
     
     private class Node implements Comparable<Node>{
         char ch;
         int frequency;
         Node left;
         Node right;
         public Node(char ch, int frequency){
             this.ch = ch;
             this.frequency = frequency;
             this.left = null;
             this.right = right;
         }

        @Override
        public int compareTo(Node o) {
          return this.frequency - o.frequency;
        }
         
         
     }
     

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        String message = "abbccda";
        HuffmanCoder hc = new HuffmanCoder(message);
        String codedString = hc.encode(message);
        System.out.println("Coded String " + codedString);
        String decodedString = hc.decode(codedString);
        System.out.println("Decoded String " + decodedString);
    }
}
