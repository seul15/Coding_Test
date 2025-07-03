import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<int[]>[] g = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();
        for (int[] r : road) {
            g[r[0]].add(new int[]{r[1], r[2]});
            g[r[1]].add(new int[]{r[0], r[2]});
        }
        int[] d = new int[N+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.add(new int[]{1, 0}); d[1] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[1] > d[cur[0]]) continue;
            for (int[] next : g[cur[0]]) {
                int cost = cur[1] + next[1];
                if (cost < d[next[0]]) {
                    d[next[0]] = cost;
                    q.add(new int[]{next[0], cost});
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) if (d[i] <= K) cnt++;
        return cnt;
    }
}
