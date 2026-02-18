import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> d = new ArrayDeque<>();
        d.offerLast(number.charAt(0));
        
        for(int i=1; i<number.length(); i++){
            Character current = number.charAt(i);
            
            while(!d.isEmpty() &&
                 d.peekLast()<current &&
                 k>0){
                d.pollLast();
                k--;
            }
            d.offerLast(current);
        }
        
        while(k>0){
            d.pollLast();
            k--;
        }
        
        StringBuilder answer = new StringBuilder();
        while(!d.isEmpty()){
            answer.append(d.pollFirst());
        }
        
        return answer.toString();
    }
}