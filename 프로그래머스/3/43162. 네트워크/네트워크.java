import java.util.*;

class Solution {
    public int bfs(int[][] computers){
        int answer=0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[computers.length];
        for(int index=0; index<computers.length; index++){
            if(!visited[index]){
                answer++;
                q.add(index);
                visited[index] = true;
                while(!q.isEmpty()){
                    int current = q.remove();
                    for(int i=0; i<computers.length; i++){
                        if(computers[current][i] == 1 && !visited[i]){
                            q.add(i);
                            visited[i] = true;
                        }
                    }
                }
            }
        }
        return answer;
    }
    
    public int solution(int n, int[][] computers) {
        int answer = bfs(computers);
        return answer;
    }
}