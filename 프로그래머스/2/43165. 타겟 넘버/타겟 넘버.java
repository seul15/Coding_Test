class Solution {
    int answer;
    
    void dfs(int now, int index, int[] numbers, int target){
        if(index == numbers.length){
            if(now == target) answer++;
            return;
        }
        
        // 다음 요소를 +하는 
        dfs(now+numbers[index], index+1, numbers,target);
        // 다음 요소를 -하는 경우
        dfs(now-numbers[index], index+1, numbers, target);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0,0,numbers, target);
        
        return answer;
    }
}