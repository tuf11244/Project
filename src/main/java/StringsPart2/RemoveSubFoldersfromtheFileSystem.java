package StringsPart2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.*;
/**
 *Date: 10/24/2024
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem
 * @author parth
 */
public class RemoveSubFoldersfromtheFileSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        // TODO code application logic here
        String s = "/a/b/c";
        String[] arr= s.split("/");
        
        System.out.println(Arrays.toString(arr));
    }
    
    public static List<String> removeSubFolders(String [] folder){
        
        Arrays.sort(folder);
        
        HashSet<String> set = new HashSet<>();
        
        for(String s : folder){
            String[] arr = s.split("/");
            
            if(arr.length == 2){ //that means its a parent folder
                set.add(s);
            }else{
                int i = 1;
                String folderName = "";
                while(i < arr.length){
                    folderName = folderName + "/" + arr[i];
                    
                    if(set.contains(folderName)){
                        break;
                    }
                    i++;
                }
                if(i == arr.length){
                    set.add(s);
                }
               
                
                
            }
            
        }
        
         List<String> answer = new ArrayList<>(set);
        
        return answer;
       
    }
}
