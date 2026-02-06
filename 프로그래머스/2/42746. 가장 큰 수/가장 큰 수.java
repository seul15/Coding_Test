import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        // String 배열로 변환
        String[] num = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            num[i] = String.valueOf(numbers[i]);
        }
        
        // ab, ba 중 큰 원소가 앞에 오도록 정렬
        Arrays.sort(num,(a,b) -> (b+a).compareTo(a+b));
        
        // 만일 배열이 모두 0으로 구성되어 있을 경우 0 리턴
        if(num[0].equals("0")) return "0";
        
        // answer에 정렬한 배열 원소 모두 추가
        for(int i=0; i<num.length; i++){
            answer += num[i];
        }
        
        return answer;
    }
}