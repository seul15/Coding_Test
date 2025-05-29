import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Integer>[] graph;
    static int answer;
    
    static void dfs(int node,int sheep, int wolf, List<Integer> next,int[] info){
        visited[node] = true;
        if(info[node] == 0) sheep++;
        else wolf++;
        
        if(wolf>=sheep){
            visited[node] = false;
            return;
        }
        answer = Math.max(answer,sheep);
        
        List<Integer> copy = new ArrayList<>(next);
        copy.remove(Integer.valueOf(node));
        
        for(int n: graph[node]){
            copy.add(n);
        } 

        for(int n: copy){
            if(!visited[n]){
                dfs(n,sheep,wolf,copy,info);
                visited[n] = false;
            }
        }
        visited[node] = false;
    }
    
    public int solution(int[] info, int[][] edges) {
        int len = info.length;
        answer =0;
        visited = new boolean[len];
        graph = new ArrayList[len];
        for(int i=0; i<len; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
        }
        List<Integer> next = new ArrayList<>();
        next.add(0);
        dfs(0,0,0,next, info);
        return answer;
    }
}