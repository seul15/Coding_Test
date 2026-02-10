import java.util.*;

class Solution {
    char[] digits;
    boolean[] visited;
    Set<Integer> answer = new HashSet<>();
    
    boolean isPrime(int num){
        if(num<2) return false;
        if(num == 2) return true;
        for(int i=2; i<=(int)Math.floor(Math.sqrt(num)); i++){
            if(num%i == 0) return false;
        }
        return true;
    }
    
    void dfs(String current){
        if(current.length() >= 1){
           int c = Integer.parseInt(current);
            if(isPrime(c)){
                answer.add(c);
            }
        }
        
        for(int idx=0; idx<digits.length; idx++){
            if(visited[idx] == false){
                visited[idx] = true;
                dfs(current+digits[idx]);
                visited[idx] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        digits = numbers.toCharArray();
        visited = new boolean[digits.length];
        
        dfs("");
        
        return answer.size();
    }
}