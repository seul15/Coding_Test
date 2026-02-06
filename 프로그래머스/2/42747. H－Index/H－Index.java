import java.util.*;

class Solution {
    public int solution(int[] citations) {
       // citations 정렬
        Arrays.sort(citations);
        
        // 모든 원소가 0인 경우(예외 처리)
        if(citations[citations.length-1] == 0) return 0;
        
        // 원소 순서가 원소 내용보다 커지는 순간을 체크
        for(int i=citations.length-1; i>=0; i--){
            if(citations.length-i>citations[i]) return citations.length-i-1;
        }
        
        // 모든 원소가 최저 인용 횟수보다 클때
        return citations.length;
    }
}