/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;
import java.util.HashMap;
/**
 * Date: 03/04/2024
 *https://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
 * @author parth
 */
public class ReconstructItneray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static void itenaryUsingTickets(HashMap<String,String> trip) {
	  HashMap<String,Boolean> potentialStartingPoint = new HashMap<>();
	  
	  for(String source : trip.keySet()){
	      String destination = trip.get(source);
	      //destination can never be a 1st starting point
	      potentialStartingPoint.put(destination,false);
	      
	      //if our potentialStartingPoint doesnt contain source than it may be a starting point
	      if(!potentialStartingPoint.containsKey(source)){
	          potentialStartingPoint.put(source,true);
	      }
	  }
	  
	  
	  //Find the starting point from potentialStartingPoint hashMap we just created
	  //There will only one value that is marked true , we just have to find the value
	  String startingPoint = "";
	  for(String element : potentialStartingPoint.keySet()){
	      boolean val = potentialStartingPoint.get(element);
	      if(val){
	          startingPoint = element;
	          break;
	      }
	  }
	  
	  while(true){
	      if(potentialStartingPoint.containsKey(startingPoint)){
	          System.out.print(startingPoint + "-->");
	          startingPoint = trip.get(startingPoint);
	      }else{
	          System.out.print("END");
	          break;
	      }
	  }

    }
}
