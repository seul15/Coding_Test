import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Waiting{
    int index;
    int sr;
    int sc;
    int er;
    int ec;
    int distance;

    public Waiting(int index, int sr, int sc, int er, int ec, int distance) {
        this.index = index;
        this.sr = sr;
        this.sc = sc;
        this.er = er;
        this.ec = ec;
        this.distance = distance;
    }
}

class WaitingComparator implements Comparator<Waiting> {
    @Override
    public int compare(Waiting a, Waiting b) {
        if(a.distance  == b.distance){
            if(a.sr == b.sr){
                return a.sc - b.sc;
            }
            else{
                return a.sr - b.sr;
            }
        }
        else{
            return a.distance - b.distance;
        }
    }
}

public class Main{
    static int N;
    static int M;
    static int gas;
    static int[][] map;
    static int sr;
    static int sc;
    static int[][] passenger;
    static int[][] distance;
    static boolean[] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static public boolean isValid(int r, int c){
        return 0<=r && r<N && 0<=c && c<N;
    }

    static public void bfsToGoal(int sr,int sc,int er,int ec){
        for(int[] row : distance){
            Arrays.fill(row, -1);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        distance[sr][sc] = 0;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int cr = current[0];
            int cc = current[1];
            for(int i=0; i<4; i++){
                int nr = cr+dr[i];
                int nc = cc+dc[i];
                if(isValid(nr,nc) && map[nr][nc] == 0 && distance[nr][nc] == -1){
                    q.add(new int[]{nr,nc});
                    distance[nr][nc] = distance[cr][cc] + 1;
                }
            }
        }
    }

    static public int[] bfsToPassenger(int r , int c){
        for(int[] row : distance){
            Arrays.fill(row, -1);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        distance[r][c] = 0;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int cr = current[0];
            int cc = current[1];
            for(int i=0; i<4; i++){
                int nr = cr+dr[i];
                int nc = cc+dc[i];
                if(isValid(nr,nc) && map[nr][nc] == 0 && distance[nr][nc] == -1){
                    q.add(new int[]{nr,nc});
                    distance[nr][nc] = distance[cr][cc] + 1;
                }
            }
        }

        PriorityQueue<Waiting> pq = new PriorityQueue<Waiting>(new WaitingComparator());
        for(int i=0;i<M;i++){
            if(!visited[i] && distance[passenger[i][0]][passenger[i][1]] != -1){
                pq.offer(new Waiting(i,passenger[i][0],passenger[i][1],
                        passenger[i][2],passenger[i][3],distance[passenger[i][0]][passenger[i][1]]));
            }
        }
        if(!pq.isEmpty()){
            Waiting np = pq.poll();
            int[] p = new int[]{np.index, np.distance};
            visited[np.index] = true;
            return p;
        } else{
            return null;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        gas = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        sr = Integer.parseInt(st.nextToken())-1;
        sc = Integer.parseInt(st.nextToken())-1;

        passenger = new int[M][4];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<4; j++){
                passenger[i][j] = Integer.parseInt(st.nextToken())-1;
            }
        }

        distance = new int[N][N];
        visited = new boolean[M];

        for(int i=0; i<M; i++){
            int[] goal = bfsToPassenger(sr,sc);
            if(goal == null){
                System.out.println(-1);
                return;
            }
            gas -= goal[1];
            if(gas<0){
                System.out.println(-1);
                return;
            }
            bfsToGoal(passenger[goal[0]][0],passenger[goal[0]][1],passenger[goal[0]][2],passenger[goal[0]][3]);
            int use = distance[passenger[goal[0]][2]][passenger[goal[0]][3]];
            if(use == -1 || gas-use<0){
                System.out.println(-1);
                return ;
            }
            gas+=use;
            sr = passenger[goal[0]][2];
            sc = passenger[goal[0]][3];
        }
        System.out.println(gas);
    }
}