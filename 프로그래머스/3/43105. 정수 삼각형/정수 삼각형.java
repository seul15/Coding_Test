import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        int height = triangle.length;
        int width = triangle[height-1].length;
        int[][] dp = new int[height][width];
        
        for(int i=0; i<height; i++){
            if(i==0) dp[0][0] = triangle[0][0];
            else if(i==1){
                dp[1][0] = dp[0][0] + triangle[1][0];
                dp[1][1] = dp[0][0] + triangle[1][1];
            }
            else{
                for(int w = 0; w<=i; w++){
                    if(w == 0) dp[i][0] = dp[i-1][0] + triangle[i][0];
                    else if(w == i) dp[i][w] = dp[i-1][w-1] + triangle[i][w];
                    else dp[i][w] = Math.max(dp[i-1][w],dp[i-1][w-1]) + triangle[i][w];
                }
            }
        }
        
        for(int d : dp[height-1]) answer = Math.max(d, answer);
        
        return answer;
    }
}