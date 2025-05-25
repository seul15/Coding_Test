import java.util.*;

class Solution {
    static boolean[][] visited;
    static int N, M;
    static int[] dr= {1,0,0,-1};
    static int[] dc = {0,1,-1,0};
    
    public boolean isValid(int r, int c){
        return 0<=r && r<N && 0<=c && c<M;
    }
    
    public int bfs(int r, int c,int count, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c,count});
        visited[r][c]= true;
        
        while(!q.isEmpty()){
            int[] current = q.remove();
            for(int i=0; i<4; i++){
                int nr = current[0]+dr[i];
                int nc = current[1]+dc[i];
                if(isValid(nr,nc) && !visited[nr][nc] && maps[nr][nc] == 1){
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr,nc,current[2]+1});
                    if(nr==N-1 && nc == M-1) return current[2]+1;
                }
            }
        }
        return -1;
    }
        
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];

        return bfs(0,0,1,maps);
    }
}