class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        // 자르는 단위
        for(int i=1; i<=s.length()/2; i++){
            int sub_num = 0;
            String temp1 = s.substring(0,i);
            int count = 1; // 반복되는 횟수
            for(int j=i; j<s.length(); j+=i){
                // 현재 인덱스 + 자르는 단위가 문자열 길이를 넘지 않도록
                String temp2;
                if(j+i>s.length()){
                    temp2 = s.substring(j);
                }
                else temp2 = s.substring(j,j+i);
                
                if(temp2.equals(temp1)) count++;
                else{
                    if(count == 1) sub_num+=temp1.length();
                    else sub_num+=(temp1.length() + String.valueOf(count).length());
                    temp1 = temp2;
                    count = 1;
                }
            }
            if (count > 1) {
                sub_num += String.valueOf(count).length() + temp1.length();
            } else {
                sub_num += temp1.length();
            }
            
            answer = Math.min(answer, sub_num);
        }
        
        return answer;
    }
}