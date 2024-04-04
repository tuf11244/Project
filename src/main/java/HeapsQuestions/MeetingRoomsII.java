/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Date: 04/03/2024
 *https://leetcode.com/problems/meeting-rooms-ii/
 * @author parth
 */
public class MeetingRoomsII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       int[][] intervals = {
           {1,3},
           {8,10},
           {7,8},
           {9,15},
           {2,6},
           {9,16}
       };
        System.out.println(meetingRooms(intervals));
    }
    
    public static int meetingRooms(int[][] intervals){
        //Sort the array based on starting times 
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0], b[0]));
        
        //Intialize a priorityQueue (min Heap) which would store the end times of the interval 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int[] interval : intervals){
            //Below statement means our pq is empty, so we have add the first end time in our pq
            if(pq.size() == 0){
                pq.add(interval[1]);
            }
            else{
                //Meaning the ongoing meeting end time is greater than the other meeting start time 
                //so we have to allot a new roow 
                if(pq.peek() > interval[0]){
                    pq.add(interval[1]); //new roow created 
                }else{
                    //Meaning the ongoing meeting has ended so no need to create a new room 
                    //but we have to add our current meeting end time to the pq
                    pq.poll();
                    pq.add(interval[1]);
                }
                
            }
        }
        return pq.size(); //pq.size() represents the minimum rooms required
    }
}
