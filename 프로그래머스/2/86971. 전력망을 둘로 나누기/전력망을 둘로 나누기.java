import java.util.*;

class Solution {
    int bfs(ArrayList<Integer>[] graph,boolean[] visited, int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] =true;
        int cnt =1;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int num: graph[now]){
                if(visited[num]) continue;
                q.offer(num);
                cnt++;
                visited[num] = true;
            }
        }
        return Math.abs(cnt-(n-cnt));
    }
    
    public int solution(int n, int[][] wires) {
        int answer =Integer.MAX_VALUE;
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] w: wires){
            int a = w[0];
            int b = w[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for(int[] w: wires){
            // 간선 제거
            int a = w[0];
            int b = w[1];
            
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            
            answer = Math.min(answer, bfs(graph, new boolean[n+1], n));
            
            // 다시 간선 추가
            graph[a].add(b);
            graph[b].add(a);
        }
        
        return answer;
    }
}