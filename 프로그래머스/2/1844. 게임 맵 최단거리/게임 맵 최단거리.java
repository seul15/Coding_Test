import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static int N,M,answer;
    
    static boolean isValid(int r, int c){
        return 0<=r && r<N && 0<=c && c<M;
    }
    
    static int bfs(int r, int c,int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c,1});
        visited[r][c] = true;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int cr = current[0]; int cc = current[1]; int count = current[2];
            if(cr==N-1 && cc==M-1) return count;
            for(int i=0; i<4; i++){
                int nr= cr+dr[i]; int nc=cc+dc[i];
                if(isValid(nr,nc) && maps[nr][nc] == 1 && !visited[nr][nc]){
                    q.offer(new int[]{nr,nc,count+1});
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }
    
    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        
        return bfs(0,0,maps);
    }
}