import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String,Set<String>> reports = new HashMap<>();
        Map<String,Integer> count = new HashMap<>();
        
        for(String r: report){
            String[] users = r.split(" ");
            String from = users[0];
            String to = users[1];
            if(reports.get(from) == null) reports.put(from,new HashSet<>());
            reports.get(from).add(to);
        }
        
        for(Set<String> r: reports.values()){
            for(String to: r){
                count.put(to,count.getOrDefault(to,0)+1);
            }
        }
        
        
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++){
            String user = id_list[i];
            Set<String> to = reports.getOrDefault(user,new HashSet<>());
            for(String t: to){
                if(count.getOrDefault(t,0)>=k) answer[i]++; 
            }
        }
        
        
        return answer;
    }
}