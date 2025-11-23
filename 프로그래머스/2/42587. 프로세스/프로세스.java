import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        int[] freq = new int[10];
        
        for(int i=0; i<priorities.length; i++){
            q.offer(new int[]{i,priorities[i]});
            freq[priorities[i]]++;
        }
        
        int curmax = 9;
        while(curmax>0 && freq[curmax] == 0) curmax--;
        
        int cur =0;
        while(!q.isEmpty()){
            int[] c = q.poll();
            int index = c[0];
            int prior = c[1];
            
            if(prior == curmax){
                cur++;
                freq[curmax]--;
                
                if(index == location) return cur;
                
                if(freq[curmax] == 0){
                    while(curmax>0 && freq[curmax] == 0){
                        curmax--;
                    }
                }
            }
            else q.offer(new int[]{index,prior});
        }
        return -1;
    }
}