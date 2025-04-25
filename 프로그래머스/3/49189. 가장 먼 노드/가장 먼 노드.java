import java.util.*;

class Solution {
    public int bfs(int n,int[][] edge){
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edge) {
            graph.get(e[0] - 1).add(e[1] - 1);
            graph.get(e[1] - 1).add(e[0] - 1); 
        }
        
        int answer=0;
        Queue<Integer> q = new LinkedList<>();
        int[] depth= new int[n];
        Arrays.fill(depth,-1);
        
        q.add(0);
        depth[0] = 0;
        while(!q.isEmpty()){
            int current = q.remove();
            for(int e: graph.get(current)){
                if(depth[e]== -1){
                    q.add(e);
                    depth[e] = depth[current]+1;
                }
            }
        }
        
        Arrays.sort(depth);
        int max = depth[n-1];
        for(int num: depth){
            if(num == max) answer++;
        } 

        return answer;
    }
    
    public int solution(int n, int[][] edge) {
        int answer = bfs(n,edge); 
        return answer;
    }
}