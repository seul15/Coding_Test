import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Set<Integer> lostSet = new HashSet<>();
        for(int l: lost) lostSet.add(l);
        Set<Integer> reserveSet = new HashSet<>();
        for(int r:reserve) reserveSet.add(r);
        Set<Integer> intersection = new HashSet<>(lostSet);
        
        intersection.retainAll(reserveSet);
        
        reserveSet.removeAll(intersection);
        lostSet.removeAll(intersection);
        
        ArrayList<Integer> lostList = new ArrayList<>(lostSet);
        
        for(Integer l : lostList){
            if(reserveSet.contains(l-1)){
                reserveSet.remove(l-1);
                lostSet.remove(l);
            } 
            else if(reserveSet.contains(l+1)){
                reserveSet.remove(l+1);
                lostSet.remove(l);
            }
        }
        
        return n-lostSet.size();
    }
}