import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int cur = 0, index = 0, total = 0, n = jobs.length;

        while (index < n || !pq.isEmpty()) {
            while (index < n && jobs[index][0] <= cur) pq.add(jobs[index++]);
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                cur += job[1];
                total += cur - job[0];
            } else {
                cur = jobs[index][0];
            }
        }
        return total / n;
    }
}
