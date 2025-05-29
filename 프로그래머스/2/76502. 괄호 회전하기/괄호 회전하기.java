import java.util.*;
class Solution {
    static boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='(' || c=='{' || c=='[') st.push(c);
            else if(!st.empty()){
                if((c=='}' && st.peek()=='{') ||
                   (c==')' && st.peek()=='(') ||
                   (c==']' && st.peek()=='[')) st.pop();
            }
            else return false;
        }
        return st.empty();
    }
    
    public int solution(String s) {
        int answer=0;
        for(int i=0; i<s.length(); i++){
            String rotate = s.substring(i)+s.substring(0,i);
            if(isValid(rotate)) answer++;
        }
        return answer;
    }
    
}