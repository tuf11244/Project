/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;

/**
 *
 * @author parth
 */
class CopyConstructor{
    int a; String b;
    
    CopyConstructor(int x, String name){
        a = x;
        b = name;
        System.out.println(a);
        System.out.println(b);
    }
    
    CopyConstructor(CopyConstructor ref){ //CoppyConstructor taking object reference as a parameter
        a = ref.a;
        b = ref.b;
        System.out.println(a);
        System.out.println(b);
        
    }
    
}
public class CopyConstructor06202023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        CopyConstructor myObj = new CopyConstructor(100,"Jigar");
        CopyConstructor myObject = new CopyConstructor(myObj);
        System.out.println(myObject.a);
       
        // TODO code application logic here
    }
}
