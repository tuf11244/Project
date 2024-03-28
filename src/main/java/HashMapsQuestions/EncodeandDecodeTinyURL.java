/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 *Date :03/27/2024
 *https://leetcode.com/problems/encode-and-decode-tinyurl/
 * @author parth
 */
public class EncodeandDecodeTinyURL {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
class Codec {
    HashMap<String,String> hm = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder();
        sb.append((char)Math.floor(Math.random()*100));
        while(hm.containsKey(sb.toString())){
            sb.append((char)Math.floor(Math.random()*100));
        }
        hm.put(sb.toString(),longUrl);
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
         return hm.get(shortUrl); 
    }
}
