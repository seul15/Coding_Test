import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer = 0;
    static boolean check(String s1, String s2){
        int count=0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) count++;
            if(count>1) return false;
        }
        if(count==1) return true;
        else return false;
    }
    
    static void dfs(String begin, String target, String words[],int count){
        if(begin.equals(target)){
            answer = count;
            return;
        }
        
        for(int i=0; i<words.length; i++){
            String current = words[i];
            if(check(begin,current) && !visited[i]){
                visited[i] = true;
                dfs(current,target,words,count+1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        dfs(begin,target,words,0);
        
        return answer;
    }
}