/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMaps;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author parth
 */
public class GenericHashMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}

class HashMapUsingLL <K,V>{
    ArrayList<LinkedList<Entity>> list;
    
    private int size = 0;
    private float loadFactor = (float) 0.5;
    
    //Constructor
    public HashMapUsingLL(){
        list = new ArrayList<>();
        
        //Create an empty ArrayList of size 10 containing empty LinkedList
        for(int i = 0; i < 10;i++){
            list.add(new LinkedList<>());
        }
    }
    
    public void put(K key, V value){
        int hash = Math.abs(key.hashCode() % list.size());
        
        //Since list is an ArrayList containing LinkedList 
        //We have to get the linkedList located at the index hash 
        LinkedList<Entity> entities = list.get(hash);
        
        for(Entity entity : entities){
            if(entity.key.equals(key)){
                entity.value = value;
                return;
            }
        }
        if((float)size % list.size() > loadFactor){
            reHash();
        }
        
        entities.add(new Entity(key,value));
        
    }
   /**
     * Rehashes the HashMap when the load factor is exceeded.
     * It doubles the capacity of the HashMap and redistributes
     * existing key-value pairs into the new structure.
     */
    private void reHash() {
        System.out.println("HashMap is now full and needs to be rehashed.");

        // Store the values from the current list to a temporary ArrayList named old
        ArrayList<LinkedList<Entity>> old = list;

        // Create a new ArrayList with a capacity of twice the previous list size
        list = new ArrayList<>(old.size() * 2);

        // Initialize the new ArrayList with empty LinkedLists
        for (int i = 0; i < list.size(); i++) {
            list.add(new LinkedList<>());
        }

        // Iterate through each LinkedList in the old list
        for (LinkedList<Entity> entries : old) {
            // Iterate through each key-value pair in the LinkedList
            for (Entity entry : entries) {
                // Add the key-value pair to the newly created HashMap
                put(entry.key, entry.value);
            }
        }
    }
    
    public V get(K key){
         int hash = Math.abs(key.hashCode() % list.size());
         LinkedList<Entity> entities = list.get(hash);
         
         for(Entity entity : entities){
             if(entity.key.equals(key)){
                 return entity.value;
             }
         }
         return null;
    }
    
    public void remove(K key){
        int hash = Math.abs(key.hashCode() % list.size());
         LinkedList<Entity> entities = list.get(hash);
         
         Entity target = null;
         
          for(Entity entity : entities){
             if(entity.key.equals(key)){
                 target = entity;
                 break;
             }
         }
         entities.remove(target);
         size--;
    }
    
    public boolean containsKey(K key){
        return get(key) != null;
    }

    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       builder.append("{");
       for(LinkedList<Entity> entities : list){
           for(Entity entity : entities){
               builder.append(entity.key);
               builder.append(" = ");
               builder.append(entity.value);
               builder.append(" , ");
           }
       }
       builder.append("}");
       
       return builder.toString();
    }
    
    
    private class Entity{
        K key;
        V value;
        
        public Entity(K Key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
