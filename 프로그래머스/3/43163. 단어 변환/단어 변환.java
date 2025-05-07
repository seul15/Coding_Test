import java.util.*;

class Solution {
    public int bfs(String s,String target,String[] words, int[] visited){
        Queue<Integer>q = new LinkedList<>();
        
        q.add(words.length);
        visited[words.length] = 0;
        while(!q.isEmpty()){
            int current_index = q.remove();
            String current;
            if(current_index == words.length) current = s;
            else current = words[current_index];

            for(int i=0; i<words.length; i++){
                if(visited[i]!= -1) continue;
                int count=0;
                for(int j=0; j<words[i].length(); j++){
                    if(current.charAt(j) != words[i].charAt(j)) count++;
                    if(count>1) break;
                }

                if(count==1){
                    q.add(i);
                    visited[i] = visited[current_index]+1;
                    if(words[i].equals(target)) return visited[i];
                }
            }
        }
        return 0;
    }
    
    
    public int solution(String begin, String target, String[] words) {
        boolean found = false;
        int[] visited = new int[words.length+1];
        Arrays.fill(visited,-1);
        
        for(String word:words){
            if(word.equals(target)){
                found = true;
                break;
            }
        }
        if(!found) return 0; // target 만들기 불가
        
        return bfs(begin,target,words,visited);
    }
}