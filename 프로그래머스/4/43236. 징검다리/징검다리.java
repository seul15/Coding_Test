import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int left =1;
        int right = distance / (rocks.length -n +1);
        
        while(left<=right){
            int mid = left + (right-left)/2;
            int remove =0;
            int prev =0;
            for(int rock : rocks){
                if(rock-prev < mid) remove++;
                else prev = rock;
            }
            // 마지막 도착 지점 체크
            if(distance - prev < mid) remove++;
            
            if(remove<=n){
                answer = mid;
                left = mid+1;
            }
            else right = mid -1;

        }
        
        return answer;
    }
}