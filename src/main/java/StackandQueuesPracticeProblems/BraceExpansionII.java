package StackandQueuesPracticeProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BraceExpansionII{
    public static void main(String[] args){
        System.out.println(braceExpansionII("{a,b}{c,{d,e}}"));
        

}
    public static List<String> braceExpansionII(String input){
        Set<String> result = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        
        queue.offer(input);
        while(!queue.isEmpty()){
            String current = queue.poll();
            if(current.indexOf("{") == -1){
                result.add(current);
                continue;
            }
            int left = current.indexOf("{");
            int index = left;
            while(index < current.length() && current.charAt(index) != '}'){
                if(current.charAt(index) == '{'){
                    left = index;
                }
                index = index + 1;
            }
            int right = index;
            
            String processed = current.substring(0,left);
            String[] processing = current.substring(left+1,right).split(",");
            String unprocessed = current.substring(right+1);
           
            for(String part : processing){
               StringBuilder sb = new StringBuilder(processed); 
               sb.append(part).append(unprocessed);
               queue.offer(sb.toString());
            }
                    
        }
        List<String> resultList = new ArrayList<>(result);
        Collections.sort(resultList);
        
        return resultList;
        
    }
    
}
