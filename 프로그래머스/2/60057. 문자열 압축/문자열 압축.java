class Solution {
    public int solution(String s){
        int answer = s.length();

        for(int i=1; i<=s.length()/2; i++){
            int now_length = 0;
            String temp1 = s.substring(0,i);
            int count=1;
            for(int j=i; j<s.length(); j+=i){
                String temp2;
                if(j+i<=s.length()) temp2= s.substring(j,j+i);
                else temp2=s.substring(j);

                if(temp1.equals(temp2)) {
                    count++;
                    if(i+j>=s.length()){
                        now_length +=i;
                        if(count>1) now_length += String.valueOf(count).length();
                    }
                }
                else{
                    now_length +=i;
                    if(count>1) now_length += String.valueOf(count).length();
                    temp1 = temp2;
                    count=1;

                    if (j + i >= s.length()) {
                        now_length += temp2.length();
                    }
                }
            }
            answer = Math.min(answer,now_length);
        }
        return answer;
    }
}
