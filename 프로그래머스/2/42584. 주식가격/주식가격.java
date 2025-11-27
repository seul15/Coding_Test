import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> s = new Stack<>();
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            while(!s.isEmpty() && prices[s.peek()]>prices[i]){
                int temp = s.pop();
                answer[temp] = i-temp;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int temp = s.pop();
            answer[temp] = prices.length-1 - temp;  
        }
        return answer;
    }
}