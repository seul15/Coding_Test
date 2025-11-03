class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=n/2; i>=0; i--){
            if(n%2==0) answer += 4*i*i;
            else answer+= 2*i+1;
        }
        
        return answer;
    }
}