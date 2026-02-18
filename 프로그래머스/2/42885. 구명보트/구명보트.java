import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int right = people.length-1;
        int left =0;
        while(right>=left){
            int weight = people[right];
            right--;
            if(limit >= weight+people[left]){
                left++;
            }
            answer++;
        }
        
        return answer;
    }
}