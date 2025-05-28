import java.util.*;
import java.io.*;
public class Main {
    static boolean[][][] visited;
    static int N,M;
    static char[][] map;
    static int[] dr  = {-1, 1, 0, 0};
    static int[] dc  = {0, 0, -1, 1};

    static boolean isValid(int r, int c){
        return 0<=r && r<N && 0<=c && c<M;
    }

    static int bfs(int r,int c){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c,0,1});
        visited[r][c][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == N-1 && cur[1] == M-1) return cur[3];
            for(int i=0; i<4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                int wall = cur[2];
                int count = cur[3];
                if(isValid(nr,nc) && map[nr][nc]=='1'){
                    if(wall == 0){
                        q.offer(new int[]{nr,nc,wall+1,count+1});
                        visited[nr][nc][wall+1] = true;
                    }
                }
                else if(isValid(nr,nc) && map[nr][nc]=='0' && !visited[nr][nc][wall]){
                    q.offer(new int[]{nr,nc,wall,count+1});
                    visited[nr][nc][wall] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M][2];
        map = new char[N][M];

        for(int i=0; i<N; i++){
            String temp = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = temp.charAt(j);
            }
        }

        System.out.println(bfs(0,0));
    }
}
