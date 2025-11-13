import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer =1; 
        Map<String,Integer> map = new HashMap<>();
        for(String[] s: clothes){
            map.put(s[1], map.getOrDefault(s[1],0)+1);
        }
        for(int num:map.values()){
            answer *= (num+1);
        }

        return answer-1;
    }
}