import java.util.*;
import java.io.*;
public class Main {
    static boolean[][][][] visited;
    static boolean[][] map;
    static int N,M;
    static int[] red;
    static int[] blue;
    static int[] goal;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static public int[] move(int r, int c, int dr,int dc){
        while (!map[r + dr][c + dc]) {
            r += dr;
            c += dc;
            if (r == goal[0] && c == goal[1]) break;
        }
        return new int[]{r,c};
    }
    static public boolean bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{red[0],red[1],blue[0],blue[1],0});
        visited[red[0]][red[1]][blue[0]][blue[1]] = true;
        while(!q.isEmpty()){
            int[] c = q.poll();
            int[] r = new int[]{c[0],c[1]};
            int[] b = new int[]{c[2],c[3]};
            int depth = c[4];
            if(depth >= 10) return false;
            for(int i=0; i<4; i++){
                int[] nextr = move(r[0],r[1],dr[i],dc[i]);
                int[] nextb = move(b[0],b[1],dr[i],dc[i]);

                if(nextb[0] == goal[0] && nextb[1] == goal[1]) continue;
                if(nextr[0] == goal[0] && nextr[1] == goal[1]) return true;

                if(nextr[0] == nextb[0] && nextr[1] == nextb[1]){
                    if(i==0){
                        if(r[0]>b[0]) nextr[0]++;
                        else nextb[0]++;
                    }
                    else if(i==1){
                        if(r[0]>b[0]) nextb[0]--;
                        else nextr[0]--;
                    }
                    else if(i==2){
                        if(r[1]>b[1]) nextr[1]++;
                        else nextb[1]++;
                    }
                    else if(i==3){
                        if(r[1]>b[1]) nextb[1]--;
                        else nextr[1]--;
                    }
                }
                if(!visited[nextr[0]][nextr[1]][nextb[0]][nextb[1]]) {
                    q.offer(new int[]{nextr[0], nextr[1], nextb[0], nextb[1], depth+1});
                    visited[nextr[0]][nextr[1]][nextb[0]][nextb[1]] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M][N][M];
        map = new boolean[N][M];
        red = new int[2];
        blue = new int[2];
        goal = new int[2];

        for(int i=0; i<N; i++){
            String temp = br.readLine();
            for(int j=0; j<M; j++){
                if(temp.charAt(j)=='#') map[i][j] = true;
                else if(temp.charAt(j)=='R'){
                    red[0] = i;
                    red[1] = j;
                }
                else if(temp.charAt(j)=='B'){
                    blue[0] = i;
                    blue[1] = j ;
                }
                else if(temp.charAt(j)=='O'){
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }

        if(bfs()) System.out.println(1);
        else System.out.println(0);
    }
}
