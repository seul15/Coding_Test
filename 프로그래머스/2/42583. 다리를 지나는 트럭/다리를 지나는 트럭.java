import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> truck = new LinkedList<>();
        int time = 0;
        int index = 0;
        int current_weight = 0;
        for(int i=0; i<bridge_length; i++) truck.offer(0);
        
        while(index<truck_weights.length || current_weight>0){
            time++;
            
            int cur = truck.poll();
            current_weight -= cur;
    
            if(index<truck_weights.length){
                int next = truck_weights[index];
                if(current_weight+ next<=weight){
                    truck.offer(next);
                    index++;
                    current_weight+=next;
                }  
                else truck.offer(0);
            }
            else truck.offer(0);
        }
        
        return time;
    }
}