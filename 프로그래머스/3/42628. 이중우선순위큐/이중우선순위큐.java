import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(String s: operations){
            if(s.charAt(0) == 'I'){
                int num = Integer.parseInt(s.substring(2));
                map.put(num,map.getOrDefault(num,0)+1);
            }
            else if(s.equals("D 1")){
                if(!map.isEmpty()){
                    int num = map.lastKey();
                    if(map.get(num) == 1) map.remove(num);
                    else map.put(num,map.get(num)-1);
                }
            }
            else if(s.equals("D -1")){
                if(!map.isEmpty()){
                    int num = map.firstKey();
                    if(map.get(num) == 1) map.remove(num);
                    else map.put(num,map.get(num)-1);
                }
            }
        }
        
        if(map.isEmpty()) return new int[]{0,0};
        return new int[]{map.lastKey(),map.firstKey()};
    }
}