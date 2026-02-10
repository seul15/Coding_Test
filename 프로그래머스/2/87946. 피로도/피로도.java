class Solution {
    int count;
    boolean[] visited;
    int answer;
    
    void dfs(int hp, int[][] dungeons){
        answer = Math.max(count,answer);
        
        for(int idx=0; idx<visited.length; idx++){
            if(visited[idx] == false){
                int minHp = dungeons[idx][0];
                int useHp = dungeons[idx][1];
                if(hp>= minHp){
                    visited[idx]=true;
                    count++;
                    dfs(hp-useHp,dungeons);
                    visited[idx]=false;
                    count--;
                }
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        count =0;
        answer =0;
        dfs(k,dungeons);
        return answer;
    }
}