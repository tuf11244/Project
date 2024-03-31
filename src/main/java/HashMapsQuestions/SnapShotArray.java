/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 *Date: 03/31/2024
 * https://leetcode.com/problems/snapshot-array/
 * @author parth
 */
public class SnapShotArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
class SnapshotArray {
    HashMap<Integer,Integer>[] hm;
    int snapID = 0;
    public SnapshotArray(int length) {
        hm = new HashMap[length];

        //Initialize our arrays of hashmaps 
        for(int i = 0; i < length;i++){
            hm[i] = new HashMap<>();
        }
    }
    
    public void set(int index, int val) {
         hm[index].put(snapID,val);
    }
    
    public int snap() {
        snapID++;
        return snapID - 1;
        
    }
    
    public int get(int index, int snap_id) {
        while(snap_id >= 0 && !hm[index].containsKey(snap_id)){
            snap_id--;
        }
        if(snap_id == -1){
            return 0;
        }
        return hm[index].get(snap_id);
    }
}

