import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        // 작업 일수 계산
        for(int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int days = (int)Math.ceil((double)remain / speeds[i]);
            q.offer(days);
        }
        
        while(!q.isEmpty()){
            int now = q.poll();
            int count =1;
            while(!q.isEmpty() && q.peek()<=now){
                q.poll();
                count++;
            }
            answer.add(count);
        }
        
        return answer;
    }
}