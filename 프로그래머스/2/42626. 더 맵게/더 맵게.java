import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int s : scoville) q.add(s);
        int cnt = 0;
        while (q.size() > 1 && q.peek() < K) {
            q.add(q.poll() + q.poll() * 2);
            cnt++;
        }
        return q.peek() >= K ? cnt : -1;
    }
}
