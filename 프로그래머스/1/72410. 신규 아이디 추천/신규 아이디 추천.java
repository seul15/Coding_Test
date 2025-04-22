class Solution {
    public String solution(String new_id) {
        String answer = "";
        // 1단계
        answer = new_id.toLowerCase();
        // 2단계
        answer = answer.replaceAll("[^a-z0-9-_.]","");
        // 3단계
        answer = answer.replaceAll("\\.{2,}", ".");
        // 4단계
        if(!answer.isEmpty() &&answer.charAt(0)=='.') answer = answer.substring(1);
        if(!answer.isEmpty() &&answer.charAt(answer.length()-1)=='.') answer=answer.substring(0,answer.length()-1);
        // 5단계
        if(answer.isEmpty()) answer+="a";
        // 6단계
        if(answer.length()>=16){
            answer=answer.substring(0,15);
            if(answer.charAt(answer.length()-1)=='.') answer=answer.substring(0,answer.length()-1);
        }
        // 7단계
        if(answer.length()<=2){
            char temp = answer.charAt(answer.length()-1);
            while(answer.length()<3){
                answer+=temp;
            }
        }
        
        return answer;
    }
}