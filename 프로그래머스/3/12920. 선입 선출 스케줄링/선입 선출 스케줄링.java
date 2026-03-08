import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int total =0;
        for(int core: cores){
            total += core;
        }
        total /= cores.length;
        
        int left = 0;
        int right = total *n;
        
        while(left <= right){
            int sum=0;
            int mid = left + (right - left)/2;
            for(int core: cores){
                sum += (mid/core + 1);
            }
            
            if(sum>=n) right = mid -1;
            else left = mid+1;
        }

        // 그 전까지 몇 개가 처리되고 있는지 체크
        int remain = n;
        for(int core: cores){
            remain -= (right/core +1);
        }
        
        for(int idx = 0; idx<cores.length; idx++){
            if((right+1)% cores[idx] == 0) remain--;
            if(remain == 0) return idx+1;
        }
        
        return 0;
    }
}