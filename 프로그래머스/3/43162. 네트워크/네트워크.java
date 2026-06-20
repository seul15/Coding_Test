import java.util.*;

class Solution {
    int answer =0;

    void bfs(int com, boolean[] visited, int[][] computers, int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(com);
        answer++;
        
        while(!q.isEmpty()){
            int now = q.poll();
            visited[now] = true;
            for(int i=0; i<n; i++){
                if(!visited[i] && now!=i && computers[now][i]==1){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]) bfs(i,visited,computers, n);
        }
        return answer;
    }
}