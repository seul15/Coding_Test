import java.util.*;

class Solution {  
    int bfs(int[][] maps){
        // 상하좌우 이동을 위한 배열
        int[] dx= {0,0,1,-1};
        int[] dy= {-1,1,0,0};
        int N = maps[0].length; // 가로
        int M = maps.length; // 세로
        boolean[][] visited = new boolean[M][N];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];
            int nmove = now[2];
            
            for(int i=0; i<4; i++){
                int nextx = nx+dx[i];
                int nexty = ny+dy[i];

                // 맵을 벗어났는지 판단
                if(0>nextx || nextx>=N ||
                  0>nexty || nexty >=M) continue;
                
                // 맵을 지나갈 수 있는지 판단
                if(maps[nexty][nextx] == 0) continue;
                
                // 방문 여부 판단
                if(visited[nexty][nextx]) continue;
                
                // 도착 지점인지 판단
                if(nextx == N-1 && nexty == M-1) return nmove+1;
                
                q.offer(new int[]{nextx, nexty, nmove+1});
                visited[nexty][nextx] = true;
            }
        }
        return -1;
    }
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
}