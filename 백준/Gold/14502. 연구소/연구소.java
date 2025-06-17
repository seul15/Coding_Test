import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static List<int[]> space;
    static List<int[]> virus;
    static boolean[][] visited;

    static int answer = -1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean isValid(int r, int c){
        return 0<= r && r<N && 0<=c && c<M;
    }

    static int bfs(int[][] tempmap){
        visited = new boolean[N][M];
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<virus.size(); i++){
            q.add(new int[]{virus.get(i)[0],virus.get(i)[1]});
            visited[virus.get(i)[0]][virus.get(i)[1]] = true;
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i< 4; i++){
                int nr = cur[0] + dx[i];
                int nc = cur[1] + dy[i];
                if(isValid(nr,nc) && !visited[nr][nc] && tempmap[nr][nc] == 0){
                    q.add(new int[]{nr,nc});
                    tempmap[nr][nc] = 2;
                    visited[nr][nc] = true;
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tempmap[i][j] == 0) count++;
            }
        }
        return count;
    }

    static void backtracking(int start, int count){
        if(count == 3){
            int[][] tempmap = new int[N][M];
            for(int i = 0; i < N; i++) {
                tempmap[i] = map[i].clone(); // 깊은 복사
            }
            answer = Math.max(answer, bfs(tempmap));
            return;
        }

        for(int i = start; i < space.size(); i++){
            int r = space.get(i)[0];
            int c = space.get(i)[1];
            map[r][c] = 1;  // 벽 세우기
            backtracking(i + 1, count + 1);
            map[r][c] = 0;  // 복구
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        space = new ArrayList<int[]>();
        virus = new ArrayList<int[]>();
        answer = -1;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virus.add(new int[]{i,j});
                else if(map[i][j] == 0) space.add(new int[]{i,j});
            }
        }

        backtracking(0,0);
        System.out.println(answer);
    }
}
