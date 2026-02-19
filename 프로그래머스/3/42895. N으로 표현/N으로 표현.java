import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] dp = new HashSet[9];
        for(int i=0; i<9; i++){
            dp[i] = new HashSet<Integer>();
        }
        
        String temp = Integer.toString(N);
        if(Integer.valueOf(temp) == number) return 1;
        dp[1].add(Integer.valueOf(temp)); // 5만 존재
        for(int k=2; k<9; k++){
            temp += Integer.toString(N);
            if(Integer.valueOf(temp) == number) return k;
            dp[k].add(Integer.valueOf(temp));
        
            for(int i=1; i<k; i++){
                for(int num1 : dp[i]){
                    for(int num2: dp[k-i]){
                        if(Math.abs(num1 + num2) <= 100000) dp[k].add(num1 + num2);
                        if(Math.abs(num1 - num2) <= 100000) dp[k].add(num1 - num2);
                        if(Math.abs(num1 * num2) <= 100000) dp[k].add(num1 * num2);
                        
                        if(num2 != 0 && Math.abs(num1/num2) <= 100000) dp[k].add(num1/num2);
                        
                        if(dp[k].contains(number)) return k;
                    }
                }
                
                
//                 Iterator iter1 = dp[i].iterator();
//                 while(iter1.hasNext()){
//                     int num1 = iter1.next();
//                     Iterator iter2 = dp[k-i].iterator();
//                     while(iter2.hasNext()){
//                         int num2 = iter2.next();
//                         if(num1 + num2 == number ||
//                           num1 - num2 == number ||
//                           num1 * num2 == number ||
//                           num1 / num2 == number) return k;
                        
//                         dp[k].add(num1 + num2);
//                         dp[k].add(num1 - num2);
//                         dp[k].add(num1 * num2);
//                         dp[k].add(num1 / num2);
//                     }
//                 }
            }
        }
        return -1;
    }
}