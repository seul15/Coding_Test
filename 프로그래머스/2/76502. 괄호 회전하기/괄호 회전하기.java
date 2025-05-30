import java.util.*;

class Solution {
    static boolean check(String s){
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{') st.push(c);
            else if(!st.empty()){
                if((c==')' && st.peek()=='(') ||
                   (c==']' && st.peek()=='[') ||
                   (c=='}' && st.peek()=='{')) st.pop();
            }
            else return false;
        }
        return st.empty();
    }
    
    public int solution(String s) {
        int answer=0;
        for(int i=0; i<s.length(); i++){
            String rotate = s.substring(i) + s.substring(0,i);
            if(check(rotate)) answer++;
        }
        return answer;
    }
}