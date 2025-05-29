import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;
    
    static int bfs(int i){
        Queue<Integer> q= new LinkedList<>();
        Arrays.fill(visited, false);
        q.offer(i);
        visited [i] = true;
        int count =1;
        
        while(!q.isEmpty()){
            int current = q.poll();
            for(int next: graph[current]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next] =true;
                    count++;
                }
            }
        }
        return count;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] wire: wires){
            int w1 = wire[0]-1, w2=wire[1]-1;
            graph[w1].add(w2);
            graph[w2].add(w1);
        }
        
        for(int[] wire: wires){
            int w1 = wire[0]-1, w2=wire[1]-1;
            graph[w1].remove(Integer.valueOf(w2));
            graph[w2].remove(Integer.valueOf(w1));
            
            int net = bfs(w1);
            System.out.println(net);
            answer = Math.min(answer, Math.abs(n- 2*net));
            
            graph[w1].add(w2);
            graph[w2].add(w1);
        }
        return answer;
    }
}