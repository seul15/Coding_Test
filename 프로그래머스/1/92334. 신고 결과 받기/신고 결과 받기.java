import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String,Set<String>> reports = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        
        for(String r : report){
            String[] s = r.split(" ");
            String from = s[0]; String to = s[1];
            if(reports.get(from) == null) reports.put(from,new HashSet<>());
            reports.get(from).add(to);
        }
        
        for(Set<String> r :reports.values()){
            for(String user: r){
                count.put(user, count.getOrDefault(user,0) + 1);
            }
        }
        
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++){
            String user = id_list[i];
            Set<String> to = reports.getOrDefault(user, new HashSet<>());
            for(String s :to){
                if(count.get(s)>=k) answer[i]++;
            }
        }
        return answer;
    }
}