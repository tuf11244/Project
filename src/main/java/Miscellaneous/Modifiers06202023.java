/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Miscellaneous;

/**
 *
 * @author parth
 */
public class Modifiers06202023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        MyEmployee myObject = new MyEmployee(); //Creating an object for classs MyEmployee
    //    myObject.id = 101;   //Throws errors has field id and name are private access modifier
    //    myObject.name = "Parth";
    myObject.setName("Parth");
    myObject.setId(45);
    myObject.getId();
    myObject.getName();
        System.out.println(myObject.getId());
        System.out.println(myObject.getName());
    }
}

class MyEmployee{
  private  int id;
  private  String name;
  
  public void setId(int n){
      id = n;
  }
  public void setName(String s){
      name = s;     
  } 
  public int getId(){
     return id; 
  } 
  public String getName(){
      return name;
  }
}
