import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int num = info.length;
        
        int answer = 0;
        for(int i=0; i<num; i++){
            answer += info[i][0];
        }
        
        int[] dp = new int[m]; // A가 절약한 흔적
        Arrays.fill(dp,0);
        
        for(int i=0; i<num; i++){
            if(info[i][1]>m-1) continue;
            for(int w= m-1; w>=info[i][1]; w--){
                dp[w] = Math.max(dp[w],dp[w-info[i][1]]+info[i][0]);
            }
        }
        
        int save = 0;
        for(int w=0; w<=m-1; w++){
            save = Math.max(save,dp[w]);
        }
        
        answer -= save;
        
        return (answer >= n) ? -1 : answer;
    }
}