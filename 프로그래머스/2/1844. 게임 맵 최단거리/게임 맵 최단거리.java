import java.util.*;

class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    
    int bfs(int w,int h, boolean[][] visited, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == w-1 && now[1] == h-1) return now[2];
            visited[now[1]][now[0]] = true;
            for(int i=0; i<4; i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                
                if(nx>=0 && nx<w && ny>=0 && ny<h){
                    if(maps[ny][nx]== 1 && !visited[ny][nx]){
                        q.offer(new int[]{nx,ny,now[2]+1});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return -1;
    }
    
    public int solution(int[][] maps) {
        int w = maps[0].length;
        int h = maps.length;
        boolean[][] visited = new boolean[h][w];
        return bfs(w,h,visited,maps);
    }
}