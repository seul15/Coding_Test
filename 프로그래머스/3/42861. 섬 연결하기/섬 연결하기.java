import java.util.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (a,b) -> a[2]-b[2]);
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        // kruskal
        for(int i=0; i<costs.length; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];
            
            if(find(a) != find(b)){
                union(a,b);
                answer += cost;
            }
        }
        
        return answer;
    }
    
    int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]); //경로 압축
    }
    
    void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }
}