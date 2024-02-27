/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMaps;

/**
 *
 * @author parth
 */
public class HashMapsImplementation {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MapsUsingHash hashmap = new MapsUsingHash();
        hashmap.put("Mango", "Yellow Fruit");
        hashmap.put("Kiwi", "From New Zealand");
        hashmap.put("Apple", "An apple a day keeps doctor away");
        
        System.out.println(hashmap.get("Apple"));
    }
}


class MapsUsingHash{
    
    private Entity[] entities;
    public MapsUsingHash(){
        entities = new Entity[100];
    }
    
    public void put(String key, String value){
        int hash = Math.abs(key.hashCode() % entities.length);
        entities[hash] = new Entity(key,value);   //overiding
    }
    public String get(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash]!=null && entities[hash].key.equals(key)){
            return entities[hash].value;
        }
        return null;
    }
    public void remove(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash]!=null && entities[hash].key.equals(key)){
            entities[hash] = null;
        }
    }
    
    
    private class Entity{
        String key;
        String value;
        
        public Entity(String key, String value){
            this.key = key;
            this.value = value;
        }
        
    }
}
