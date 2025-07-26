/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Algorithms;

/**
 *Date: 04/16/2024
 * @author parth
 */
public class KarpRabinAlgorithm {

    /**
     * @param args the command line arguments
     */
    
    private static final int PRIME = 101;
    public static void main(String args[]) {
        String text = "ParthVrajeshbhaiNagindasLallubhaiGordhandasDesai";
        String pattern = "Nagindas";
        search(text,pattern);
    }
    
    private static double calculateHash(String s){
        double hash = 0;
        for(int i = 0; i < s.length();i++){
            hash = hash + s.charAt(i) * Math.pow(PRIME,i);
        }
        return hash;
    }
    
    private static double updateHash(double prevHash,char oldChar, char newChar, int patternLength){
        double newHash = (prevHash - oldChar)/PRIME;
        newHash = newHash + newChar * Math.pow(PRIME,patternLength-1);
        return newHash;
    }
    
    public static void search(String text,String pattern){
        int patternLength = pattern.length();
        double patternHash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0, patternLength));
        
        for(int i = 0; i <= text.length() - patternLength;i++){
            if(textHash == patternHash){
                if(text.substring(i, i+patternLength).equals(pattern)){
                    System.out.println("Pattern starts at index " + i);
                }
            }
            //We dont want to go out of bounds
            if(i < text.length() - patternLength){
                textHash = updateHash(textHash,text.charAt(i),text.charAt(i+patternLength),patternLength);
            }
        }
    }
}
