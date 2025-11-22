import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!stack.isEmpty()){
                if(c == ')' && stack.peek() == '(') stack.pop();
                else if(c == '(') stack.push(c);
            }
            else if(c=='(') stack.push(c);
            else return false;
        }
        
        return stack.isEmpty() ? true : false;
    }
}