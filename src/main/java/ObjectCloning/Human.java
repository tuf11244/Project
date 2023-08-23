/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ObjectCloning;

/**
 * Date: 08/22/2023
 * @author parth
 */
public class Human implements Cloneable{
    
    private String name;
    private int age;
    int[] arr;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.arr = new int[]{1,2,3,4,5};
    }
    
    public Object clone() throws CloneNotSupportedException{
        
        Human twin = (Human)super.clone(); //This is shallow copy
        
        //This is deep copy
        twin.arr = new int[twin.arr.length];
        for(int i = 0; i < twin.arr.length;i++){
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }

    /**
     * @param args the command line arguments
     */
   
}
