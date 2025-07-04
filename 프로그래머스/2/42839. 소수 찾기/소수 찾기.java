import java.util.*;

class Solution {
    static boolean[] visited;
    static Set<Integer> n = new HashSet<>();
    
    static boolean check(int num){
        if(num<2) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i ==0) return false;
        }
        return true;
    }
    
    static void backtracking(String temp, String numbers){
        if(!temp.isEmpty() && check(Integer.parseInt(temp))){
            n.add(Integer.parseInt(temp));
        }
        for(int i=0; i<numbers.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            backtracking(temp+numbers.charAt(i),numbers);
            visited[i] = false;
        }
    }
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        backtracking("",numbers);
        return n.size();
    }
}