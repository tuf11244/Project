/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package FileHandling;

import java.io.File;

/**
 *
 * @author parth
 */
public class CreateaFile {

    public static void main(String args[]) {
        try{
            File myobject = new File("filename.txt");
            if(myobject.createNewFile()){
                System.out.println("File Created :" + myobject.getName());
                
            } else{
                System.out.println("File already exits ");
                System.out.println(myobject.getAbsolutePath());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            
        }
        
    }
}
