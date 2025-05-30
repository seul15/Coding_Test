import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Integer>[] graph;
    
    static int bfs(int n){
        int count=1;
        Arrays.fill(visited, false);
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = true; 
        while(!q.isEmpty()){
            int current = q.poll();
            for(int w: graph[current]){
                if(!visited[w]){
                    count++;
                    visited[w] = true;
                    q.offer(w);
                }
            }
        }
        return count;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        visited = new boolean[n];
        graph = new ArrayList[n];
        for(int i=0; i<n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] wire : wires){
            graph[wire[0]-1].add(wire[1]-1);
            graph[wire[1]-1].add(wire[0]-1);
        }
        
        for(int[] wire : wires){
            graph[wire[0]-1].remove(Integer.valueOf(wire[1]-1));
            graph[wire[1]-1].remove(Integer.valueOf(wire[0]-1));
            
            int count = bfs(wire[0]);
            answer = Math.min(answer, Math.abs(n-2*count));
            
            graph[wire[0]-1].add(wire[1]-1);
            graph[wire[1]-1].add(wire[0]-1);
        }
        return answer;
    }
}