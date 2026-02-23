class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m+1][n+1];
        boolean[][] puddle = new boolean[m+1][n+1];
        
        for(int[] p : puddles){
            puddle[p[0]][p[1]] = true;
        }
        
        for(int y=1; y<=n; y++){
            for(int x=1; x<=m; x++){
                if(x == 1 && y == 1) dp[x][y] = 1;
                else if(puddle[x][y]) dp[x][y] = 0;
                else if((x==1 && dp[x][y-1] ==0) || y==1 && dp[x-1][y] == 0) dp[x][y] = 0;
                else if(x==1 || y==1) dp[x][y] = 1;
                else{
                    dp[x][y] = (dp[x][y-1]+dp[x-1][y]) % 1000000007;
                }
            }
        }
        
        return dp[m][n];
    }
}