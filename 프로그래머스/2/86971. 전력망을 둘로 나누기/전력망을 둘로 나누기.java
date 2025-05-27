import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;
    
    static int bfs(int index){
        int count=1;
        Arrays.fill(visited,false);
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);
        visited[index] = true;
        while(!q.isEmpty()){
            int current = q.remove();
            for(int next: graph[current]){
                if(!visited[next]){
                    q.offer(next);
                    count++;
                    visited[next] = true;
                }
            }
        }
        return count;
    } 
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList[n+1];
        for(int i=0; i<=n ; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] wire: wires){
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        visited = new boolean[n+1];
        for(int[] wire: wires){
            graph[wire[0]].remove(new Integer(wire[1]));
            graph[wire[1]].remove(new Integer(wire[0]));
            
            int c1 = bfs(wire[0]);
            int c2 = n-c1;
            answer = Math.min(answer, Math.abs(c1-c2));
            
            
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        return answer;
    }
}