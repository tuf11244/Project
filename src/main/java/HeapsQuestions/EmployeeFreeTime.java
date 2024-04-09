/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *DateL 04/04/2024
 *https://leetcode.com/problems/employee-free-time/
 * @author parth
 */
public class EmployeeFreeTime {

    /**
     * It was 12:25 AM on 04/05/2024
     * Started working on this problem at 10: 30
     * Still can't believe I did it by myself 
     * and it is classified as leetcode hard :)
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] schedule = {
            {1,3}, 
            {8,10}, 
            {15,20},
        };
        
        List<List<Integer>> answer = employeeFreeTime(schedule);
        
        for(List<Integer> x : answer){
            System.out.println(x);
        }
          
    }
    
    public static List<List<Integer>> employeeFreeTime(int[][] schedule){
        List<List<Integer>> answer = new ArrayList<>();
        PriorityQueue<Schedule> pq = new PriorityQueue<>();   //Min heap 
        //Sort the min heap based on the start time 
        //if the start time is equal sort it by the difference 
        if(schedule.length == 1){
            return answer;
        }
        //Fill up our priority Queue 
        for(int i = 0; i < schedule.length;i++){
            int startTime = schedule[i][0];
            int endTime = schedule[i][1];
            pq.add(new Schedule(startTime,endTime));
        }
        System.out.println(pq);
        int newCurrentEndTime = 0;
        while(!pq.isEmpty()){
            Schedule current = pq.poll();
            int endT = (newCurrentEndTime == 0) ? current.endTime : newCurrentEndTime;
            if(!pq.isEmpty() && endT < pq.peek().startTime){
                List<Integer> temp = new ArrayList<>();
                temp.add(endT);
                temp.add(pq.peek().startTime);
                answer.add(temp);
                
                newCurrentEndTime = pq.peek().endTime;
            }
            else{
                if(!pq.isEmpty() && endT < pq.peek().endTime){
                    newCurrentEndTime = pq.peek().endTime;
                }else{
                    newCurrentEndTime = current.endTime;
                }
                //We can also write the above loop as Math.max(current.endTime, pq.peek().endTime)
            }           
        }

        return answer;
        
    }
}

class Schedule implements Comparable<Schedule>{
    int startTime;
    int endTime;
    int difference;
    
    public Schedule(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
        this.difference = this.endTime - this.startTime;
    }

    @Override
    public String toString() {
        return "Schedule{" + "startTime=" + startTime + ", endTime=" + endTime + ", difference=" + difference + '}';
    }
    
    @Override
    public int compareTo(Schedule o) {
        if(this.startTime != o.startTime){
            return this.startTime - o.startTime;
        }
        return this.difference - o.difference; //when the startTime are equal
    }
            
}
