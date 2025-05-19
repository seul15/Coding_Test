import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int answer;
    
    static void dfs(int sheep, int wolf, List<Integer> next,int[] info){
        if(sheep<=wolf) return;
        answer = Math.max(answer,sheep);
        
        for(int current: next){
            List<Integer> copy = new ArrayList<>(next);
            copy.remove(Integer.valueOf(current));
            if(graph[current] != null){
                for(int child: graph[current]){
                    copy.add(child);
                }
            }
            if(info[current] == 0){
                dfs(sheep+1,wolf,copy,info);
            }
            else{
                dfs(sheep,wolf+1,copy,info);
            }
        }
    }
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        graph = new ArrayList[info.length];
        for(int i=0; i<info.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
        }
        dfs(1,0,graph[0],info);
        
        return answer;
    }
}