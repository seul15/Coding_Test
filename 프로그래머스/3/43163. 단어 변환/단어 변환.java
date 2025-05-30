import java.util.*;

class Solution {
    static Map<String,Integer> dist;
    
    static boolean check(String s1, String s2){
        int count =0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count==1;
    }
    
    static void bfs(String begin, String target, String[] words){
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        dist.put(begin,0);
        
        while(!q.isEmpty()){
            String cur = q.poll();
            if(cur.equals(target)) return;
            for(String next: words){
               if(dist.get(next) == null && check(cur,next)){
                   q.offer(next);
                   dist.put(next,dist.get(cur)+1);
               } 
            }
        }
        return;
    }
    
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) return 0;
        dist = new HashMap<>();
        
        bfs(begin,target,words);
        
        return dist.getOrDefault(target,0);
    }
}