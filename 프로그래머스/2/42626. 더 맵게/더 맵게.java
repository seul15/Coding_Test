import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer =0;
        for(int i:scoville){
            pq.offer(i);
        }
        while(true){
            if(pq.peek() >= K) return answer;
            
            int first = pq.poll();
            if(pq.isEmpty()) return -1;                
            else{
                int second = pq.poll();
                pq.offer(first + 2*second);
                answer++;
            };
        }
    }
}