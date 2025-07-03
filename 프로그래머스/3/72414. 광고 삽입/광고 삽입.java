import java.util.*;

class Solution {
    static int second(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 3600 +
            Integer.parseInt(t[1])*60 +
            Integer.parseInt(t[2]);
    }
    
    static String time(int sec){
        int h = sec/3600;
        sec %= 3600;
        int m = sec/60;
        int s = sec%60;
        return String.format("%02d:%02d:%02d",h,m,s);
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        int play = second(play_time);
        int adv = second(adv_time);
        long[] prefix = new long[play+1];
        
        for(String log: logs){
            String[] l = log.split("-");
            int start = second(l[0]);
            int end = second(l[1]);
            prefix[start]++;
            prefix[end]--;
        }
        
        for(int i=1; i<=play; i++) prefix[i] += prefix[i-1];
        for(int i=1; i<=play; i++) prefix[i] += prefix[i-1];
        
        long maxview = prefix[adv];
        int maxtime =0;
        for(int i= adv; i<=play; i++){
            long curview = prefix[i] - prefix[i-adv];
            if(curview> maxview){
                maxview = curview;
                maxtime = i-adv+1;
            }
        }
        return time(maxtime);
    }
}