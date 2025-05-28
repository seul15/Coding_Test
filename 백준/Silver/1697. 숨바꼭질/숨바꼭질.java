import java.util.*;
import java.io.*;
public class Main{
    static boolean[] visited;
    static int bfs(int now, int target , int count){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{now,count});
        visited[now] = true;
        while(!q.isEmpty()){
            int[] current = q.poll();
            if(current[0] == target) return current[1];
            if(current[0]>target) {
                if (current[0] - 1 <=100000 && current[0] - 1 >=0 && !visited[current[0] - 1]) {
                    q.offer(new int[]{current[0] - 1, current[1] + 1});
                    visited[current[0] - 1] = true;
                }
            }
            else{
                if (current[0] *2 <=100000 && current[0] *2>=0 && !visited[current[0]*2]) {
                    q.offer(new int[]{current[0] *2, current[1] + 1});
                    visited[current[0] *2] = true;
                }
                if (current[0] + 1 <=100000 && current[0]+1>=0 && !visited[current[0] +1]) {
                    q.offer(new int[]{current[0] +1, current[1] + 1});
                    visited[current[0] + 1] = true;
                }
                if (current[0] - 1 <=100000 && current[0]-1>=0 && !visited[current[0] - 1]) {
                    q.offer(new int[]{current[0] - 1, current[1] + 1});
                    visited[current[0] - 1] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        System.out.println(bfs(N,K,0));
    }
}
