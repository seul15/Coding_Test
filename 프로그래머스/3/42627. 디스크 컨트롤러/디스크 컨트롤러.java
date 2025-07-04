import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);
        Queue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int cur=0,total=0,index=0,n=jobs.length;
        while(!q.isEmpty() || index<n){
            while(index<n && cur>= jobs[index][0]) q.add(jobs[index++]);
            if(!q.isEmpty()){
                int[] job = q.poll();
                cur += job[1];
                total += cur-job[0];
            } else{
                cur = jobs[index][0];
            }
        }
        return total/n;
    }
}