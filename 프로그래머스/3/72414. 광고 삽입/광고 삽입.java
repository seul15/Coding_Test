class Solution {
    static int timeToSecond(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 3600 +
               Integer.parseInt(t[1]) * 60 +
               Integer.parseInt(t[2]);
    }
    
    static String secondToTime(int sec){
        int h = sec / 3600;
        sec %= 3600;
        int m = sec / 60;
        int s = sec % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        int play = timeToSecond(play_time);
        int adv = timeToSecond(adv_time);
        long[] prefix = new long[play+1];
        for(String log: logs){
            String[] l = log.split("-");
            int start = timeToSecond(l[0]);
            int end = timeToSecond(l[1]);
            prefix[start]++;
            prefix[end]--;
        }
        for(int i=0; i<2; i++){
            for(int j=1;j<=play; j++){
                prefix[j] = prefix[j] + prefix[j-1];
            }
        }
        
        long maxView = prefix[adv - 1]; 
        int maxStartTime = 0;

        for(int i = adv; i <= play; i++){
            long currentView = prefix[i] - prefix[i - adv];
            if(currentView > maxView){
                maxView = currentView;
                maxStartTime = i - adv + 1;
            }
        }
        
        return secondToTime(maxStartTime);
    }
}