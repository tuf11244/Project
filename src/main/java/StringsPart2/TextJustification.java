package StringsPart2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.*;
/**
 *Date: 11/29/2024
 *https://leetcode.com/problems/text-justification/
 * @author parth
 */
public class TextJustification {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public List<String> fullJustify(String[] words, int maxWidth) {
     List<String> answer = new ArrayList<>();
        
        int i = 0;
        
        while(i < words.length){
        
            int currentWidth = words[i].length();
            int j = i+1;
            int emptySlots = 0;
            while(j < words.length && currentWidth + emptySlots +  words[j].length() + 1 <= maxWidth){ //+1 for the space character
                currentWidth = currentWidth + words[j].length();
                j++;
                emptySlots++;
            }
            
            int spacesNeeded = maxWidth - currentWidth;
            
            int availaibleSpacesPerSlot = emptySlots == 0 ? 0 : spacesNeeded/emptySlots;
            int extraSpaces = emptySlots == 0 ? 0 : spacesNeeded % emptySlots;
            
            if(j == words.length){
                availaibleSpacesPerSlot = 1;
                extraSpaces = 0;
            }
            
            StringBuilder sb = new StringBuilder();
            
            for(int k = i; k < j;k++){
                sb.append(words[k]);
                if(k == j -1){
                    break;
                }
                for(int e = 0; e < availaibleSpacesPerSlot;e++){
                    sb.append(" ");
                    
                    if(extraSpaces > 0){
                        sb.append(" ");
                        extraSpaces--;
                    }
                }
            }
            
            while(sb.length() < maxWidth){
                sb.append(" ");
            }
            answer.add(sb.toString());
            i = j; //new line created
            
        }
       
        return answer;
    }
}
