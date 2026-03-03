import java.util.*;

class Solution {
    List<String> answer = new LinkedList<>();
    boolean[] visited;
    boolean finish;
    
    void dfs(String now, int count, Map<String, List<Integer>> graph, String[][] tickets){
        if(count == tickets.length){
            finish = true;
            return;
        } 
        
        for(int idx : graph.getOrDefault(now, new LinkedList<>())){
            if(visited[idx]) continue;
            visited[idx] = true;
            answer.add(tickets[idx][1]);
            dfs(tickets[idx][1], count+1, graph, tickets);
            if(finish) return;
            answer.remove(answer.size()-1);
            visited[idx] = false;
        }
    }
    
    public List<String> solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        Map<String, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<tickets.length; i++){
            String start = tickets[i][0];
            graph.computeIfAbsent(start, k -> new LinkedList<>()).add(i);
        }
        
        // graph 정렬
        for(String key : graph.keySet()){
            graph.get(key).sort((a,b)->
                                tickets[a][1].compareTo(tickets[b][1]));
        }
        
        answer.add("ICN");
        dfs("ICN", 0, graph, tickets);
        
        return answer;
    }
}