import java.util.*;

class Solution {
    boolean[] visited;
    int answer;
    
    void dfs(int hp, int count, int[][] dungeons){
        answer = Math.max(answer, count);
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && hp>=dungeons[i][0]){
                visited[i] = true;
                count++;
                dfs(hp-dungeons[i][1],count,dungeons);
                count--;
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        dfs(k,0,dungeons);
        return answer;
    }
}