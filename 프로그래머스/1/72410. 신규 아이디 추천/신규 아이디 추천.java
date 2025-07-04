import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        
        answer = answer.toLowerCase();
        
        answer = answer.replaceAll("[^a-z0-9-_.]","");
        
        while(answer.contains("..")){
            answer = answer.replace("..",".");
        }
        
        if(!answer.isEmpty()&&answer.charAt(0) == '.') answer = answer.substring(1);
        if(!answer.isEmpty()&&answer.charAt(answer.length()-1)=='.') answer = answer.substring(0,answer.length()-1);
        
        if(answer.isEmpty()) answer += "a";
        
        if(answer.length() >= 16){
            answer = answer.substring(0,15);
            if(answer.charAt(answer.length()-1) == '.'){
                answer = answer.substring(0,answer.length()-1);
            } 
        }
        
        if(answer.length()<=2){
            char temp = answer.charAt(answer.length()-1);
            while(answer.length()<3){
                answer += temp;
            }
        }
        
        return answer;
    }
}