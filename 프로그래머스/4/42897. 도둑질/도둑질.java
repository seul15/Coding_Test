class Solution {
    public int solution(int[] money) {
        int[] dp1 = new int[money.length]; // 1을 선택하는 경우
        int[] dp2 = new int[money.length]; // 1을 선택하지 않는 경우
        
        dp1[0] = money[0];
        dp2[1] = money[1];
        
        // dp1 배열 채우기
        for(int i=1; i<money.length; i++){
            if(i==1 || i==money.length-1) dp1[i] = dp1[i-1];
            else dp1[i] = Math.max(dp1[i-2]+money[i], dp1[i-1]);
        }
        
        // dp2 배열 채우기
        for(int i=2; i<money.length; i++){
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+money[i]);
        }
        
        return Math.max(dp1[money.length-1], dp2[money.length-1]);
        
        // 지금 방법으론 3개의 집이 존재할때 3번의 집이 선택되는 케이스가 존재하지 않음...
        // 3번째 집을 돌 때 영향을 주는 코드 제거
    }
}