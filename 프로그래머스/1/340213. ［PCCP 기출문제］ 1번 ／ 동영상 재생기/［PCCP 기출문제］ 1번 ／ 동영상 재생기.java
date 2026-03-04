class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] p = pos.split(":");
        int now = Integer.valueOf(p[0])*60 + Integer.valueOf(p[1]); 
        String[] s = op_start.split(":");
        String[] e = op_end.split(":");
        String[] l = video_len.split(":");
        int start = Integer.valueOf(s[0])*60 + Integer.valueOf(s[1]);
        int end = Integer.valueOf(e[0])*60 + Integer.valueOf(e[1]);
        int len = Integer.valueOf(l[0])*60 + Integer.valueOf(l[1]);
        
        
        for(String command: commands){
            // 오프닝 건너뛰기
            if(start<=now && now<=end) now = end;
            
            if(command.equals("prev")){
                if(now<10) now =0;
                else now -=10;
            }
            else if(command.equals("next")){
                if(now+10>len) now = len;
                else now += 10;
            }
            
            // 오프닝 건너뛰기
            if(start<=now && now<=end) now = end;
        }
        
        return String.format("%02d",now/60) + ":" + String.format("%02d",now%60);
    }
}