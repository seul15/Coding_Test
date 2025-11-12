import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int n: nums){
            map.put(n,0);
        }
        
        return map.size()>nums.length/2 ? nums.length/2 : map.size();
    }
}