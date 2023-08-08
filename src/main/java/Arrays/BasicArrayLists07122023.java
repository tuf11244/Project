/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Arrays;
import java.util.*;
/**
 *
 * @author parth
 */
public class BasicArrayLists07122023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ArrayList<String> cars = new ArrayList<String>();
        ArrayList<String> cars2 = new ArrayList<String>();//Creates cars ArrayList
        cars.add("BMW"); //Adds new element is cars 
        cars.add("Tesla");
        cars.add("Mercedez");
        cars.add("Porsche");
        cars.add("Tata");
        cars.add("Hyundai");
        cars2.add("Lamborghini");
        cars2.add("Ferrari");
        cars2.add("Ford");
        cars2.add("Volvo");
        cars2.add("Bugatti");
        cars2.add(null);
        cars2.add(null);
       /* for(String element : cars){             //Prints out ArrayList elements
            System.out.println(element);
        }
        */
        
        Collections.sort(cars); 
        //Sorts out the ArrayList
        System.out.println(" ----------- ");
        for(String element : cars){
            System.out.print(element);
            System.out.print(",");
        }
        System.out.println("----------");
        
        cars.addAll(cars2);  //Appends cars2 ArrayList on cars
        for(String element : cars){
            System.out.print(element);
            System.out.print(",");
        }
       // cars.clear(); //clears out the ArrayList
        System.out.println(cars.size());  //gets the size of the ArrayList 
        System.out.println(cars.get(0));   //gets the element of the ArrayList at index 0 
        
      //  cars.clone(); //returns a shallow copy of cars ArrayList
        System.out.println(cars.clone());
        
        System.out.println(cars.contains("Mazerati"));
       // cars.contains("Mazerati"); //Contains method returns true or false based on if the ArrayList contains the item 
        // TODO code application logic here
        System.out.println(cars.indexOf("Bugatti")); //indexof method returns the index in ArrayList
        cars2.trimToSize();
        cars2.remove("Bugatti");
        System.out.print(cars2);
    }
}
