import java.util.*;

class Solution {
    static int answer;
    public static void backtracking(int now, int start, int[] numbers,int target){
        if(start== numbers.length){
            if(now == target) answer++;
            return;
            }
        backtracking(now+numbers[start], start+1, numbers, target);
        backtracking(now-numbers[start],start+1,numbers,target);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        backtracking(0,0,numbers,target);
        return answer;
    }
}