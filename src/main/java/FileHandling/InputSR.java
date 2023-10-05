/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package FileHandling;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *Date:10/04/2023
 * @author parth
 */
public class InputSR {

    
    public static void main(String args[]) {
       try(InputStreamReader isr = new InputStreamReader(System.in)){
           System.out.println("Enter some letters :");
           int letters = isr.read();
           while(isr.ready()){
               System.out.println((char)letters);
               letters = isr.read();
           }
           isr.close();
           System.out.println("");
       }catch(IOException e){
           System.out.println(e.getMessage());
       }
    }
}
