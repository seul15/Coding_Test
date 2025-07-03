class Solution {
    static int second(String time){
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 3600 +
            Integer.parseInt(temp[1]) * 60+
            Integer.parseInt(temp[2]);
    }
    
    static String time(int num){
        int h = num/3600;
        num %= 3600;
        int m = num /60;
        int s = num %60;
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
        
        for(int i=1; i<=play; i++) prefix[i] += prefix[i-1];
        for(int i=1; i<=play; i++) prefix[i] += prefix[i-1];
        
        long maxview = prefix[adv-1];
        int answer = 0;
        for(int i=adv; i<=play; i++){
            long cur = prefix[i] - prefix[i-adv];
            if(cur>maxview){
                maxview = cur;
                answer = i-adv+1;
            }
        }
        
        return time(answer);
    }
}