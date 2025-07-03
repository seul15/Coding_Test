import java.util.*;
class Solution {
    static Set<Integer> s = new HashSet<>();
    static boolean[] visited;
    static boolean check(int num){
        if(num<2) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0) return false;  
        }
        return true;
    }
    
    static void backtracking(String temp, String numbers){
        if(!temp.isEmpty() && check(Integer.parseInt(temp))){
            s.add(Integer.parseInt(temp));
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
        return s.size();
    }
}