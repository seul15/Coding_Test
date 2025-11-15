import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            q.add((int)Math.ceil((100-progresses[i])/(double)speeds[i]));
        }
        
        List<Integer> days = new ArrayList<>();
        while(!q.isEmpty()){
            int day = q.poll();
            int cnt =1;
            while(!q.isEmpty() && q.peek()<=day){
                q.poll();
                cnt++;
            }
            days.add(cnt);
        }
       
        return days.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}