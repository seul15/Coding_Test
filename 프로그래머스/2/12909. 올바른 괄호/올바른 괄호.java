import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> bracket = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') bracket.push(s.charAt(i));
            else if(!bracket.isEmpty() && s.charAt(i)==')' && bracket.peek()=='(') bracket.pop();
            else return false;
        }

        return bracket.isEmpty();
    }
}