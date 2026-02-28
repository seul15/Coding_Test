import java.util.*;

class Solution {
    int bfs(int characterX, int characterY, int itemX, int itemY,int[][] maps){
        Queue<int[]> q = new LinkedList<>(); // x좌표, y좌표, 움직인 횟수
        boolean[][] visited = new boolean[101][101];
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        q.offer(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];
            int move = now[2];
            
            for(int i=0; i<4; i++){
                int nextx = nx + dx[i];
                int nexty = ny +dy[i];
                if(nextx < 0 || nextx >= 101||
                  nexty < 0 || nexty >= 101) continue;
                if(maps[nextx][nexty] == 1 && !visited[nextx][nexty]){
                    visited[nextx][nexty] = true;
                    if(nextx == itemX && nexty == itemY) return (move+1)/2;
                    q.offer(new int[]{nextx, nexty, move+1});
                }
            }
        }
        return -1;
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] maps = new int[101][101];
        
        // 직사각형 영역 모두 칠하기
        for(int[] r : rectangle){
            int x1= r[0]*2;
            int y1 = r[1]*2;
            int x2 = r[2]*2;
            int y2 = r[3]*2;
            for(int x=x1; x<=x2; x++){
                for(int y=y1; y<=y2; y++){
                    maps[x][y] = 1;
                }
            }
        }
        
        // 직사각형 내부 지우기
        for(int[] r : rectangle){
            int x1= r[0]*2;
            int y1 = r[1]*2;
            int x2 = r[2]*2;
            int y2 = r[3]*2;
            for(int x=x1+1; x<=x2-1; x++){
                for(int y=y1+1; y<=y2-1; y++){
                    maps[x][y] = 0;
                }
            }
        }
        
        return bfs(characterX*2, characterY*2 , itemX*2, itemY*2, maps);
    }
}