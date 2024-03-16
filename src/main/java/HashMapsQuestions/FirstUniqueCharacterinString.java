/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 *
 * @author parth
 */
public class FirstUniqueCharacterinString {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(firstUniqChar("loveleetcode"));;
    }
    public  static int firstUniqChar(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
            }else{
                hm.put(ch,1);
            }
        }
        System.out.println(hm);

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < s.length();i++){
            if(hm.get(s.charAt(i)) == 1){
                answer = Math.min(i, answer);
                
            }
        }
        return answer == Integer.MAX_VALUE ? - 1 : answer;
    }
}
