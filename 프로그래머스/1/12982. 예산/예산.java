import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        while(budget>0 && d.length >answer){
            if(budget-d[answer]>=0){
                budget-=d[answer];
                answer++;
            } 
            else break;
        }
        return answer;
    }
}