import java.util.*;

class Solution {
    int[][] dp;
    
    void dfs(int k, ArrayList<Integer>[] tree, int[] sales){
        if(tree[k].isEmpty()){
            dp[k][0] = 0;
            dp[k][1]= sales[k-1];
            return;
        }
    
        int sum=0;
        int cost= Integer.MAX_VALUE;
        boolean hasattached = false;
        
        for(int t: tree[k]){
            dfs(t,tree,sales);
            
            sum += Math.min(dp[t][0],dp[t][1]);
            if(dp[t][0] >= dp[t][1]) hasattached = true;
        }
        
        dp[k][1] = sales[k-1] + sum;
        dp[k][0] = sum;
        if(!hasattached){
            for(int t: tree[k]){
                if(dp[t][0] < dp[t][1]) cost = Math.min(cost, dp[t][1] - Math.min(dp[t][0],dp[t][1]));   
            }
            
            dp[k][0] += cost;
        }
    }
    
    public int solution(int[] sales, int[][] links) {
        int emp = sales.length;
        dp = new int[emp+1][2];
        
        ArrayList<Integer>[] tree = new ArrayList[emp+1];
        
        for(int i=0; i<emp; i++){
            tree[i+1] = new ArrayList<>();
        }
        
        for(int[] link: links){
            int parent = link[0];
            int child = link[1];
            tree[parent].add(child);
        }
        
        dfs(1,tree,sales);
        return Math.min(dp[1][0],dp[1][1]);
    }
}