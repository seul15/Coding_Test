import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int answer;
    
    static void dfs(int node, int sheep, int wolf, List<Integer> next, int[] info){
        if(info[node] == 0) sheep++;
        else wolf++;
        
        if(wolf>=sheep) return;
        answer = Math.max(answer,sheep);
        
        List<Integer> copy = new ArrayList<>(next);
        copy.remove(Integer.valueOf(node));
        copy.addAll(graph[node]);
        
        for(int c: copy){
            dfs(c,sheep,wolf,copy,info);
        }
    }
    public int solution(int[] info, int[][] edges) {
        graph = new ArrayList[info.length];
        for(int i=0; i<info.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
        }
        answer = 0;
        
        List<Integer> next= new ArrayList<>();
        next.add(0);
        dfs(0,0,0,next,info);
        
        return answer;
    }
}