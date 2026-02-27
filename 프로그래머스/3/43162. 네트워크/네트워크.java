import java.util.*;

class Solution {
    int bfs(int n, int[][] computers){
        int answer =0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            
            // 새로운 네트워크 발견
            q.offer(i);
            visited[i] = true;
            answer++; 
            while(!q.isEmpty()){
                int now = q.poll();
                for(int next=0; next<n; next++){
                    if(computers[now][next] == 1){
                        if(visited[next]) continue;
                    
                        q.offer(next);
                        visited[next] = true;   
                    }
                }
            }
        }
        return answer;
    }
    
    public int solution(int n, int[][] computers) {
        
        return bfs(n,computers);
    }
}