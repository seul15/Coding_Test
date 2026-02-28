import java.util.*;

class Solution {
    class State{
        String word;
        int depth;
        
        public State(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
    
    boolean check(String A, String B){
        int count =0;
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i) != B.charAt(i)) count++;
            if(count>1) return false;
        }
        
        return (count==1)?true: false;
    }
    
    int bfs(String begin, String target, String[] words){
        boolean[] visited = new boolean[words.length];
        Queue<State> q = new LinkedList<>();
        
        q.offer(new State(begin, 0));
        while(!q.isEmpty()){
            State now = q.poll();
            String nw = now.word;
            int nd = now.depth;
            
            for(int i=0; i<words.length; i++){
                if(check(nw, words[i]) && !visited[i]){
                    if(words[i].equals(target)) return nd+1;
                    q.offer(new State(words[i],nd+1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    
    public int solution(String begin, String target, String[] words) {
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)){
                return bfs(begin, target, words);   
            }
        }
        return 0;
    }
}