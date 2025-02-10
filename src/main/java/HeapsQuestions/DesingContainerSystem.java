/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;
import java.util.*;
/**
 *Date: 02/07/2025
 *https://leetcode.com/problems/design-a-number-container-system/
 * @author parth
 */
public class DesingContainerSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
}
class NumberContainers {
    HashMap<Integer,Integer> indexToNumber; //index vs number map
    HashMap<Integer,PriorityQueue<Integer>> numberToIndex; //number vs List of Indexes
    public NumberContainers() {
         indexToNumber = new HashMap<>();
         numberToIndex = new HashMap<>();
    }
    
    public void change(int index, int number) {
        //First check if the index already exists our indexToNumber map
        int oldNumber = -1;
        if(indexToNumber.containsKey(index)){
                oldNumber = indexToNumber.get(index);
                if(oldNumber == number){
                    return;
                }

            numberToIndex.get(oldNumber).remove(index);
        }

        indexToNumber.put(index,number);

        if(numberToIndex.containsKey(number)){
            PriorityQueue<Integer> pq = numberToIndex.get(number);
            pq.add(index);
            numberToIndex.put(number,pq);
        }else{
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(index);
            numberToIndex.put(number,pq);
        }

        


        
        
        //System.out.println(indexToNumber);
       
    }
    
    public int find(int number) {
        
        PriorityQueue<Integer> pq = numberToIndex.getOrDefault(number,new PriorityQueue<>());

        if(pq.size() == 0){
            return -1;
        }

        return pq.peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
