import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1] == b[1]) return a[0]-b[0];
            return a[1]-b[1];
        });
        
        Arrays.sort(jobs, (a,b)-> a[0]-b[0]);
        
        int index =0;
        int time =0;
        int answer =0;
        while(index<jobs.length || !pq.isEmpty()){
            while(index<jobs.length && jobs[index][0]<= time){
                pq.offer(new int[]{jobs[index][0], jobs[index][1]});
                index++;
            }
            if(pq.isEmpty()){
                time = jobs[index][0];
                continue;
            }
            int[] current = pq.poll();
            time += current[1];
            answer += (time - current[0]);
        }
        return answer/jobs.length;
    }
}