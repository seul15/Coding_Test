import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] cost = new int[n+1][n+1];
        for(int[] fare: fares){
            cost[fare[0]][fare[1]] = fare[2];
            cost[fare[1]][fare[0]] = fare[2];
        }
        
        int[][] dist = new int[3][n+1];
        for(int[] d: dist){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        Queue<int[]> q = new PriorityQueue<>((e1,e2)->e1[1]-e2[1]);
        int[] start = {s,a,b};
        for(int i=0;i<3; i++){
            int[] d= dist[i];
            q.add(new int[]{start[i],0});
            d[start[i]] = 0;
            while(!q.isEmpty()){
                int[] cur= q.poll();
                for(int j=1; j<=n; j++){
                    if(cost[cur[0]][j] == 0) continue;
                    if(d[j]>cur[1]+cost[cur[0]][j]){
                        d[j] = cur[1]+cost[cur[0]][j];
                        q.add(new int[]{j,d[j]});
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            int sum=0;
            for(int[] d: dist){
                sum += d[i];
            }
            answer = Math.min(answer,sum);
        }
        
        return answer;
    }
}