import java.util.*;

class Solution {
    static int second(String s){
        String[] time = s.split(":");
        return Integer.parseInt(time[0])*3600+
            Integer.parseInt(time[1])*60+
            Integer.parseInt(time[2]);
    }
    
    static String time(int t){
        int h = t/3600;
        t %= 3600;
        int m = t/60;
        int s = t%60;
        return String.format("%02d:%02d:%02d",h,m,s);
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        int play = second(play_time);
        int adv = second(adv_time);
        long[] prefix = new long[play+1];
        
        for(String log: logs){
            String[] t = log.split("-");
            int start = second(t[0]);
            int end = second(t[1]);
            prefix[start]++;
            prefix[end]--;
        }
        
        for(int i=1; i<play; i++) prefix[i] += prefix[i-1];
        for(int i=1; i<play; i++) prefix[i] += prefix[i-1];
        
        long maxview = prefix[adv-1];
        int maxtime =0;
        for(int i=adv; i<=play; i++){
            long curview = prefix[i]- prefix[i-adv];
            if(curview>maxview){
                maxview = curview;
                maxtime = i-adv+1;
            }
        }
        
        return time(maxtime);
        
    }
}