/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package FileHandling;
import java.io.FileReader;

/**
 *Date:10/04/2023
 * @author parth
 */
public class FileReaderFR {

    
    public static void main(String args[]) {
        try(FileReader fr = new FileReader("filename.txt")){
           System.out.println("Enter some letters :");
           int letters = fr.read();
           while(fr.ready()){
               System.out.print((char)letters);
               letters = fr.read();
           }
           fr.close();
           System.out.println("");
       }catch(Exception e){
           System.out.println(e.getMessage());
       } 
    }
}
