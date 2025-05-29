import java.util.*;

class Solution {
    static Map<String,Integer> dist;
    
    static boolean check(String s1, String s2){
        int count=0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) count++; 
        }
        return count==1;
    }
    
    static int bfs(String begin, String target, String[] words){
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        dist.put(begin,0);
        
        while(!q.isEmpty()){
            String current = q.poll();
            if(current.equals(target)) return dist.get(current); 
            for(String w: words){
                if(dist.get(w) == null && check(current,w)){
                    q.offer(w);
                    dist.put(w,dist.get(current)+1);
                }
            }
        }
        return 0;
    }
    
    
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) return 0;
        dist = new HashMap<>();
        
        return bfs(begin,target,words);
    }
}