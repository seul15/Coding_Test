import java.util.*;

class Solution {
    int bfs(String begin, String target, String[] words, boolean[] visited){
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{begin,0});
        
        while(!q.isEmpty()){
            Object[] n = q.poll();
            String now = (String)n[0];
            int change = (int)n[1];
            if(now.equals(target)) return change;
            for(int i=0; i<words.length; i++){
                if(!visited[i] && check(now,words[i])){
                    q.offer(new Object[]{words[i],change+1});
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    
    boolean check(String a, String b){
        int dif =0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) dif++;
            if(dif>=2) return false;
        }
        if(dif==1) return true;
        else return false;
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        return bfs(begin, target, words, visited);
    }
}