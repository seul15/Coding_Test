import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        
        // 상하 이동 최솟값
        for(int i=0; i<n; i++){
            char temp = name.charAt(i);
            int upDown = temp - 'A';
            upDown = Math.min(upDown, 'Z'-temp+1);
            
            answer += upDown;
        }
        
        // 좌우 이동 최솟값
        int leftRight = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++){
            int j= i+1;
            while(j<n && name.charAt(j) == 'A'){
                j++;
            }
            // i까지 처리하고 뒤돌아가서 j까지 처리
            leftRight = Math.min(leftRight, 2*i + (n-j));
            // 뒤돌아가서 j까지 처리하고 다시 돌아와 i까지 처리
            leftRight = Math.min(leftRight, 2* (n-j)+i);
        }
        
        return answer + leftRight;
    }
}